package br.com.felipe.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.felipe.agenda.model.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper = FormularioHelper.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
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

    private void salvar() {
        final Aluno aluno = this.helper.pegarAluno(this);
        Toast.makeText(this, "Aluno " + aluno.getNome() + " salvo com Sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
