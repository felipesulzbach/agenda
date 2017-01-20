package br.com.felipe.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView alunoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        inserir();

        this.alunoList = (ListView) findViewById(R.id.lista_aluno);
        registerForContextMenu(this.alunoList);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem remove = menu.add("Remover");
        remove.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno) alunoList.getItemAtPosition(info.position);
                final AlunoDao dao = AlunoDao.create(ListaAlunosActivity.this);
                dao.excluir(aluno);
                dao.close();

                carregarListaAluno();

                Toast.makeText(ListaAlunosActivity.this, "Aluno " + aluno.getNome() + "removido com Sucesso!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void carregarListaAluno() {
        final AlunoDao dao = AlunoDao.create(this);
        final List<Aluno> lista = dao.buscarAlunoList();
        dao.close();


        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, lista);
        this.alunoList.setAdapter(adapter);
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
