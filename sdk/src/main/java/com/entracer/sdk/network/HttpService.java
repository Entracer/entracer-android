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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * HttpService class performs REST api requests for Entracer api.
 */
public class HttpService {

    private Request request;
    private ResponseListener listener;
    private int responseCode;

    /**
     * Constructs http service instance with request object.
     * @param request Request object.
     * @param listener Response listener.
     */
    public HttpService(Request request, ResponseListener listener) {
        this.request = request;
        this.listener = listener;
    }

    /**
     * Sends API request with request parameters.
     * @throws Exception exception.
     */
    public void sendRequest() throws Exception {

        Map<String, String> headers = this.buildHeaders(request.token);
        this.sendRequest(request.requestUrl, request.method, request.data, headers);
    }

    /**
     * Sends API request with request url, method, parameters, and headers.
     * @param requestUrl request url.
     * @param method request method.
     * @param params post data parameters.
     * @param headers api headers.
     * @throws Exception exception.
     */
    private void sendRequest(final URL requestUrl, String method, Map<String, Object> params, Map<String, String> headers)
            throws Exception {

        EntracerLog.d("Request method: " + method + "url: " + requestUrl + " params: " + params.toString());
        URLConnection connection = null;
        if (requestUrl.getProtocol().equals("https")) {
            connection = (HttpsURLConnection) requestUrl.openConnection();
            ((HttpsURLConnection) connection).setRequestMethod(method);
        } else {
            connection = (HttpURLConnection) requestUrl.openConnection();
            ((HttpURLConnection) connection).setRequestMethod(method);
        }
        // sets request headers
        for (Map.Entry<String, String> entry : headers.entrySet())
        {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        if (method != RequestMethod.GET) {
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

        if (requestUrl.getProtocol().equals("https")) {
            this.responseCode = ((HttpsURLConnection) connection).getResponseCode();
        } else {
            this.responseCode = ((HttpURLConnection) connection).getResponseCode();
        }
        
        if (this.responseCode == HttpsURLConnection.HTTP_OK) {
            // successful response status
            InputStream in = connection.getInputStream();
            String responseString = StringUtils.inputStreamToString(in);
            JSONObject responseObject = new JSONObject(responseString);
            EntracerLog.d("Response: " + responseObject.toString());
            in.close();

            this.request.responseObject = responseObject;
            this.listener.onResponse(this.request);
        } else {
            // error response
            EntracerLog.e("Error Response for url: " + requestUrl);
            this.listener.onFailure(this.request);
        }
    }

    /**
     * Builds request headers with api token.
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
