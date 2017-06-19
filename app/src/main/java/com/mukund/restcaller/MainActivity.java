package com.mukund.restcaller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mukund.restcaller.utils.HTTPHandler;
import com.mukund.restcaller.utils.VolleyCaller;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePostRequest();
            }
        });
    }

    private void makePostRequest() {

       /* MyAsyncTask myTask = new MyAsyncTask();
        myTask.execute();*/

        VolleyCaller vc = new VolleyCaller();
        vc.makePostRequest(this);

    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        private Handler handler;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            handler = new Handler();
        }

        @Override
        protected Void doInBackground(Void... params) {
            HTTPHandler httpHandler = new HTTPHandler();
            final String result = httpHandler.makePostRequest();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    TextView tv = (TextView) findViewById(R.id.tvResponse);
                    tv.setText(result);
                }
            });
            return null;
        }

    }
}
