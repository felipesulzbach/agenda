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

    private FormularioHelper(FormularioActivity activity) {
        this.activity = activity;
    }

    public static synchronized FormularioHelper create(FormularioActivity activity) {
        return new FormularioHelper(activity);
    }

    public Aluno pegarAluno() {
        return Aluno.create().withId(1L)
                .withNome(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_nome))
                .withSexo(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_sexo))
                .withIdade(AndroidUtil.obterValorCampoInteger(this.activity, R.id.formulario_idade))
                .withEndereco(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_endereco))
                .withFone(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_telefone))
                .withSite(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_site))
                .withEmail(AndroidUtil.obterValorCampoString(this.activity, R.id.formulario_email))
                .withNota(AndroidUtil.obterValorCampoBigDecimal(this.activity, R.id.formulario_nota));
    }
}
