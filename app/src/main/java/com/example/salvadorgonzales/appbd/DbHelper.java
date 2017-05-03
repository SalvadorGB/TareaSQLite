package com.example.salvadorgonzales.appbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import com.example.salvadorgonzales.appbd.Bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salvador Gonzales on 02/05/2017.
 */

public class DbHelper extends SQLiteOpenHelper {


    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table carrcompra(id integer primary key autoincrement, codProducto text, desProducto text, cantidad int, precioReal int, totalPrecio int )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists carrcompra");

    }

    public void insert(String codproducto, String desproducto, int cantidad, int precioreal, int totalprecio){
        ContentValues contentValues = new ContentValues();
        contentValues.put("codProducto", codproducto);
        contentValues.put("desProducto", desproducto);
        contentValues.put("cantidad", cantidad);
        contentValues.put("precioReal", precioreal);
        contentValues.put("totalPrecio", totalprecio);

        getWritableDatabase().insert("carrcompra",null,contentValues);
    }


    public List<Person> getAll(){

        List<Person> listaCompra = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select * from carrcompra", null);
        while (cursor.moveToNext()){
            listaCompra.add(new Person(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
        }

        return listaCompra;

    }


    public void insert(String s) {

    }
}
