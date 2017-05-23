package com.londonappbrewery.bitcointicker;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class NoInternetActivity extends AppCompatActivity
{
    Button reconnectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        Dialog dialog = new Dialog(getApplicationContext());
        dialog.setCancelable(false);

        reconnectButton = (Button) findViewById(R.id.reconnectButton);
        reconnectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://www.google.com", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
                    {
                        finish();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error)
                    {
                        Toast.makeText(getApplicationContext(), "Still no internet connection! :o", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
