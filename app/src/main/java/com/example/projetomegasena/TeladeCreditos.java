package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeladeCreditos extends AppCompatActivity {
    public Button botaosaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_creditos);

        botaosaida = findViewById(R.id.saircreditos);
        botaosaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarmenuprincipal();
            }
        });
    }

    public void voltarmenuprincipal(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}