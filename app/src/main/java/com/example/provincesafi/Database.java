package com.example.provincesafi;
//package org.o7planning.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    //attribut

    //constructor
    public Database(@Nullable Context context) {
        super(context,"province.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //user Table
        /*String CreateTableStatement= "Create table " + USER + "(" + ID + " integer primary key autoincrement," + USERNAME + " text," + PASSWORD + " text)";
        db.execSQL(CreateTableStatement);*/
        //Infracteur Table
        //String infracteur= "Create table " + TABLE_INFRACTEUR + "(" + COLUMN_ID_1 + " int primary key autoincrement," + COLUMN_CIN + " text," + COLUMN_NAME + " text)";
        //db.execSQL(infracteur);
        //infraction Table
        //String infraction= "Create table " + TABLE_INFRACTION + "(" + COLUMN_ID_2 + " int primary key autoincrement," + COLUMN_TYPE + " text," + COLUMN_ADRESSE + " text," + COLUMN_PV + " text)";
        //db.execSQL(infraction);
    }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Log.i(TAG, "Database.onUpgrade ... ");
       // db.execSQL("drop table if EXISTS" + USER);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFRACTEUR);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFRACTION);


        // Recreate
        //onCreate(db);

    }
    //ajouter
    public boolean addOne(InfractionModel infractionModel){
        SQLiteDatabase db=this.getReadableDatabase();
        //ContentValues cv =new ContentValues();
        ContentValues vc =new ContentValues();

       /* cv.put("cin",infracteurModel.getCin());
        cv.put("name",infracteurModel.getName());
        long insert=db.insert("infracteur",null,cv);*/
        //
        vc.put("name",infractionModel.getName());
        vc.put("cin",infractionModel.getCin());
        vc.put("type",infractionModel.getType());
        vc.put("adresse",infractionModel.getAdress());
        vc.put("pv",infractionModel.getPv());
        /*vc.put(ARRONDISSEMENT,infractionModel.getPv());
        vc.put(CONDUITE,infractionModel.getPv());
        vc.put(COMMUNE,infractionModel.getPv());*/

        long add=db.insert("infraction",null,vc);

        if(add==-1){
            return false ;
        }else{
            return  true ;
        }
    }



    //Lister tout le monde infraction
    public List<InfractionModel> getEveryInfraction(){
        List<InfractionModel> returnList = new ArrayList<>();
        //List<InfracteurModel> returnLst = new ArrayList<>();

        //get Data
        //String query="SELECT  * FROM infraction"  ;
        //String queryString="select * from" + INFRACTEUR ;

        SQLiteDatabase db = this.getReadableDatabase() ;
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder() ;
        //SQLiteDatabase bd =
        String[] sqlSelect={"id","name","cin","type","adresse","pv"};
        String tableName="infraction";
        qb.setTables(tableName);
        //Cursor cursor = db.rawQuery(query,null);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        //Cursor cursor = db.rawQuery(query,null);
        //Cursor cursor1 = db.rawQuery(queryString,null);
        if((cursor.moveToFirst())){
            do{


                InfractionModel newInfraction = new InfractionModel() ;

                newInfraction.setId(cursor.getInt(cursor.getColumnIndex("id")));
                newInfraction.setCin(cursor.getString(cursor.getColumnIndex("cin")));
                newInfraction.setName(cursor.getString(cursor.getColumnIndex("name")));
                newInfraction.setAdress(cursor.getString(cursor.getColumnIndex("adresse")));
                newInfraction.setType(cursor.getString(cursor.getColumnIndex("type")));
                newInfraction.setPv(cursor.getString(cursor.getColumnIndex("pv")));

                //newInfraction.setName(cursor.getString(cursor.getColumnIndex("name")));


                returnList.add(newInfraction);

            }while((cursor.moveToNext()));
        }
        cursor.close();
        //cursor1.close();
        db.close();

        return returnList ;

    }
    //lister les cin
    public List<InfractionModel> getNameInfraction(){
        List<InfractionModel> returnList = new ArrayList<>();
        //List<InfracteurModel> returnLst = new ArrayList<>();

        //get Data
        String query="SELECT  * FROM infraction"  ;
        //String queryString="select * from" + INFRACTEUR ;

        SQLiteDatabase db = this.getReadableDatabase() ;
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder() ;
        //SQLiteDatabase bd =
        String[] sqlSelect={"name"};
        String tableName="infraction";
        qb.setTables(tableName);
        //Cursor cursor = db.rawQuery(query,null);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        //Cursor cursor = db.rawQuery(query,null);
        //Cursor cursor1 = db.rawQuery(queryString,null);
        if((cursor.moveToFirst())){
            do{


                InfractionModel newInfraction = new InfractionModel() ;


                newInfraction.setCin(cursor.getString(cursor.getColumnIndex("cin")));
                //newInfraction.setName(cursor.getString(cursor.getColumnIndex("name")));


                returnList.add(newInfraction);

            }while((cursor.moveToNext()));
        }
        cursor.close();
        db.close();

        return returnList ;

    }
    //search by name
    public List<InfractionModel> getByName(String name){
        List<InfractionModel> returnList = new ArrayList<>();
        //List<InfracteurModel> returnLst = new ArrayList<>();

        //get Data
        String query="SELECT  * FROM infraction"  ;
        //String queryString="select * from" + INFRACTEUR ;

        SQLiteDatabase db = this.getReadableDatabase() ;
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder() ;
        //SQLiteDatabase bd =
        String[] sqlSelect={"id","name","cin","type","adresse","pv"};
        String tableName="infraction";
        qb.setTables(tableName);
        //Cursor cursor = db.rawQuery(query,null);
        Cursor cursor = qb.query(db,sqlSelect,"name LIKE ?",new String[]{"%"+name+"%"},null,null,null);
        //Cursor cursor = db.rawQuery(query,null);
        //Cursor cursor1 = db.rawQuery(queryString,null);
        if((cursor.moveToFirst())){
            do{

                InfractionModel newInfraction = new InfractionModel() ;

                newInfraction.setId(cursor.getInt(cursor.getColumnIndex("id")));
                newInfraction.setCin(cursor.getString(cursor.getColumnIndex("cin")));
                newInfraction.setName(cursor.getString(cursor.getColumnIndex("name")));
                newInfraction.setAdress(cursor.getString(cursor.getColumnIndex("adresse")));
                newInfraction.setType(cursor.getString(cursor.getColumnIndex("type")));
                newInfraction.setPv(cursor.getString(cursor.getColumnIndex("pv")));
                //newInfraction.setName(cursor.getString(cursor.getColumnIndex("name")));


                returnList.add(newInfraction);

            }while((cursor.moveToNext()));
        }
        cursor.close();
        //cursor1.close();
        db.close();

        return returnList ;

    }
    //update infracteur
    /*public int updateinfrateur(InfracteurModel infracteurModel) {
        //Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CIN, infracteurModel.getName());
        values.put(COLUMN_NAME, infracteurModel.getCin());

        // updating row
        return db.update(TABLE_INFRACTEUR, values, COLUMN_ID_1 + " = ?",
                new String[]{String.valueOf(infracteurModel.getId())});
    }*/
    //update infraction
    public int updateinfration(InfractionModel infractionModel) {
        //Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("cin",infractionModel.getName());
        values.put("name", infractionModel.getCin());
        values.put("type", infractionModel.getType());
        values.put("adresse", infractionModel.getAdress());
        values.put("pv", infractionModel.getPv());


        // updating row
        return db.update("infraction", values, "id  = ?",
                new String[]{String.valueOf(infractionModel.getId())});
    }
    //delete infracteur
    /*public void deleteinfracteur(InfracteurModel infracteurModel) {
        //Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("infracteur",  "id = ?",
                new String[] { String.valueOf(infracteurModel.getId()) });
        db.close();
    }*/
    //delete infraction
    public boolean deleteinfraction(InfractionModel infractionModel) {


        SQLiteDatabase db = this.getWritableDatabase();
         /*db.delete("infraction",   " id = ?",
                new String[] {String.valueOf(infractionModel.getId())});
        db.close();
        return false;*/
        long retour =db.delete("infraction","id=?",new String[]{String.valueOf(infractionModel.getId())});
        if(retour==-1){
            return false;
        }else{
            return true;
        }
    }
}

