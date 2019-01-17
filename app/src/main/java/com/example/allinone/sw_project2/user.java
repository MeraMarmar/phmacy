package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
    public void general (View view) {
        Intent intent = new Intent(this, general.class);
        startActivity(intent);
    }
    public void beauty(View view) {
        Intent intent = new Intent(this, user.class);
        startActivity(intent);
    }
}
