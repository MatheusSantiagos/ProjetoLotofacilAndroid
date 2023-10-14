package com.example.projetomegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TeladeSelecao extends AppCompatActivity {
    ArrayList<String> valorescheck = new ArrayList<>(6);
    ArrayList<String> valorescheckjogo1 = new ArrayList<>(6); ArrayList<String> valorescheckjogo2 = new ArrayList<>(6); ArrayList<String> valorescheckjogo3 = new ArrayList<>(6);

    CheckBox[] cba;
    private Button botao4;
    int i =0, cont=0, jogos=1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_selecao);


        //declaracao dos botoes de checkbox
        cba = new CheckBox[]{
                (CheckBox)findViewById(R.id.checkBox1), (CheckBox)findViewById(R.id.checkBox11), (CheckBox)findViewById(R.id.checkBox21),
                (CheckBox)findViewById(R.id.checkBox2), (CheckBox)findViewById(R.id.checkBox12), (CheckBox)findViewById(R.id.checkBox22),
                (CheckBox)findViewById(R.id.checkBox3), (CheckBox)findViewById(R.id.checkBox13), (CheckBox)findViewById(R.id.checkBox23),
                (CheckBox)findViewById(R.id.checkBox4), (CheckBox)findViewById(R.id.checkBox14), (CheckBox)findViewById(R.id.checkBox24),
                (CheckBox)findViewById(R.id.checkBox5), (CheckBox)findViewById(R.id.checkBox15), (CheckBox)findViewById(R.id.checkBox25),
                (CheckBox)findViewById(R.id.checkBox6), (CheckBox)findViewById(R.id.checkBox16), (CheckBox)findViewById(R.id.checkBox26),
                (CheckBox)findViewById(R.id.checkBox7), (CheckBox)findViewById(R.id.checkBox17), (CheckBox)findViewById(R.id.checkBox27),
                (CheckBox)findViewById(R.id.checkBox8), (CheckBox)findViewById(R.id.checkBox18), (CheckBox)findViewById(R.id.checkBox28),
                (CheckBox)findViewById(R.id.checkBox9), (CheckBox)findViewById(R.id.checkBox19), (CheckBox)findViewById(R.id.checkBox29),
                (CheckBox)findViewById(R.id.checkBox10), (CheckBox)findViewById(R.id.checkBox20), (CheckBox)findViewById(R.id.checkBox30)};

        for (CheckBox cb:cba){
            cb.setOnCheckedChangeListener(cbListener);
        }
    }

    CompoundButton.OnCheckedChangeListener cbListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.isChecked()){
                if(valorescheck.size()<6){
                    //coleta os valores nas caixas de seleção
                    valorescheck.add(compoundButton.getText().toString());
                    //remove duplicatas
                    Set<String> valoreschecktemp = new HashSet<>(valorescheck);
                    valorescheck.clear();
                    valorescheck.addAll(valoreschecktemp);
                }
            }else{
                //remove valores desmarcados
                valorescheck.remove(compoundButton.getText().toString());
            }
            marcoutodosedesabilitar(cba);
        }
    };
    //desabilita checkboxes quando chega a 6 marcados
    private void marcoutodosedesabilitar(CheckBox checkBoxes[]){
        int contacheck =0;
        for (CheckBox cb:checkBoxes){
            cb.setEnabled(true);
            if (cb.isChecked()) contacheck++;
        }
        int a = 6;
        if (a<= contacheck){
            for (CheckBox cb:checkBoxes){
                if (!cb.isChecked())cb.setEnabled(false);
            }
        }
    }
    //retorna ao menu Principal
    public void voltarmenuprincipal(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        System.exit(0);
    }


    public void numerosselecionados(View v){
        // imprime valores marcados
        TextView Testando = findViewById(R.id.Teste);
        Testando.setText(valorescheck.toString());

    }

    //ao pressionar o botao cria um novo jogo com um limite de até 3 jogos por vez, reiniciando a contagem de checkbox e reativando
    public void criarnovojogo(View view){
            Intent intent = new Intent (this, Sorteio.class);

            if(jogos==1 && valorescheck.size() ==6){
                Toast.makeText(this,"Jogo "+jogos+" registrado",Toast.LENGTH_LONG).show();
                valorescheckjogo1 = (ArrayList<String>)valorescheck.clone();
                intent.putStringArrayListExtra("valorescheckjogoum",valorescheckjogo1);
                valorescheck.clear();
                reabilitar(cba);
                jogos++;}

            if(jogos==2 && valorescheck.size() ==6){
                Toast.makeText(this,"Jogo "+jogos+" registrado",Toast.LENGTH_SHORT).show();
                valorescheckjogo2 = (ArrayList<String>)valorescheck.clone();
                intent.putStringArrayListExtra("valorecheckjogodois",valorescheckjogo2);
                valorescheck.clear();
                reabilitar(cba);
                jogos++;}

            if(jogos ==3 && valorescheck.size() ==6){
                Toast.makeText(this,"Jogo "+jogos+" registrado, Numero de Jogos Excedido",Toast.LENGTH_SHORT).show();
                valorescheckjogo3 = (ArrayList<String>)valorescheck.clone();
                intent.putStringArrayListExtra("valorescheckjogotres",valorescheckjogo3);
                jogos++;}

            if(jogos>3){
                botao4.setEnabled(false);
                }

            if(valorescheck.size()<6 && valorescheck.size() >= 1){
                Toast.makeText(this,"Selecione todos os numeros antes de fazer um jogo",Toast.LENGTH_SHORT).show();}

    }

    //avanca para a tela de sorteio carregando os valores selecionados das checkboxes de um ou mais jogos
    public void teladesorteio(View view){

        if(valorescheck.size() ==6){
            Intent intent = new Intent(this, Sorteio.class);
            if(valorescheckjogo1.isEmpty()){
                Toast.makeText(this,"Jogo Unico",Toast.LENGTH_SHORT).show();
            }else{
                intent.putStringArrayListExtra("valorescheckjogoum",valorescheckjogo1);

                if(valorescheckjogo2.isEmpty()){
                    valorescheckjogo2 = (ArrayList<String>)valorescheck.clone();
                    intent.putStringArrayListExtra("valorecheckjogodois",valorescheckjogo2);
                }else{
                    intent.putStringArrayListExtra("valorecheckjogodois",valorescheckjogo2);}

                if(valorescheckjogo3.isEmpty()){
                    valorescheckjogo3 = (ArrayList<String>)valorescheck.clone();
                    intent.putStringArrayListExtra("valorescheckjogotres",valorescheckjogo3);
                }else{
                    intent.putStringArrayListExtra("valorescheckjogotres",valorescheckjogo3);}
            }
            intent.putStringArrayListExtra("valoreschecados", valorescheck);
            startActivity(intent);
            finish();
            System.exit(0);
        } else{
            Toast.makeText(this,"Selecione os numeros primeiro", Toast.LENGTH_SHORT).show();
        }
    }

    //reabilita checkbox em casos de novos jogos
    private void reabilitar(CheckBox checkBoxes[]){
      for(CheckBox cb:cba){
          if(cb.isChecked()){
              cb.setChecked(false);
          }
          cb.setEnabled(true);
      }
    }

}