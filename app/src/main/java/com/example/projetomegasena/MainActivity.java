package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button botao1;
    private Button botaodesaida;
    public Button creditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao1 = findViewById(R.id.iniciarselecao);
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirteladeselecao();
            }
        });

        botaodesaida = findViewById(R.id.encerrarapp);
        botaodesaida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sair();
                }
        });

        creditos = findViewById(R.id.btcredits);
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teladecreditos();
            }
        });

    }

    public void teladecreditos(){
        Intent intent = new Intent(this,TeladeCreditos.class);
        startActivity(intent);
    }

    public void abrirteladeselecao(){
        Intent intent = new Intent(this, TeladeSelecao.class);
        startActivity(intent);
    }
    public void sair(){
      finish();
      System.exit(0);
    }

    public void embreve(View view){
        Toast.makeText(this,"EM BREVE",Toast.LENGTH_SHORT).show();
    }
}