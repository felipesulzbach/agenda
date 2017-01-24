package br.com.felipe.agenda.bean;

import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by felipe on 23/01/2017.
 */
public class ExcluiPO implements Serializable {

    private SQLiteOpenHelper helper;
    private String nomTabela;
    private String filtros;
    private String[] valorFiltros;

    private ExcluiPO() {}

    public static synchronized ExcluiPO create() {
        return new ExcluiPO();
    }

    public SQLiteOpenHelper getHelper() {
        return helper;
    }

    public ExcluiPO withHelper(final SQLiteOpenHelper helper) {
        this.helper = helper;
        return this;
    }

    public String getNomTabela() {
        return nomTabela;
    }

    public ExcluiPO withNomTabela(final String nomTabela) {
        this.nomTabela = nomTabela;
        return this;
    }

    public String getFiltros() {
        return filtros;
    }

    public ExcluiPO withFiltros(final String filtros) {
        this.filtros = filtros;
        return this;
    }

    public String[] getValorFiltros() {
        return valorFiltros;
    }

    public ExcluiPO withValorFiltros(final String[] valorFiltros) {
        this.valorFiltros = valorFiltros;
        return this;
    }
}
