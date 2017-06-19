package com.mukund.restcaller.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by mukund on 6/19/17.
 */

public class VolleyCaller {

    public void makePostRequest(Context ctx) {
        RequestQueue requestQueue = Volley.newRequestQueue(ctx);
        String url = "http://www.google.com";

        StringRequest sr = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("VolleyCaller:Response: ", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("VolleyCaller:Error: ", "Response Error");
                    }
                }

        );

        requestQueue.add(sr);

    }
}
