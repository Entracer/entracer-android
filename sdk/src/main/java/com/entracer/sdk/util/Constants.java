package com.entracer.sdk.util;

/**
 * Defines Entracer SDK constants such as API urls, end points, end paths, etc.
 */
public class Constants {

    /***
     * API urls, and version.
     */
    public static class API {
        public static final String BASE_PATH = "https://app.entracer.com";
        public static final String VERSION = "/api/v1";
        public static final String TAG = "Entracer";
    }

    /**
     * API end points.
     */
    public static class EndPoints {
        public static final String EVENTS = "/events";
        public static final String PEOPLE = "/people";
        public static final String ORGANISATIONS = "/organisations";
        public static final String TRIGGER = "/trigger";
    }

    /**
     * API end paths.
     */
    public static class EndPaths {
        public static final String CREATE_OR_UPDATE = "/create_or_update";
    }

    /**
     * Event channel types examples.
     */
    public static class EventChannel {
        public static final String WEB = "Web";
        public static final String MOBILE = "Mobile";
        public static final String SOCIAL_MEDIA = "Social Media";
        public static final String SUPPORT = "Support";
    }

    /**
     * Event device types examples.
     */
    public static class EventDevice {
        public static final String WINDOWS = "Windows";
        public static final String MAC = "Mac";
        public static final String ANDROID = "Android";
        public static final String IOS = "iOS";
    }

}
