package com.example.projeto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaDois extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teladois); // Certifique-se de que este é o layout correto

        // Obtém a referência para o TextView e o Button
        TextView textViewNumeros = findViewById(R.id.ordem);
        Button btnVoltar = findViewById(R.id.voltar);

        // Pega a string dos números ordenados passados pela MainActivity
        String numerosOrdenados = getIntent().getStringExtra("numerosOrdenados");
        // Define o texto do TextView para mostrar os números
        textViewNumeros.setText(numerosOrdenados);

        // Configura o listener do botão voltar para finalizar a SecondActivity e retornar à MainActivity
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza a SecondActivity e volta para a tela anterior
                finish();
            }
        });
    }
}
