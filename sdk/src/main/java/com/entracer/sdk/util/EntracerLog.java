package com.entracer.sdk.util;

import android.util.Log;

/**
 * Log class controls and displays logging for Entracer SDK.
 */
public class EntracerLog {

    /**
     * Priority constant for ignoring all logs.
     */
    public static final int NONE = -1;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 0;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 1;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Keeps current active log level.
     */
    private static int logLevel = DEBUG;

    /**
     * Entracer SDK logs tag.
     */
    private static String entracerTag = Constants.API.TAG;

    /**
     * Sets active log level.
     * @param level log level.
     */
    public static void setLevel(int level) {
        if (level > DEBUG) {
            level = DEBUG;
        }
        logLevel = level;
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param message message to be logged.
     */
    public static void e(String message) {
        if (shouldDisplayLog(DEBUG)) {
            Log.e(entracerTag, message);
        }
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param message message to be logged.
     * @param throwable an exception to log.
     */
    public static void e(String message, Throwable throwable) {
        if (shouldDisplayLog(DEBUG)) {
            Log.e(entracerTag, message, throwable);
        }
    }

    /**
     * Send an {@link #WARN} log message.
     * @param message message to be logged.
     */
    public static void w(String message) {
        if (shouldDisplayLog(DEBUG)) {
            Log.w(entracerTag, message);
        }
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param message message to be logged.
     * @param throwable an exception to log.
     */
    public static void w(String message, Throwable throwable) {
        if (shouldDisplayLog(DEBUG)) {
            Log.w(entracerTag, message, throwable);
        }
    }

    /**
     * Send an {@link #INFO} log message.
     * @param message message to be logged.
     */
    public static void i(String message) {
        if (shouldDisplayLog(DEBUG)) {
            Log.i(entracerTag, message);
        }
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param message message to be logged.
     * @param throwable an exception to log.
     */
    public static void i(String message, Throwable throwable) {
        if (shouldDisplayLog(DEBUG)) {
            Log.i(entracerTag, message, throwable);
        }
    }

    /**
     * Send an {@link #DEBUG} log message.
     * @param message message to be logged.
     */
    public static void d(String message) {
        if (shouldDisplayLog(DEBUG)) {
            Log.d(entracerTag, message);
        }
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param message message to be logged.
     * @param throwable an exception to log.
     */
    public static void d(String message, Throwable throwable) {
        if (shouldDisplayLog(DEBUG)) {
            Log.d(entracerTag, message, throwable);
        }
    }

    /**
     * Returns true if logs of given level can be displayed.
     * @param level level of logs to display.
     * @return true if log level can be displayed.
     */
    private static boolean shouldDisplayLog(int level) {
        return logLevel >= level;
    }


}
