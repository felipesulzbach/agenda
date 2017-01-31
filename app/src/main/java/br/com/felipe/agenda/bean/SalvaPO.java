package br.com.felipe.agenda.bean;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by felipe on 23/01/2017.
 */
public class SalvaPO implements Serializable {

    private SQLiteOpenHelper helper;
    private boolean flIserir;
    private String nomTabela;
    private ContentValues values;
    private String filtros;
    private String[] valorFiltros;

    private SalvaPO() {}

    public static synchronized SalvaPO create() {
        return new SalvaPO();
    }

    public SQLiteOpenHelper getHelper() {
        return helper;
    }

    public SalvaPO withHelper(final SQLiteOpenHelper helper) {
        this.helper = helper;
        return this;
    }

    public boolean isFlIserir() {
        return flIserir;
    }

    public SalvaPO withFlIserir(final boolean flIserir) {
        this.flIserir = flIserir;
        return this;
    }

    public String getNomTabela() {
        return nomTabela;
    }

    public SalvaPO withNomTabela(final String nomTabela) {
        this.nomTabela = nomTabela;
        return this;
    }

    public ContentValues getValues() {
        return values;
    }

    public SalvaPO withValues(final ContentValues values) {
        this.values = values;
        return this;
    }

    public String getFiltros() {
        return filtros;
    }

    public SalvaPO withFiltros(final String filtros) {
        this.filtros = filtros;
        return this;
    }

    public String[] getValorFiltros() {
        return valorFiltros;
    }

    public SalvaPO withValorFiltros(final String[] valorFiltros) {
        this.valorFiltros = valorFiltros;
        return this;
    }
}
