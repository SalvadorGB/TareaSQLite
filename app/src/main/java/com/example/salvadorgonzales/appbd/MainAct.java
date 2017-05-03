package com.example.salvadorgonzales.appbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salvadorgonzales.appbd.Bean.Person;

import java.util.List;
import java.util.Objects;

public class MainAct extends AppCompatActivity {

    private Context thiscontext = this;
    private EditText codproducto;
    private EditText desproducto;
    private EditText cantidad;
    private EditText precioReal;
    private EditText totalReal;
    private Button btnguardar;
    private ListView listavcompra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        codproducto = (EditText) findViewById(R.id.codProducto);
        desproducto = (EditText) findViewById(R.id.desProducto);
        cantidad = (EditText) findViewById(R.id.Cantidad);
        precioReal = (EditText) findViewById(R.id.precioReal);
        totalReal = (EditText) findViewById(R.id.totalPrecio);
        btnguardar = (Button) findViewById(R.id.btnSave);
        listavcompra = (ListView) findViewById(R.id.listview);

        DbHelper dbHelper = new DbHelper(thiscontext,"dbcompra.db",null,1);
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(thiscontext, android.R.layout.simple_list_item_activated_1, dbHelper.getAll());

        listavcompra.setAdapter(arrayAdapter);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(thiscontext,"dbcompra.db",null,1);

                dbHelper.insert(codproducto.getText().toString());
                dbHelper.insert(desproducto.getText().toString());
                dbHelper.insert(cantidad.getText().toString());
                dbHelper.insert(precioReal.getText().toString());
                dbHelper.insert(totalReal.getText().toString());


                codproducto.setText("");

                ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(thiscontext, android.R.layout.simple_list_item_activated_1, dbHelper.getAll());
                listavcompra.setAdapter(arrayAdapter);
            }
        });




      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
