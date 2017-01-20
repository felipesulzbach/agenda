package br.com.felipe.agenda.util;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.felipe.agenda.FormularioActivity;
import br.com.felipe.agenda.ListaAlunosActivity;

/**
 * Created by felipe on 18/01/2017.
 */
public class AndroidUtil {

    private AndroidUtil() {}

    public static String obterValorCampoString(AppCompatActivity activity, final int id) {
        return ((EditText) activity.findViewById(id)).getText().toString().trim();
    }

    public static Integer obterValorCampoInteger(AppCompatActivity activity, final int id) {
        try {
            return Integer.parseInt(obterValorCampoString(activity, id));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static BigDecimal obterValorCampoBigDecimal(AppCompatActivity activity, final int id) {
        return new BigDecimal(((RatingBar) activity.findViewById(id)).getProgress());
    }

    public static void tratarExcecao(SQLException ex) {
        System.out.println("Erro execucao SQL!");
    }
}
