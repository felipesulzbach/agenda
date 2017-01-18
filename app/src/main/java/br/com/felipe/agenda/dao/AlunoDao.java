package br.com.felipe.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.NumberUtil;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        StringBuilder sql = new StringBuilder();
        sql.append("DROP TABLE IF EXISTS aluno;");
        db.execSQL(sql.toString());

        onCreate(db);
    }

    public void inserir(Aluno aluno) {
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
    }

    public List<Aluno> buscarAlunoList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM aluno;");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql.toString(), null);

        List<Aluno> lista = new ArrayList<Aluno>();
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

        return lista;
    }
}
