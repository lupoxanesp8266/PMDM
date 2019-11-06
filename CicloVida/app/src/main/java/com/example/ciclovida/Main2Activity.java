package com.example.ciclovida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button b;
    Switch on;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        constraintLayout = findViewById(R.id.c);

        b = findViewById(R.id.button2);


        setTitle("heyye");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(),Main3Activity.class));
            }
        });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem checkable = menu.findItem(R.id.app_bar_switch);
        checkable.setChecked(true);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.textoAzul:
                Toast.makeText(getApplicationContext(),"Item 1", Toast.LENGTH_SHORT).show();
                b.setTextColor(Color.BLUE);
                constraintLayout.setBackgroundColor(Color.MAGENTA);
                return true;
            case R.id.fondoVerde:
                Toast.makeText(getApplicationContext(),"Item 2", Toast.LENGTH_SHORT).show();
                b.setTextColor(Color.GREEN);
                constraintLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.textoRojo:
                Toast.makeText(getApplicationContext(),"Item 3", Toast.LENGTH_SHORT).show();
                b.setTextColor(Color.RED);
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
                return super.onOptionsItemSelected(item);
        }
    }
}
