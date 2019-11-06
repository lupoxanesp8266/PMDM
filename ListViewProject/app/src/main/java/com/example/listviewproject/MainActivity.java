package com.example.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lista;

    MyCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaCustom);

        String[] titulo = getResources().getStringArray(R.array.pais);
        String[] subtitulo = getResources().getStringArray(R.array.semana);
        int[] imagenes = {R.drawable.aim , R.drawable.ask, R.drawable.bebo, R.drawable.ic_launcher_background, R.drawable.blinklist};

        customAdapter = new MyCustomAdapter(getApplicationContext(), titulo, subtitulo, imagenes);

        lista.setAdapter(customAdapter);

        lista.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Chacho",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Filas f = (Filas) parent.getItemAtPosition(position);

                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.linear2),false);

                // set a dummy image
                ImageView image = layout.findViewById(R.id.imagenFIla);
                image.setImageResource(f.imagen);

                // set a messagepene
                TextView titulo = layout.findViewById(R.id.titulo);
                titulo.setText(f.titulo);

                TextView subtitulo = layout.findViewById(R.id.subTitulo);
                subtitulo.setText(f.subtitulo);

                // Toast...
                Toast custom = new Toast(getApplicationContext());
                custom.setGravity(Gravity.TOP | Gravity.END, 0, 0);

                custom.setDuration(Toast.LENGTH_LONG);
                custom.setView(layout);
                custom.show();
            }
        });
    }
}
