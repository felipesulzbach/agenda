package br.com.felipe.agenda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.felipe.agenda.util.PerifericoEnum;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;
    private String caminhoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.helper = FormularioHelper.create(this);
        this.helper.carregarAluno(this);
        this.caminhoFoto = this.helper.retornarCaminhoFoto();
        this.helper.selecionarParaFoto(this.caminhoFoto);
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
                this.helper.salvar();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == PerifericoEnum.CAMERA.getValue()) {
            helper.carregarImagem(caminhoFoto);
        }
    }
}
