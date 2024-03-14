package com.example.projeto1;

import static com.example.projeto1.R.*;

import static java.util.Arrays.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText texto1, texto2, texto3, texto4;

    boolean isFirst = true;
    TextView resposta;
    Button trocar_tela;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        texto1 = (EditText) findViewById(R.id.textoEdit1);
        texto2 = (EditText) findViewById(R.id.textoEdit2);
        texto3 = (EditText) findViewById(R.id.textoEdit3);
        texto4 = (EditText) findViewById(R.id.textoEdit4);

        resposta = (TextView) findViewById(R.id.texto7);

        trocar_tela = (Button) findViewById(id.trocar_tela);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        trocar_tela.setOnClickListener(v -> trocarTela());
    }

    private void trocarTela() {
        Intent intent = new Intent(MainActivity.this, TelaDois.class);
        intent.putExtra("numerosOrdenados", resposta.getText().toString());
        startActivities(new Intent[]{intent});
    }

    public void editar(View view) {

        if(texto1.getText().toString().isEmpty() || texto2.getText().toString().isEmpty()
                || texto3.getText().toString().isEmpty() || texto4.getText().toString().isEmpty()){
            resposta.setText("Preencha os campos, são obrigatorios!");
        } else {
            // Pegando os valores que foram digitados
            int valor1 = Integer.parseInt(texto1.getText().toString());
            int valor2 = Integer.parseInt(texto2.getText().toString());
            int valor3 = Integer.parseInt(texto3.getText().toString());
            int valor4 = Integer.parseInt(texto4.getText().toString());

            if(!isFirst) {
                resposta.setText("");
            }

            // Mostrar na tela os valores lidos
            String valoresLidos = valor1 + " " + valor2 + " " + valor3 + " " + valor4;
            resposta.append("Valores lidos: " + valoresLidos);

            ArrayList<Integer> numerosArray = new ArrayList<>();
            numerosArray.add(valor1);
            numerosArray.add(valor2);
            numerosArray.add(valor3);
            numerosArray.add(valor4);

            // Ordenar em ordem crescente
            Collections.sort(numerosArray);
            resposta.append("\nValores em Ordem Crescente: " + numerosArray.toString() + "\n");

            // Ordenar os valores em Ordem Decrescente
            Collections.reverse(numerosArray);
            resposta.append("\nValores em Ordem Decrescente: " + numerosArray.toString() + "\n");

            isFirst = false;
        }
    }
}