package br.com.felipe.agenda;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.com.felipe.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListaAlunosHelper helper;
    private ListView alunoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        this.helper = ListaAlunosHelper.create(this);
        this.alunoList = (ListView) findViewById(R.id.lista_aluno);

        this.helper.selecionarParaInsercao();
        registerForContextMenu(this.alunoList);
        this.helper.selecionarParaEdicao(this.alunoList);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.helper.carregarListaAluno(this.alunoList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Aluno aluno = (Aluno) alunoList.getItemAtPosition(info.position);

        this.helper.injetarMenuEnviaSms(menu, aluno);
        this.helper.injetarMenuLigar(menu, aluno);
        this.helper.injetarMenuVisitaSite(menu, aluno);
        this.helper.injetarMenuRemove(menu, aluno, this.alunoList);
        this.helper.injetarMenuVisualizaMapa(menu, aluno);
    }
}
