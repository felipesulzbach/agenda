package br.com.felipe.agenda.util;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.File;
import java.math.BigDecimal;

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

    public static ImageView obterComponenteImageView(AppCompatActivity activity, final int id) {
        return (ImageView) activity.findViewById(id);
    }

    public static String obterValorCampoString(AppCompatActivity activity, final int id) {
        return obterComponenteEditText(activity, id).getText().toString().trim();
    }

    public static String obterValorCaminhoFoto(AppCompatActivity activity, final int id) {
        return (String) activity.findViewById(id).getTag();
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

    public static File returnJpg(AppCompatActivity activity) {
        final String caminhoFoto = activity.getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        return new File(caminhoFoto);
    }
}
