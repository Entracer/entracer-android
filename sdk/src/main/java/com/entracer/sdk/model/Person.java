package com.entracer.sdk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

enum PersonType {
    Lead, Converted
}

enum PersonStatus {
    New, Validated, Qualified, Rejected
}

/**
 * Model class to represent People objects.
 */
public class Person {

    public Map data;

    /**
     * Constructs person object with data dictionary.
     * @param data dictionary.
     */
    public Person(Map data) {
        this.data = data;
    }

    public String getId() {
        return (String) data.get("id");
    }

    public void setId(String value) {
        data.put("id", value);
    }

    public String getType() {
        return (String) data.get("type");
    }

    public void setType(String value) {
        data.put("type", value);
    }

    public String getStatus() {
        return (String) data.get("status");
    }

    public void setStatus(String value) {
        data.put("status", value);
    }

    public String getFirstName() {
        return getValue("first_name");
    }

    public void setFirstName(String value) {
        data.put("first_name", value);
    }

    public String getLastName() {
        return getValue("last_name");
    }

    public void setLastName(String value) {
        data.put("last_name", value);
    }

    public String getEmail() {
        return getValue("email");
    }

    public void setEmail(String value) {
        data.put("email", value);
    }

    public String getMobile() {
        return getValue("mobile");
    }

    public void setMobile(String value) {
        data.put("mobile", value);
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

    public String getDepartment() {
        return getValue("department");
    }

    public void setDepartment(String value) {
        data.put("department", value);
    }

    public String getTitle() {
        return getValue("title");
    }

    public void setTitle(String value) {
        data.put("title", value);
    }

    public String getJobTitle() {
        return getValue("job_title");
    }

    public void setJobTitle(String value) {
        data.put("job_title", value);
    }

    public String getStreet1() {
        return getValue("street_1");
    }

    public void setStreet1(String value) {
        data.put("street_1", value);
    }

    public String getStreet2() {
        return getValue("street_2");
    }

    public void setStreet2(String value) {
        data.put("street_2", value);
    }

    public String getCity() {
        return getValue("city");
    }

    public void setCity(String value) {
        data.put("city", value);
    }

    public String getState() {
        return getValue("state");
    }

    public void setState(String value) {
        data.put("state", value);
    }

    public String getZipCode() {
        return getValue("zip_code");
    }

    public void setZipCode(String value) {
        data.put("zip_code", value);
    }

    public String getCountry() {
        return getValue("country");
    }

    public void setCountry(String value) {
        data.put("country", value);
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
