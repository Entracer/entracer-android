package com.entracer.sdk.network;

/**
 * REST api request methods.
 */
public interface RequestMethod {

    String GET = "GET";
    String POST = "POST";
    String PUT = "PUT";
    String DELETE = "DELETE";

    String value();
}
