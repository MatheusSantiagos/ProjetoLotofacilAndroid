package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class helpscreen extends AppCompatActivity {

    public Button botaoretorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpscreen);
        botaoretorno = findViewById(R.id.voltarmenu);
        botaoretorno.setOnClickListener(new View.OnClickListener() {
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