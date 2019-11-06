package com.example.gridviewmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("2");

        TextView tx = findViewById(R.id.textView3);

        Button btn = findViewById(R.id.button2);
        Button btn2 = findViewById(R.id.button3);

        final EditText editText = findViewById(R.id.editText2);

        Intent intent = getIntent();

        tx.setText("Hola " + intent.getStringExtra("nombre") + " aceptas las condiciones wy");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent1 = new Intent();
                    intent1.putExtra("texto",editText.getText().toString());
                    setResult(RESULT_OK,intent1);
                    finish();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
