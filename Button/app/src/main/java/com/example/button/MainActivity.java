package com.example.button;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    CheckBox checkBox;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinner1,android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spinner2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice);

        spinner.setAdapter(arrayAdapter);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        checkBox = findViewById(R.id.checkBox);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Has seleccionado: " + spinner.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                button.setEnabled(!isChecked);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(R.drawable.campanilla);
            }
        });

    }
}