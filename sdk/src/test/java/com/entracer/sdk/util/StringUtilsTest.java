package com.entracer.sdk.util;

import com.entracer.sdk.model.Person;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void getPostDataString() throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("email", "chi.rat@gmail.com");
        data.put("first_name", "rathnayake");
        data.put("type", "Lead");
        data.put("status", "new");
        data.put("do_not_call", "true");

        Person p = new Person(data);
        Map<String, Object> out = new HashMap<String, Object>();
        out.put("person", p.data);
        Assert.assertEquals(StringUtils.getPostDataString(out),"{\"person\":{\"type\":\"Lead\",\"first_name\":\"rathnayake\",\"do_not_call\":\"true\",\"email\":\"chi.rat@gmail.com\",\"status\":\"new\"}}");
    }
}