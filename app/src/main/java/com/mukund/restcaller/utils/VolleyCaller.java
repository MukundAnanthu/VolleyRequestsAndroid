package com.mukund.restcaller.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import com.mukund.restcaller.vo.UserDetailsVO;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mukund on 6/19/17.
 */

public class VolleyCaller {

    public void makePostRequest(Context ctx) {
        /*RequestQueue requestQueue = Volley.newRequestQueue(ctx);
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

        requestQueue.add(sr);*/

        /*RequestQueue requestQueue = Volley.newRequestQueue(ctx);
        String url = "http://192.168.1.2:8080/api/login";

        StringRequest sr = new StringRequest(Request.Method.POST,url,
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

        ){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-type","application/json;json;charset=UTF-8");
                return super.getHeaders();
            }



        };
        requestQueue.add(sr);*/
        RequestQueue requestQueue = Volley.newRequestQueue(ctx);
        String url = "http://192.168.1.2:8080/api/login";
        UserDetailsVO ud = new UserDetailsVO();
        ud.setUserId("abc");
        ud.setPassword("something");
        ud.setUserType("ADMIN");


        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("userId","abc");
        hm.put("password","something");
        hm.put("userType","ADMIN");

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(hm), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response: ",response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ResponseERrrrroor:","holysh");

                    }
                }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type","application/json");
                return headers;
            }


        };
        requestQueue.add(jsObjRequest);
    }
}
