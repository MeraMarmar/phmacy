package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class make_order extends AppCompatActivity {
db_medicine myData;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);myData = new db_medicine(getApplicationContext());
        name = getIntent().getStringExtra("name");
    }

    public void save(View view) {
        Medecine medecine = myData.getMedecineByName(name);
        int q =Integer.parseInt( medecine.getQuntity());
        q--;
        myData.setQuntity(medecine,String.valueOf(q));
    }

}
