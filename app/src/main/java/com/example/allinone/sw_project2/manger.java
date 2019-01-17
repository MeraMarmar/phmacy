package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class manger extends AppCompatActivity {
db_medicine myDatabase ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manger);
        myDatabase = new db_medicine(getApplicationContext());
    }

    public void add_medicine(View view) {
        Intent intent = new Intent(this, ad_medicine.class);
        startActivity(intent);

    }

    public void show_report(View view) {
        Intent intent = new Intent(this, show_data.class);
        startActivity(intent);
    }

    public void Request_medicine(View view) {
        Intent intent = new Intent(this,request_medicine .class);
        startActivity(intent);
    }

    public void cleanByDate(View v){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Medecine> medecines = myDatabase.getAllData();
        for(int i = 0 ; i < medecines.size() ; i++){
            String mDate = medecines.get(i).getDate();
            try {
                if(date.before(sdf.parse(medecines.get(i).getDate()))){
                    myDatabase.Delete(medecines.get(i).getId());
                    Toast.makeText(getApplicationContext(), "Deleted done" ,Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


}
