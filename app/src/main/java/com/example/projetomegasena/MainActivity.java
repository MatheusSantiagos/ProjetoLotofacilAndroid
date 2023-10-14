package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //abre tela de creditos
    public void teladecreditos(View view){
        Intent intent = new Intent(this,TeladeCreditos.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    //vai para o menu de selecao de jogo
    public void abrirteladeselecao(View view){
        Intent intent = new Intent(this, EscolhaseuJogo.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    //encerra o aplicativo
    public void sair(View view){
      finish();
      System.exit(0);
    }

    public void embreve(View view){
        Toast.makeText(this,"EM BREVE",Toast.LENGTH_SHORT).show();
    }
}