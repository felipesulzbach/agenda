package br.com.felipe.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.helper = FormularioHelper.create(this);
        carregarAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                salvar();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void carregarAluno() {
        Intent intent = getIntent();
        final Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if (aluno != null) {
            this.helper.carregarParaEdicao(aluno);
        }
    }

    private void salvar() {
        final AlunoDao dao = AlunoDao.create(this);
        final Aluno aluno = this.helper.pegarAluno();
        dao.salvar(aluno, AndroidUtil.isIsercao(aluno.getId()));
        dao.close();

        Toast.makeText(this, "Aluno " + aluno.getNome() + " salvo com Sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }


}
