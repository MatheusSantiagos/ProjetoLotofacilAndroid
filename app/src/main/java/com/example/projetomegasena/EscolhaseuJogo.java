package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EscolhaseuJogo extends AppCompatActivity {

    public ImageButton avancarmegasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhaseu_jogo);

        avancarmegasena = findViewById(R.id.imageButton);
        avancarmegasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirteladeselecao();
            }
        });
    }
    public void abrirteladeselecao(){
        Intent intent = new Intent(this, TeladeSelecao.class);
        startActivity(intent);
        Toast.makeText(this,"Selecione Seis numeros",Toast.LENGTH_SHORT).show();
        finish();
        System.exit(0);
    }
    public void embreve(View view){
        Toast.makeText(this,"EM BREVE",Toast.LENGTH_SHORT).show();
    }
}