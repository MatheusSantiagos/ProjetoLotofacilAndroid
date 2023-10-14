package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class Resultadodocomparacao extends AppCompatActivity {
    int i,cont;
    ArrayList<String> valorescheck2 = new ArrayList();
    ArrayList<Integer> listadenumeros2 = new ArrayList<Integer>();

    //carrega instancias salvas no sorteio e as arraylist dos checkboxes selecionados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadodocomparacao);
        valorescheck2 = getIntent().getStringArrayListExtra("valoreschecados");
        listadenumeros2 = getIntent().getIntegerArrayListExtra("sorteiodenumeros");}

    //retorna ao menu principal
    public void voltarmenuprincipal(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        System.exit(0);}


    public void compar (View view){
        int auxelement = 0; int auxelement3 = 0;
        Object auxelement4;
        String auxelement2;

        //realiza as comparacao de elementos das arraylist e retorna a quantidade de elementos resultantes

        for(i=0; i< valorescheck2.size(); i++){
            for(int j=0; j<valorescheck2.size(); j++){
                auxelement2 = valorescheck2.get(i);
                auxelement3 = Integer.valueOf(auxelement2);
                auxelement4 = listadenumeros2.get(j); auxelement = (Integer) auxelement4;
                if(auxelement == auxelement3){
                    cont++;}
            }
        }

        TextView compa = findViewById(R.id.comparacao);
        compa.setText(":" +cont);
        cont =0;
        Collections.sort(valorescheck2);
        Collections.sort(listadenumeros2);

        //declara os textvies presentes para o carregamento de valores
        TextView numerosselecionados = findViewById(R.id.numsel01); TextView numerosselecionados2 = findViewById(R.id.numsel02);
        TextView numerosselecionados3 = findViewById(R.id.numsel03); TextView numerosselecionados4 = findViewById(R.id.numsel04);
        TextView numerosselecionados5 = findViewById(R.id.numsel05); TextView numerosselecionados6 = findViewById(R.id.numsel06);

        TextView numerosdosorteio = findViewById(R.id.numsort01); TextView numerosdosorteio2 = findViewById(R.id.numsort02);
        TextView numerosdosorteio3 = findViewById(R.id.numsort03); TextView numerosdosorteio4 = findViewById(R.id.numsort04);
        TextView numerosdosorteio5 = findViewById(R.id.numsort05); TextView numerosdosorteio6 = findViewById(R.id.numsort06);

        //carrega os valores em tela
        numerosselecionados.setText("" +valorescheck2.get(0)); numerosselecionados2.setText("" +valorescheck2.get(1));
        numerosselecionados3.setText("" +valorescheck2.get(2)); numerosselecionados4.setText("" +valorescheck2.get(3));
        numerosselecionados5.setText("" +valorescheck2.get(4)); numerosselecionados6.setText("" +valorescheck2.get(5));

        numerosdosorteio.setText("" +listadenumeros2.get(0)); numerosdosorteio2.setText("" +listadenumeros2.get(1));
        numerosdosorteio3.setText("" +listadenumeros2.get(2)); numerosdosorteio4.setText("" +listadenumeros2.get(3));
        numerosdosorteio5.setText("" +listadenumeros2.get(4)); numerosdosorteio6.setText("" +listadenumeros2.get(5));

    }

}