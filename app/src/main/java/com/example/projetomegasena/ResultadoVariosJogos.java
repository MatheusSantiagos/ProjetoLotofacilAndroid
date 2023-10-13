package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultadoVariosJogos extends AppCompatActivity {
    int jogonum = 1, i = 0, cont;
    private Button botaoprox;
    private Button botaoant;
    private Button conferidor;
    ArrayList<Integer> listadenumeros2 = new ArrayList<Integer>();
    ArrayList<String> valoresparachecktemp = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_varios_jogos);
        listadenumeros2 = getIntent().getIntegerArrayListExtra("sorteiodenumeros");

        conferidor = findViewById(R.id.conferes);

        botaoprox = findViewById(R.id.proxjogo);
        botaoprox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jogonum <3){
                    jogonum++;
                    conferidor.setEnabled(true);
                }else{
                    Toast.makeText(getApplication().getBaseContext(), "Esse é o ultimo jogo",Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaoant = findViewById(R.id.jogoant);
        botaoant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jogonum > 1){
                    jogonum--;
                }else{
                   Toast.makeText(getApplication().getBaseContext(),"Nao existe jogo anterior" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Alterador(View view){

        TextView resultadocompar = findViewById(R.id.Resultadocompar);
        TextView numerodojogo = findViewById(R.id.Jogoxis);
        TextView numeroesc1 = findViewById(R.id.textView26);    TextView numeroesc2 = findViewById(R.id.textView27);
        TextView numeroesc3 = findViewById(R.id.textView28);    TextView numeroesc4 = findViewById(R.id.textView29);
        TextView numeroesc5 = findViewById(R.id.textView30);    TextView numeroesc6 = findViewById(R.id.textView31);

        TextView numerosorte1 = findViewById(R.id.textView33);    TextView numerosorte2 = findViewById(R.id.textView34);
        TextView numerosorte3 = findViewById(R.id.textView35);    TextView numerosorte4 = findViewById(R.id.textView36);
        TextView numerosorte5 = findViewById(R.id.textView37);    TextView numerosorte6 = findViewById(R.id.textView38);

        if(jogonum == 1){
            valoresparachecktemp.clear();
            valoresparachecktemp = getIntent().getStringArrayListExtra("valorescheckjogoum");
            numerodojogo.setText("Jogo 1:");
            comparador(valoresparachecktemp);

            resultadocompar.setText(":"+cont);
            numeroesc1.setText(""+valoresparachecktemp.get(0)); numeroesc2.setText(""+valoresparachecktemp.get(1));
            numeroesc3.setText(""+valoresparachecktemp.get(2)); numeroesc4.setText(""+valoresparachecktemp.get(3));
            numeroesc5.setText(""+valoresparachecktemp.get(4)); numeroesc6.setText(""+valoresparachecktemp.get(5));

            numerosorte1.setText(""+listadenumeros2.get(0));   numerosorte2.setText(""+listadenumeros2.get(1));
            numerosorte3.setText(""+listadenumeros2.get(2));   numerosorte4.setText(""+listadenumeros2.get(3));
            numerosorte5.setText(""+listadenumeros2.get(4));   numerosorte6.setText(""+listadenumeros2.get(5));
            conferidor.setEnabled(false);
        }

        if(jogonum == 2){

            valoresparachecktemp.clear();
            valoresparachecktemp = getIntent().getStringArrayListExtra("valorescheckjogodois");
            numerodojogo.setText("Jogo 2:");

            comparador(valoresparachecktemp);
            resultadocompar.setText(":"+cont);
            numeroesc1.setText(""+valoresparachecktemp.get(0)); numeroesc2.setText(""+valoresparachecktemp.get(1));
            numeroesc3.setText(""+valoresparachecktemp.get(2)); numeroesc4.setText(""+valoresparachecktemp.get(3));
            numeroesc5.setText(""+valoresparachecktemp.get(4)); numeroesc6.setText(""+valoresparachecktemp.get(5));
            conferidor.setEnabled(false);

        }
        if(jogonum == 3){

            valoresparachecktemp.clear();
            valoresparachecktemp = getIntent().getStringArrayListExtra("valorescheckjogotres");

            if(valoresparachecktemp == null){
                Toast.makeText(this,"Voce so fez dois jogos",Toast.LENGTH_SHORT).show();
            }else{
                numerodojogo.setText("Jogo 3:");
                comparador(valoresparachecktemp);
                resultadocompar.setText(":"+cont);
                numeroesc1.setText(""+valoresparachecktemp.get(0)); numeroesc2.setText(""+valoresparachecktemp.get(1));
                numeroesc3.setText(""+valoresparachecktemp.get(2)); numeroesc4.setText(""+valoresparachecktemp.get(3));
                numeroesc5.setText(""+valoresparachecktemp.get(4)); numeroesc6.setText(""+valoresparachecktemp.get(5));
                conferidor.setEnabled(false);
            }

        }
    }

    public int comparador(ArrayList valoresparachecktemp){
        int auxelement = 0; int auxelement3 = 0;
        Object auxelement4, auxelement2;
        cont = 0;
        for(i=0; i< valoresparachecktemp.size(); i++){
            for(int j=0; j<valoresparachecktemp.size(); j++){
                auxelement2 = valoresparachecktemp.get(i);
                auxelement3 = Integer.valueOf(auxelement2.toString());
                auxelement4 = listadenumeros2.get(j); auxelement = (Integer) auxelement4;
                if(auxelement == auxelement3){
                    cont++;
                }
            }

        }
    return cont;
    }

    public void voltarmenuprincipal(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }


}