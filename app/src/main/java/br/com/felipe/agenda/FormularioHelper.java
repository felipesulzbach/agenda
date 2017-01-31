package br.com.felipe.agenda;

import android.content.Intent;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;

/**
 * Created by felipe on 11/01/2017.
 */
public class FormularioHelper {

    private FormularioActivity activity;
    private Aluno alunoSelecionado;

    private FormularioHelper(FormularioActivity activity) {
        this.activity = activity;
        this.alunoSelecionado = Aluno.create();
    }

    public static synchronized FormularioHelper create(FormularioActivity activity) {
        return new FormularioHelper(activity);
    }

    public void carregarAluno(FormularioActivity activity) {
        Intent intent = activity.getIntent();
        final Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if (aluno != null) {
            carregarParaEdicao(aluno);
        }
    }

    private void carregarParaEdicao(final Aluno aluno) {
        this.alunoSelecionado = aluno;
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_nome).setText(aluno.getNome());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_sexo).setText(aluno.getSexo());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_idade).setText(aluno.getIdade().toString());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_endereco).setText(aluno.getEndereco());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_telefone).setText(aluno.getFone());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_site).setText(aluno.getSite());
        AndroidUtil.obterComponenteEditText(this.activity, R.id.formulario_email).setText(aluno.getEmail());
        AndroidUtil.obterComponenteRatingBar(this.activity, R.id.formulario_nota).setProgress(aluno.getNota().intValue());
    }

    public void salvar() {
        final AlunoDao dao = AlunoDao.create(this.activity);
        final Aluno aluno = pegarAluno();
        dao.salvar(aluno, AndroidUtil.isIsercao(aluno.getId()));
        dao.close();

        Toast.makeText(this.activity, this.activity.getString(R.string.txt_aluno) + aluno.getNome() + this.activity.getString(R.string.msg_salva), Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }

    private Aluno pegarAluno() {
        return this.alunoSelecionado.withNome(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_nome))
                .withSexo(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_sexo))
                .withIdade(AndroidUtil.obterValorCampoInteger(this.activity, R.id.formulario_idade))
                .withEndereco(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_endereco))
                .withFone(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_telefone))
                .withSite(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_site))
                .withEmail(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_email))
                .withNota(AndroidUtil.obterValorCampoBigDecimal(this.activity, R.id.formulario_nota));
    }
}
