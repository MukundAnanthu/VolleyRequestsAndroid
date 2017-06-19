package com.mukund.restcaller.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.mukund.restcaller.vo.UserDetailsVO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mukund on 6/18/17.
 */

public class HTTPHandler {

    public String makePostRequest() {
        String response = null;

        try {
            URL url = new URL("https://localhost:8080/api/login");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            // Headers
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");
            conn.connect();

            // Connect
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

            // Write data
            //Get the VO
            UserDetailsVO ud = new UserDetailsVO();
            ud.setUserId("userthaid");
            ud.setPassword("thapasswd");
            ud.setUserType("thaType");

            // Convert VO to Json and write
            Gson gson = new Gson();
            gson.toJson(ud, writer);


            // Close writer
            writer.close();
            os.close();

            // Read response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            response = sb.toString();

            Log.i("HTTP Handler:response ", response);

            /*// Read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);*/


        } catch (MalformedURLException e) {
            Log.e("MalformedURLException: ", e.getMessage());
        } catch (ProtocolException e) {
            Log.e("ProtocolException: " , e.getMessage());
        } catch (IOException e) {
            Log.e("IOException: ", e.getMessage());
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        } finally {
            return response;
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
