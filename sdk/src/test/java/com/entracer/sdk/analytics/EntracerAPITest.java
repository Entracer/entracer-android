package com.entracer.sdk.analytics;

import com.entracer.sdk.model.Organisation;
import com.entracer.sdk.model.Person;
import com.entracer.sdk.network.Request;
import com.entracer.sdk.network.ResponseListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EntracerAPITest {
    EntracerAPI entracerAPI;

    @Before
    public void init() {
        entracerAPI = EntracerAPI.getInstance("494059203c897d994117352519fd6e49ad");
        entracerAPI.setBaseUrl("http://crm.orete.org");
    }

    @Test
    public void trackEvents() throws Exception {
        ResponseListener rl = new ResponseListener() {
            @Override
            public void onResponse(Request request) {
                assertEquals(request.responseObject.toString(), "{}");
            }

            @Override
            public void onFailure(Request request) {
                throw new AssertionError(request.responseObject.toString());
            }
        };
        entracerAPI.trigger("3e706e751d4020e493820152", "5bfe33df9bdf8e666f8e8e20", "5c3ee77c9bdf8e5f419e8d94", "Communicate", rl);


    }

    @Test
    public void createOrUpdatePerson() throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("email", "chi.rat@gmail.com");
        data.put("first_name", "rathnayake");
        data.put("type", "Lead");
        data.put("status", "new");
        data.put("do_not_call", "true");

        Person p = new Person(data);
        ResponseListener rl = new ResponseListener() {
            @Override
            public void onResponse(Request request) {
                assertTrue(request.responseObject.toString().contains("created_at"));
            }

            @Override
            public void onFailure(Request request) {
                throw new AssertionError(request.responseObject.toString());
            }
        };
        entracerAPI.createOrUpdate(p, rl);
    }


    @Test
    public void createOrUpdateOrganization() throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", "ABC");
        data.put("email", "chi.rat@gmail.com");
        data.put("status", "new");


        Organisation org = new Organisation(data);
        ResponseListener rl = new ResponseListener() {
            @Override
            public void onResponse(Request request) {
                assertTrue(request.responseObject.toString().contains("created_at"));
            }

            @Override
            public void onFailure(Request request) {
                throw new AssertionError(request.responseObject.toString());
            }
        };
        entracerAPI.createOrUpdate(org, rl);
    }

    @After
    public void afterAll() {
        entracerAPI.reset();
    }

}

