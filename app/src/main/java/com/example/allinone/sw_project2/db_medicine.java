package com.example.allinone.sw_project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class db_medicine extends SQLiteOpenHelper {
    public static final String BDname="data.db";
    public db_medicine(@Nullable Context context) {
        super(context,BDname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table Mytable (id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,quntity TEXT,price TEXT,potion TEXT ,nameOfcompany TEXT,date text,kind TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS Mytable");
onCreate(db);
    }
 public Boolean insertData(String name,String price,String potion,String nameOfcompany,String quntity,String kind,String date ){
     SQLiteDatabase db =this.getWritableDatabase();
     ContentValues contentValues=new ContentValues();
     contentValues.put("name",name);
     contentValues.put("price",price);
     contentValues.put("potion",potion);
     contentValues.put("nameOfcompany",nameOfcompany);
     contentValues.put("quntity",quntity);
     contentValues.put("kind",kind);
     contentValues.put("date",date);
     long result=db.insert("Mytable",null,contentValues);
     if (result==-1)
         return false;
     else
         return true;
 }
 public ArrayList<Medecine> getAllData(){
        ArrayList<Medecine> arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
     Cursor res=db.rawQuery("select *from mytable",null);
     res.moveToFirst();
     while (res.isAfterLast()==false){
         String id ,na , price,potion , nameOfcompany,quntity,kind,date ;
         id = res.getString(res.getColumnIndex("id"));
         na = res.getString(res.getColumnIndex("name"));
         price = res.getString(res.getColumnIndex("price"));
         potion = res.getString(res.getColumnIndex("potion"));
         nameOfcompany = res.getString(res.getColumnIndex("nameOfcompany"));
         quntity = res.getString(res.getColumnIndex("quntity"));
         kind = res.getString(res.getColumnIndex("kind"));
         date = res.getString(res.getColumnIndex("date"));
         arrayList.add (new Medecine(id,na,price,potion,nameOfcompany,quntity,kind,date));
         res.moveToNext();
     }
return arrayList;
 }
    public Medecine getMedecineByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select *from mytable where name = '" + name + "'", null);
       res.moveToFirst();
           String id, na, price, potion, nameOfcompany, quntity, kind, date;
           id = String.valueOf(res.getInt(res.getColumnIndex("id")));
           na = res.getString(res.getColumnIndex("name"));
           price = res.getString(res.getColumnIndex("price"));
           potion = res.getString(res.getColumnIndex("potion"));
           nameOfcompany = res.getString(res.getColumnIndex("nameOfcompany"));
           quntity = res.getString(res.getColumnIndex("quntity"));
           kind = res.getString(res.getColumnIndex("kind"));
           date = res.getString(res.getColumnIndex("date"));
           return (new Medecine(id, na, price, potion, nameOfcompany, quntity, kind, date));
    }


    public boolean isFound(String name ,String po){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select *from mytable where name = '" + name + "' and Potion = '" + po + "'",null);
        if(res.getCount() == 0){
            return false ;
        }else
            return true ;
    }

    public void setQuntity(Medecine m , String q){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",m.getName());
        contentValues.put("price",m.getPrice());
        contentValues.put("potion",m.getPotion());
        contentValues.put("nameOfcompany",m.getNameOfcompany());
        contentValues.put("quntity",q);
        contentValues.put("kind",m.getKind());
        contentValues.put("date",m.getDate());
        contentValues.put("name",m.getName());
        db.update("mytable",contentValues,"id = ?",new String[]{m.getId()});
    }


 public boolean updateData(String id,String name,String price,String potion,String nameOfcompany,String quntity,String kind,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
     contentValues.put("name",name);
     contentValues.put("price",price);
     contentValues.put("potion",potion);
     contentValues.put("nameOfcompany",nameOfcompany);
     contentValues.put("quntity",quntity);
     contentValues.put("kind",kind);
     contentValues.put("date",date);
     contentValues.put("name",name);
     db.update("mytable",contentValues,"id=?",new String[]{id});
     return true;
 }
 public int Delete(String id) {
     SQLiteDatabase db = this.getWritableDatabase();
     return db.delete("mytable", "id = ?", new String[]{id});
 }




}
