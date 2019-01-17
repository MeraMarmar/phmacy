package com.example.allinone.sw_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class request_medicine extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_medicine);
        textView=(TextView)findViewById(R.id.textDate);
    }

    public void make_Request(View view) {
        final Intent intent = new Intent(Intent.ACTION_VIEW)
                .setType("plain/text")
                .setData(Uri.parse("test@gmail.com"))
                .setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail")
                .putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"})
                .putExtra(Intent.EXTRA_SUBJECT, "test")
                .putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)");
        startActivity(intent);
    }
}
