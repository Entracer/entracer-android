package com.entracer.sdk.model;

import java.util.Map;

public class Event {

    public Map data;

    public Event(Map data) {
        this.data = data;
    }

    public String getPersonId() {
        return (String) data.get("person_id");
    }

    public void setPersonId(String value) {
        data.put("person_id", value);
    }

    public String getOrganisationId() {
        return (String) data.get("organisation_id");
    }

    public void setOrganisationId(String value) {
        data.put("organisation_id", value);
    }

    public String getChannel() {
        return (String) data.get("channel");
    }

    public void setChannel(String value) {
        data.put("channel", value);
    }


}
