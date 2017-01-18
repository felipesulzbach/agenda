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

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        inserir();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaAluno();
    }

    private void carregarListaAluno() {
        final AlunoDao dao = AlunoDao.create(this);
        final List<Aluno> lista = dao.buscarAlunoList();
        dao.close();

        ListView alunoList = (ListView) findViewById(R.id.lista_aluno);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, lista);
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
