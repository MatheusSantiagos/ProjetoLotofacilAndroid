package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sorteio extends AppCompatActivity {
    private Button botao4;
    private Button botao5;
    ArrayList<Integer> listadenumeros = new ArrayList<Integer>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        botao4 = findViewById(R.id.voltar2);
        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarmenuprincipal();
            }
        });

        botao5 = findViewById(R.id.resultadosorte);
        botao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadodacomparacao();
            }
        });
    }
    public void sorteados(View v){
        //cria um array para numeros sorteados
        listadenumeros.clear();
        int i,num;
        //randomiza e preenche a array de numeros aleatórios
        for ( i=0; i<6; i++){
            num = new Random().nextInt(30)+1;
            if(listadenumeros.contains(num)){
                i--;
            }else{
                listadenumeros.add(num);
            }
        }

        // imprime valores sorteados
        Collections.sort(listadenumeros);
        TextView casa1 = findViewById(R.id.casa); TextView casa2 = findViewById(R.id.casa2);
        TextView casa3 = findViewById(R.id.casa3); TextView casa4 = findViewById(R.id.casa4);
        TextView casa5 = findViewById(R.id.casa5); TextView casa6 = findViewById(R.id.casa6);

        casa1.setText("" +listadenumeros.get(0)); casa2.setText("" +listadenumeros.get(1));
        casa3.setText("" +listadenumeros.get(2)); casa4.setText("" +listadenumeros.get(3));
        casa5.setText("" +listadenumeros.get(4)); casa6.setText("" +listadenumeros.get(5));
    }

    public void voltarmenuprincipal(){
        Intent intent = new Intent(this,TeladeSelecao.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    public void resultadodacomparacao(){
        if(listadenumeros.size() != 0){
            ArrayList<String> tempjgum = getIntent().getStringArrayListExtra("valorescheckjogoum");
            if(tempjgum != null){

                Intent intent = new Intent(this, ResultadoVariosJogos.class);
                intent.putIntegerArrayListExtra("sorteiodenumeros", listadenumeros);


                intent.putStringArrayListExtra("valorescheckjogoum",tempjgum);

                ArrayList<String> tempjgdos = getIntent().getStringArrayListExtra("valorecheckjogodois");

                intent.putStringArrayListExtra("valorescheckjogodois",tempjgdos);

                ArrayList<String> tempjgtrs = getIntent().getStringArrayListExtra("valorescheckjogotres");

                intent.putStringArrayListExtra("valorescheckjogotres",tempjgtrs);

                startActivity(intent);

            }else{
                Intent intent = new Intent(this, Resultadodocomparacao.class);

                intent.putIntegerArrayListExtra("sorteiodenumeros", listadenumeros);

                ArrayList<String> valorescheck = getIntent().getStringArrayListExtra("valoreschecados");

                intent.putStringArrayListExtra("valoreschecados", valorescheck);

                startActivity(intent);

            }

        }else{
            Toast.makeText(this,"Faça o sorteio primeiro", Toast.LENGTH_SHORT).show();
        }

    }
}