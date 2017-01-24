package br.com.felipe.agenda.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.felipe.agenda.FormularioActivity;
import br.com.felipe.agenda.ListaAlunosActivity;
import br.com.felipe.agenda.bean.ExcluiPO;
import br.com.felipe.agenda.bean.SalvaPO;

/**
 * Created by felipe on 18/01/2017.
 */
public class AndroidUtil {

    private AndroidUtil() {}

    public static EditText obterComponenteEditText(AppCompatActivity activity, final int id) {
        return (EditText) activity.findViewById(id);
    }

    public static RatingBar obterComponenteRatingBar(AppCompatActivity activity, final int id) {
        return (RatingBar) activity.findViewById(id);
    }

    public static String obterValorCampoString(AppCompatActivity activity, final int id) {
        return obterComponenteEditText(activity, id).getText().toString().trim();
    }

    public static Integer obterValorCampoInteger(AppCompatActivity activity, final int id) {
        try {
            return Integer.parseInt(obterValorCampoString(activity, id));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static BigDecimal obterValorCampoBigDecimal(AppCompatActivity activity, final int id) {
        return new BigDecimal((obterComponenteRatingBar(activity, id)).getProgress());
    }

    public static void tratarExcecao(SQLException ex) {
        System.out.println("Erro execucao SQL!");
    }

    public static void salvar(SalvaPO po) {
        SQLiteDatabase db = po.getHelper().getWritableDatabase();
        if (po.isFlIserir()) {
            db.insert(po.getNomTabela(), null, po.getValues());
        } else {
            db.update(po.getNomTabela(), po.getValues(), po.getFiltros(), po.getValorFiltros());
        }
    }

    public static void excluir(ExcluiPO po) {
        SQLiteDatabase db = po.getHelper().getWritableDatabase();
        db.delete(po.getNomTabela(), po.getFiltros(), po.getValorFiltros());
    }

    public static boolean isIsercao(final Long id) {
        return id == null;
    }
}
