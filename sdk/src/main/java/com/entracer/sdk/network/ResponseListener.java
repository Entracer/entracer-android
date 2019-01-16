package com.entracer.sdk.network;

/**
 * Response listener interface to be called on request completion.
 */
public interface ResponseListener {

    public void onResponse(Request request);

    public void onFailure(Request request);

}
