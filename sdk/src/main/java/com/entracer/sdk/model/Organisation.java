package com.entracer.sdk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

enum OrganisationStatus {
    New, Active, Dormant, Blacklisted
}

/**
 * Model class to represent Organisation objects.
 */
public class Organisation {

    public Map data;

    /**
     * Constructs organisation object with data dictionary.
     * @param data dictionary.
     */
    public Organisation(Map data) {
        this.data = data;
    }

    public String getId() {
        return (String) data.get("id");
    }

    public void setId(String value) {
        data.put("id", value);
    }

    public String getStatus() {
        return (String) data.get("status");
    }

    public void setStatus(String value) {
        data.put("status", value);
    }

    public String getName() {
        return getValue("name");
    }

    public void setName(String value) {
        data.put("name", value);
    }

    public String getEmail() {
        return getValue("email");
    }

    public void setEmail(String value) {
        data.put("email", value);
    }

    public String getPhone() {
        return getValue("phone");
    }

    public void setPhone(String value) {
        data.put("phone", value);
    }

    public String getFax() {
        return getValue("fax");
    }

    public void setFax(String value) {
        data.put("fax", value);
    }

    public String getWebsite() {
        return getValue("website");
    }

    public void setWebsite(String value) {
        data.put("website", value);
    }

    public ArrayList<String> getTags() {
        ArrayList<String> tags = new ArrayList<String>();
        if (data.containsKey("tags")) {
            tags.clear();
            List<String> list = (List) data.get("tags");
            for (String t : list) {
                tags.add(t);
            }
        }
        return tags;
    }

    public void setTags(ArrayList<String> value) {
        data.put("tags", value);
    }

    public String getBillingStreet1() {
        return getValue("billing_street_1");
    }

    public void setBillingStreet1(String value) {
        data.put("billing_street_1", value);
    }

    public String getBillingStreet2() {
        return getValue("billing_street_2");
    }

    public void setBillingStreet2(String value) {
        data.put("billing_street_2", value);
    }

    public String getBillingCity() {
        return getValue("billing_city");
    }

    public void setBillingCity(String value) {
        data.put("billing_city", value);
    }

    public String getBillingState() {
        return getValue("billing_state");
    }

    public void setBillingState(String value) {
        data.put("billing_state", value);
    }

    public String getBillingZipCode() {
        return getValue("billing_zip_code");
    }

    public void setBillingZipCode(String value) {
        data.put("billing_zip_code", value);
    }

    public String getBillingCountry() {
        return getValue("billing_country");
    }

    public void setBillingCountry(String value) {
        data.put("billing_country", value);
    }

    public String getShippingStreet1() {
        return getValue("shipping_street_1");
    }

    public void setShippingStreet1(String value) {
        data.put("shipping_street_1", value);
    }

    public String getShippingStreet2() {
        return getValue("shipping_street_2");
    }

    public void setShippingStreet2(String value) {
        data.put("shipping_street_2", value);
    }

    public String getShippingCity() {
        return getValue("shipping_city");
    }

    public void setShippingCity(String value) {
        data.put("shipping_city", value);
    }

    public String getShippingState() {
        return getValue("shipping_state");
    }

    public void setShippingState(String value) {
        data.put("shipping_state", value);
    }

    public String getShippingZipCode() {
        return getValue("shipping_zip_code");
    }

    public void setShippingZipCode(String value) {
        data.put("shipping_zip_code", value);
    }

    public String getShippingCountry() {
        return getValue("shipping_country");
    }

    public void setShippingCountry(String value) {
        data.put("shipping_country", value);
    }

    /**
     * Returns string value for data key if exists.
     * @param key data key.
     * @return string value.
     */
    private String getValue(String key) {
        if (data.containsKey(key)) {
            return (String) data.get(key);
        } else {
            return "";
        }
    }

    /**
     * Debuggable description for object.
     * @return string value.
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " data {" + data.toString() + "}";
    }
}
