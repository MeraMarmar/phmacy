package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class show_bill extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill);
        b=(Button)findViewById(R.id.btn_order);
    }

    public void btn_order(View view) {
        Intent intent = new Intent(this, make_order.class);
        startActivity(intent);
    }
}
