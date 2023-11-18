package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sorteio_Quina extends AppCompatActivity {

    ArrayList<Integer> listadenumeros = new ArrayList<Integer>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio_quina);
    }
    public void sorteados(View v){
        //cria um array para numeros sorteados
        listadenumeros.clear();
        int i,num;
        //randomiza e preenche a array de numeros aleatórios
        for ( i=0; i<5; i++){
            num = new Random().nextInt(60)+1;
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
        TextView casa5 = findViewById(R.id.casa5);

        casa1.setText("" +listadenumeros.get(0)); casa2.setText("" +listadenumeros.get(1));
        casa3.setText("" +listadenumeros.get(2)); casa4.setText("" +listadenumeros.get(3));
        casa5.setText("" +listadenumeros.get(4));}

    public void voltarmenuprincipal(View view){
        Intent intent = new Intent(this,Selecao_Quina.class);
        startActivity(intent);
        finish();
        System.exit(0);}

    //carrega os dados dos jogos feitos pelo usuario e os separa para qual tela de resultado serao enviados
    public void resultadodacomparacao(View view){
        if(listadenumeros.size() != 0){
            ArrayList<String> tempjgum = getIntent().getStringArrayListExtra("valorescheckjogoum");
            if(tempjgum != null){
                //quando usuario gerar mais de um jogo ele sera separado e enviado para tela de multiplos resultados
                Intent intent = new Intent(this, Quina_Varios_Resultados.class);
                intent.putIntegerArrayListExtra("sorteiodenumeros", listadenumeros);


                intent.putStringArrayListExtra("valorescheckjogoum",tempjgum);

                ArrayList<String> tempjgdos = getIntent().getStringArrayListExtra("valorecheckjogodois");

                intent.putStringArrayListExtra("valorescheckjogodois",tempjgdos);

                ArrayList<String> tempjgtrs = getIntent().getStringArrayListExtra("valorescheckjogotres");

                intent.putStringArrayListExtra("valorescheckjogotres",tempjgtrs);

                startActivity(intent);

                finish();
                System.exit(0);

            }else{
                //quando o usuario gerar somente um jogo ele sera enviado para a tela de resultado unico
                Intent intent = new Intent(this, Quina_Resultado.class);

                intent.putIntegerArrayListExtra("sorteiodenumeros", listadenumeros);

                ArrayList<String> valorescheck = getIntent().getStringArrayListExtra("valoreschecados");

                intent.putStringArrayListExtra("valoreschecados", valorescheck);

                startActivity(intent);

                finish();
                System.exit(0);
            }
        }else{
            Toast.makeText(this,"Faça o sorteio primeiro", Toast.LENGTH_SHORT).show();}

    }
}