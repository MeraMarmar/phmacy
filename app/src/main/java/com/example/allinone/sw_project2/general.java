package com.example.allinone.sw_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class general extends AppCompatActivity {
ArrayList<String> itemlist;
ArrayAdapter<String> adapter;
EditText editText ,editText2,editText3;
TextView bi;
Button b,btnDel;
ListView l1;
db_medicine myData;
int bill,bil ;
    Medecine medecine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        editText=(EditText)findViewById(R.id.edit);
        editText2=(EditText)findViewById(R.id.edit2);
        editText3=(EditText)findViewById(R.id.edit3);
        b=(Button)findViewById(R.id.but1);
        btnDel=(Button)findViewById(R.id.btnDel);
        l1=(ListView)findViewById(R.id.list);
        bi = findViewById(R.id.bill);
        bil = 0;
        myData = new db_medicine(getApplicationContext());
        itemlist= new ArrayList<>();
        adapter=new ArrayAdapter(general.this,android.R.layout.simple_list_item_multiple_choice,itemlist);

        View.OnClickListener addlistener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myData.isFound(editText.getText().toString(),editText2.getText().toString())) {
                    medecine = myData.getMedecineByName(editText.getText().toString().trim());
                    if(medecine.getKind().equals("not valid")){
                        Toast.makeText(getApplicationContext(),"Not valid",Toast.LENGTH_LONG).show();
                        return;
                    }
                        itemlist.add(editText.getText().toString()+" " + editText2.getText().toString()+" "+medecine.getPrice());

                    bil=bil+Integer.parseInt(medecine.getPrice()) * Integer.parseInt(editText3.getText().toString());
                        adapter.notifyDataSetChanged();
                        bi.setText("bill : "+bil);
                        editText.setText("");
                        editText2.setText("");
                        editText3.setText("");

                }else
                    Toast.makeText(getApplicationContext(),"Not Found in pharmacy",Toast.LENGTH_LONG).show();



            }
        };
        //l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //@Override
           // public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
             //   SparseBooleanArray sparseBooleanArray=l1.getCheckedItemPositions();
              //  int count=l1.getCount();
              //  for(int item=count;item>=0;item--){
                 //   if(sparseBooleanArray.get(item)){
                  //      adapter.remove(itemlist.get(item));
                  //  }
               // }
               // sparseBooleanArray.clear();
                //adapter.notifyDataSetChanged();
                //return false;
            //}
       // });
        View.OnClickListener listenerDel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Getting the checked items from the listview */
                SparseBooleanArray sparseBooleanArray=l1.getCheckedItemPositions();
                int count=l1.getCount();

                for(int i=count-1; i >= 0; i--){
                    if(sparseBooleanArray.get(i)){
                      //  bil=bil-Integer.parseInt(medecine.getPrice()) * Integer.parseInt(editText3.getText().toString());
                        adapter.remove(itemlist.get(i));

                    }
                }
                sparseBooleanArray.clear();
                adapter.notifyDataSetChanged();
            }
        };




        b.setOnClickListener(addlistener);
        l1.setAdapter(adapter);
        btnDel.setOnClickListener(listenerDel);

    }


    public void go_next(View view) {
        Intent intent = new Intent(getApplicationContext(), make_order.class);
        intent.putExtra("name",editText.getText().toString());
        startActivity(intent);
    }
}
