package com.example.allinone.sw_project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class show_data extends AppCompatActivity {
    db_medicine db=new db_medicine(this);
ListView listView;
EditText editTextid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        listView=(ListView)findViewById(R.id.listdata);
        editTextid=(EditText)findViewById(R.id.editid2);
        show();
    }
   public void show(){
       ArrayList<Medecine>listData=db.getAllData();
       ArrayList<String> arrayList = new ArrayList<>();
       for(int i = 0 ;i < listData.size();i++){
           String s = listData.get(i).getId()+"- "+listData.get(i).name +"      "
                   +listData.get(i).potion +"         "+listData.get(i).quntity +"        "+listData.get(i).getNameOfcompany();
           arrayList.add(s);
       }
       ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.mytextview,arrayList);
       listView.setAdapter(arrayAdapter);
   }


    public void delete2(View view) {
        String id=editTextid.getText().toString();
        Integer result=db.Delete(id);
        editTextid.setText("");
        if(result>0){
            Toast.makeText(show_data.this,"Done",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(show_data.this,"NotDone",Toast.LENGTH_LONG).show();

    }
    }

