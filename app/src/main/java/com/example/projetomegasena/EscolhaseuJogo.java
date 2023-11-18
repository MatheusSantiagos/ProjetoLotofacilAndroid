package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EscolhaseuJogo extends AppCompatActivity {

    public ImageButton avancarmegasena,avancarQuina, avancarQuadra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhaseu_jogo);

        avancarmegasena = findViewById(R.id.imageButton);
        avancarmegasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogomega();
            }
        });
        avancarQuina = findViewById(R.id.imageButton2);
        avancarQuina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogoquina();
            }
        });
        avancarQuadra = findViewById(R.id.imageButton3);
        avancarQuadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogoquadra();
            }
        });
    }
    public void jogomega(){
        Intent intent = new Intent(this, TeladeSelecao.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    public void jogoquina(){
        Intent intent = new Intent(this, Selecao_Quina.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }

    public void jogoquadra(){
        Intent intent = new Intent(this, Selecao_Quadra.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    public void embreve(View view){
        Toast.makeText(this,"EM BREVE",Toast.LENGTH_SHORT).show();
    }
}