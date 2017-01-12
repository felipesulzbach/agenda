package br.com.felipe.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import java.math.BigDecimal;

import br.com.felipe.agenda.model.Aluno;

/**
 * Created by felipe on 11/01/2017.
 */
public class FormularioHelper {

    private FormularioHelper() {}

    public static synchronized FormularioHelper create() {
        return new FormularioHelper();
    }

    public static Aluno pegarAluno(FormularioActivity activity) {
        return Aluno.create().withId(1L)
                .withNome(obterValorCampoString(activity, R.id.formulario_nome))
                .withSexo(obterValorCampoString(activity, R.id.formulario_sexo))
                .withIdade(obterValorCampoInteger(activity, R.id.formulario_idade))
                .withEndereco(obterValorCampoString(activity, R.id.formulario_endereco))
                .withFone(obterValorCampoString(activity, R.id.formulario_telefone))
                .withSite(obterValorCampoString(activity, R.id.formulario_site))
                .withEmail(obterValorCampoString(activity, R.id.formulario_email))
                .withNota(obterValorCampoBigDecimal(activity, R.id.formulario_nota));
    }

    private static String obterValorCampoString(FormularioActivity activity, final int id) {
        return ((EditText) activity.findViewById(id)).getText().toString().trim();
    }

    private static Integer obterValorCampoInteger(FormularioActivity activity, final int id) {
        try {
            return Integer.parseInt(obterValorCampoString(activity, id));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private static BigDecimal obterValorCampoBigDecimal(FormularioActivity activity, final int id) {
        return new BigDecimal(((RatingBar) activity.findViewById(id)).getProgress());
    }
}
