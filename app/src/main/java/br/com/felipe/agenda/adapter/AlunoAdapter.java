package br.com.felipe.agenda.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.felipe.agenda.model.Aluno;

/**
 * Created by felipe on 15/02/2017.
 */
public class AlunoAdapter extends BaseAdapter {

    private Context context;
    private List<Aluno> alunolist;

    private AlunoAdapter(Context context, final List<Aluno> alunolist) {
        this.context = context;
        this.alunolist = alunolist;
    }

    public static synchronized AlunoAdapter create(Context context, final List<Aluno> alunolist) {
        return new AlunoAdapter(context, alunolist);
    }

    @Override
    public int getCount() {
        return this.alunolist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.alunolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Aluno) getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Aluno aluno = (Aluno) getItem(position);
        TextView view = new TextView(this.context);
        view.setText("");
        return view;
    }
}
