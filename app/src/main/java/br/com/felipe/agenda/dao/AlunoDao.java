package br.com.felipe.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;
import br.com.felipe.agenda.util.NumberUtil;
import br.com.felipe.agenda.util.SqlUtil;

/**
 * Created by felipe on 12/01/2017.
 */
public class AlunoDao extends SQLiteOpenHelper {

    private AlunoDao(Context context) {
        super(context, "Agenda", null, 1);
    }

    public static synchronized AlunoDao create(Context context) {
        return new AlunoDao(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE TABLE aluno (");
            sql.append("id INTEGER PRIMARY KEY");
            sql.append(",nome TEXT NOT NULL");
            sql.append(",sexo TEXT NOT NULL");
            sql.append(",idade INTEGER");
            sql.append(",endereco TEXT");
            sql.append(",fone TEXT");
            sql.append(",site TEXT");
            sql.append(",email TEXT");
            sql.append(",nota REAL");
            sql.append(");");
            db.execSQL(sql.toString());
        } catch (SQLException ex) {
            AndroidUtil.tratarExcecao(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DROP TABLE IF EXISTS aluno;");
            db.execSQL(sql.toString());

            onCreate(db);
        } catch (SQLException ex) {
            AndroidUtil.tratarExcecao(ex);
        }
    }

    public List<Aluno> buscarAlunoList() {
        List<Aluno> lista = new ArrayList<Aluno>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM aluno;");
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(sql.toString(), null);

            while (cursor.moveToNext()) {
                lista.add(Aluno.create().withId(cursor.getLong(cursor.getColumnIndex("id")))
                        .withNome(cursor.getString(cursor.getColumnIndex("nome")))
                        .withSexo(cursor.getString(cursor.getColumnIndex("sexo")))
                        .withIdade(cursor.getInt(cursor.getColumnIndex("idade")))
                        .withEndereco(cursor.getString(cursor.getColumnIndex("endereco")))
                        .withFone(cursor.getString(cursor.getColumnIndex("fone")))
                        .withSite(cursor.getString(cursor.getColumnIndex("site")))
                        .withEmail(cursor.getString(cursor.getColumnIndex("email")))
                        .withNota(NumberUtil.doubleToBigDecimal(cursor.getDouble(cursor.getColumnIndex("nota")), BigDecimal.ZERO)));
            }
            cursor.close();
        } catch (SQLException ex) {
            AndroidUtil.tratarExcecao(ex);
        }
        return lista;
    }

    public void inserir(Aluno aluno) {
        try {
            ContentValues values = new ContentValues();
            values.put("nome", aluno.getNome());
            values.put("sexo", aluno.getSexo());
            values.put("idade", aluno.getIdade());
            values.put("endereco", aluno.getEndereco());
            values.put("fone", aluno.getFone());
            values.put("site", aluno.getSite());
            values.put("email", aluno.getEmail());
            values.put("nota", aluno.getNota().doubleValue());

            SQLiteDatabase db = getWritableDatabase();
            db.insert("aluno", null, values);
        } catch (SQLException ex) {
            AndroidUtil.tratarExcecao(ex);
        }
    }

    public void excluir(Aluno aluno) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            final Map filtros = new HashMap<String, SqlUtil.ClausulaEnum>();
            filtros.put("id", null);
            db.delete("aluno", SqlUtil.retornarFiltros(filtros), SqlUtil.retornarValorFiltros(aluno.getId()));
        } catch (SQLException ex) {
            AndroidUtil.tratarExcecao(ex);
        }
    }
}
