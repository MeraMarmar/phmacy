package com.example.allinone.sw_project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ad_medicine extends AppCompatActivity {
    db_medicine db=new db_medicine(this);
    EditText editid, editName,editprice,editpotion,editnameofcompany,editQuantity,editkind,editdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_medicine);

        editName=(EditText)findViewById(R.id.editName);
        editprice=(EditText)findViewById(R.id.editprice);
        editpotion=(EditText)findViewById(R.id.editpotion);
        editnameofcompany=(EditText)findViewById(R.id.editnameofcompany);
        editQuantity=(EditText)findViewById(R.id.editQuantity);
        editkind=(EditText)findViewById(R.id.editkind);
        editdate=(EditText)findViewById(R.id.editdate);
        editid=(EditText)findViewById(R.id.editid);

    }

    public void add_med(View view) {
        String Name=editName.getText().toString();
        String price=editprice.getText().toString();
        String potion=editpotion.getText().toString();
        String nameofcompany=editnameofcompany.getText().toString();
        String Quantity=editQuantity.getText().toString();
        String kind=editkind.getText().toString();
        String date=editdate.getText().toString();
        Boolean res= db.insertData(Name,price,potion,nameofcompany,Quantity,kind,date);
        if(res==true){
            Toast.makeText(ad_medicine.this,"Done",Toast.LENGTH_LONG).show();
            editName.setText("");
            editprice.setText("");
            editpotion.setText("");
            editnameofcompany.setText("");
            editQuantity.setText("");
            editkind.setText("");
            editdate.setText("");

        }
        else {
            Toast.makeText(ad_medicine.this,"Please enter data",Toast.LENGTH_LONG).show();
        }
    }

    public void UpData(View view) {
        String Name=editName.getText().toString();
        String price=editprice.getText().toString();
        String potion=editpotion.getText().toString();
        String nameofcompany=editnameofcompany.getText().toString();
        String Quantity=editQuantity.getText().toString();
        String kind=editkind.getText().toString();
        String date=editdate.getText().toString();
        String id=editid.getText().toString();
        Boolean res= db.updateData(id,Name,price,potion,nameofcompany,Quantity,kind,date);
        if(res==true){
            Toast.makeText(ad_medicine.this,"Done",Toast.LENGTH_LONG).show();
            editName.setText("");
            editprice.setText("");
            editpotion.setText("");
            editnameofcompany.setText("");
            editQuantity.setText("");
            editkind.setText("");
            editdate.setText("");
            editid.setText("");
        }
        else {
            Toast.makeText(ad_medicine.this,"Please enter data",Toast.LENGTH_LONG).show();
        }

    }

    public void delete(View view) {
        String id=editid.getText().toString();
        Integer result=db.Delete(id);
        editid.setText("");
        if(result>0){
            Toast.makeText(ad_medicine.this,"Done",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(ad_medicine.this,"NotDone",Toast.LENGTH_LONG).show();

    }

    }

