package com.entracer.sdk.network;

import android.icu.util.Output;
import android.util.Log;

import com.entracer.sdk.util.EntracerLog;
import com.entracer.sdk.util.StringUtils;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * HttpService class performs REST api requests for Entracer api.
 */
public class HttpService {

    ResponseListener listener;
    int responseCode;

    public JSONObject sendRequest(String requestUrl, RequestMethod method, JSONObject params, Map<String, String> headers)
            throws Exception {

        final URL url = new URL(requestUrl);
        EntracerLog.d("Request method: " + method.value() + "url: " + requestUrl + " params: " + params.toString());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // sets request method, headers
        connection.setRequestMethod(method.value());
        for (Map.Entry<String, String> entry : headers.entrySet())
        {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        if (method.value() != RequestMethod.GET) {
            connection.setDoOutput(true);
        }
        connection.setDoInput(true);

        // send post data
        OutputStream out = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(out, "UTF-8"));
        writer.write(StringUtils.getPostDataString(params));

        writer.flush();
        writer.close();
        out.close();

        this.responseCode = connection.getResponseCode();

        if (this.responseCode == HttpsURLConnection.HTTP_OK) {
            // successful response status
            InputStream in = connection.getInputStream();
            String responseString = StringUtils.inputStreamToString(in);
            JSONObject responseObject = new JSONObject(responseString);
            EntracerLog.d("Response: " + responseObject.toString());
            in.close();

            return responseObject;
        } else {
            // error response
            EntracerLog.e("Error Response for url: " + requestUrl);
            return null;
        }
    }

    /**
     * Builds request headers with api token.
     *
     * @param token api token.
     * @return request headers.
     */
    public Map<String, String> buildHeaders(String token) {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Token token=" + token);
        return headers;
    }
}
