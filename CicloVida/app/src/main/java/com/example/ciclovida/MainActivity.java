package com.example.ciclovida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView menuContextual;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Estas en el OnCreate()",Toast.LENGTH_SHORT).show();
        Log.d("Ciclos","Create");

        menuContextual = findViewById(R.id.textMenu);
        constraintLayout = findViewById(R.id.constra);
        registerForContextMenu(menuContextual);

        Button b = findViewById(R.id.button);
        setTitle("Activity 1");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
              }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.textoAzul:
                Toast.makeText(getApplicationContext(),"Item 1", Toast.LENGTH_SHORT).show();
                constraintLayout.setBackgroundColor(Color.MAGENTA);
                return true;
            case R.id.fondoVerde:
                Toast.makeText(getApplicationContext(),"Item 2", Toast.LENGTH_SHORT).show();
                constraintLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.textoRojo:
                Toast.makeText(getApplicationContext(),"Item 3", Toast.LENGTH_SHORT).show();
                constraintLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.fondoAzul:
                Toast.makeText(getApplicationContext(),"SubItem 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.app_bar_switch:
                Toast.makeText(getApplicationContext(),"Hola",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                return true;
            case R.id.about:
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "acerca de");
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
