package com.example.allinone.sw_project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sign_manger extends AppCompatActivity {
EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_manger);
        e1=(EditText)findViewById(R.id.edId);
        e2=(EditText)findViewById(R.id.edPass);


    }

    public void goManger(View view) {
        String ed1=e1.getText().toString();
        String ed2=e2.getText().toString();
        if(ed1.equals("1")&&ed2.equals("asd12")) {
            e1.setText("");
            e2.setText("");
            SharedPreferences sharedPreferences = getSharedPreferences("Data" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName" , ed1);
            editor.apply();
            Toast.makeText(sign_manger.this," Done",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, manger.class);
            startActivity(intent);
            finish();
            return ;
        }
        else
            Toast.makeText(sign_manger.this," Not Correct",Toast.LENGTH_LONG).show();
        e1.setText("");
        e2 .setText("");
    }
}
