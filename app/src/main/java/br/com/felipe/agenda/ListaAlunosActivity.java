package br.com.felipe.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        carregarListaAluno();
        inserir();
    }

    private void carregarListaAluno() {
        final List<String> lista = new ArrayList<String>();
        for (int count = 0; count <= 10; count++) {
            lista.add("Nome " + count);
        }

        ListView alunoList = (ListView) findViewById(R.id.lista_aluno);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        alunoList.setAdapter(adapter);
    }

    private void inserir() {
        Button btnInserir = (Button) findViewById(R.id.lista_aluno_btn_inserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentToFormulario);
            }
        });
    }
}
