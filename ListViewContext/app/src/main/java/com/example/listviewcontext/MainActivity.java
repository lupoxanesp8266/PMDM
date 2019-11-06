package com.example.listviewcontext;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    Button b;
    ConstraintLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        c = findViewById(R.id.background);

        b = findViewById(R.id.button);

        registerForContextMenu(t1);
        registerForContextMenu(t2);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta= new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Simple");
                alerta.setMessage("Acho dale al ok");
                alerta.setPositiveButton("Ok",null);
                alerta.create();
                alerta.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder alerta= new AlertDialog.Builder(this);
        alerta.setTitle("Como mantener a un tonto entretenido");
        alerta.setMessage("Acho dale al ok");
        final View inflater = LayoutInflater.from(MainActivity.this).inflate(R.layout.editex,null);
        alerta.setView(inflater);
        alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText ed = inflater.findViewById(R.id.editText);
                Toast.makeText(MainActivity.this,ed.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        alerta.setNegativeButton("Not ok", null);
        alerta.setNeutralButton("Nah", null);
        alerta.setCancelable(true);
        alerta.setIcon(R.drawable.ic_launcher_background);
        alerta.create();
        alerta.show().cancel();

        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontext,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.message:
                startActivity(new Intent(getApplicationContext(),ActivityConf.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        boolean dark = sp.getBoolean("dark_mode",false);

        if(dark){
            c.setBackgroundColor(Color.BLACK);
        }else{
            c.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.text1){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menucontext,menu);
        }
        if(v.getId() == R.id.text2){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu2,menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.call:
                Toast.makeText(getApplicationContext(),"Call: " + info.position,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.message:
                Toast.makeText(getApplicationContext(),"Message: " + info.position,Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
