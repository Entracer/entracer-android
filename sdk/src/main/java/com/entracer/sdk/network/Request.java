package com.entracer.sdk.network;

import com.entracer.sdk.util.EntracerLog;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/**
 * Request class to be used with http service.
 */
public class Request {

    String token;
    String base;
    String path;
    String query;
    String method;
    Map<String, Object> data;

    URL requestUrl;

    public JSONObject responseObject;

    /***
     * Initializes Request object with required parameters to send api call.
     * @param token api token.
     * @param base base url.
     * @param path url path.
     * @param method request method.
     * @param data request data.
     */
    public Request(String token, String base, String path, String query, String method, Map<String, Object> data) {

        this.base = base;
        this.path = path;
        this.query = query;
        this.method = method;
        this.data = data;

        try {
            URI baseUri = new URI(base);
            URI uri = new URI(baseUri.getScheme(), baseUri.getAuthority(), path, query, baseUri.getFragment());
            this.requestUrl = uri.toURL();
        } catch (URISyntaxException e) {
            EntracerLog.e("ERROR: forming request url", e);
        } catch (MalformedURLException e) {
            EntracerLog.e("ERROR: forming request url", e);
        }
    }

}
