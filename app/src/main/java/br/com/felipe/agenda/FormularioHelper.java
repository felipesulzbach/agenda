package br.com.felipe.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import java.math.BigDecimal;

import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;

/**
 * Created by felipe on 11/01/2017.
 */
public class FormularioHelper {

    private FormularioActivity activity;
    private Aluno aluno;

    private FormularioHelper(FormularioActivity activity) {
        this.activity = activity;
        this.aluno = Aluno.create();
    }

    public static synchronized FormularioHelper create(FormularioActivity activity) {
        return new FormularioHelper(activity);
    }

    public Aluno pegarAluno() {
        return this.aluno.withNome(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_nome))
                .withSexo(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_sexo))
                .withIdade(AndroidUtil.obterValorCampoInteger(this.activity, R.id.formulario_idade))
                .withEndereco(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_endereco))
                .withFone(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_telefone))
                .withSite(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_site))
                .withEmail(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_email))
                .withNota(AndroidUtil.obterValorCampoBigDecimal(this.activity, R.id.formulario_nota));
    }

    public void carregarParaEdicao(final Aluno aluno) {
        this.aluno = aluno;
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_nome).setText(aluno.getNome());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_sexo).setText(aluno.getSexo());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_idade).setText(aluno.getIdade().toString());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_endereco).setText(aluno.getEndereco());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_telefone).setText(aluno.getFone());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_site).setText(aluno.getSite());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_email).setText(aluno.getEmail());
        AndroidUtil.obterComponenteRatingBar(this.activity, R.id.formulario_nota).setProgress(aluno.getNota().intValue());
    }
}
