package br.com.felipe.agenda.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.felipe.agenda.R;
import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;

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
        final LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.layout_lista_alunos, parent, false);
        }
        AndroidUtil.obterComponenteTextView(view, R.id.lt_list_alu_nome).setText(aluno.getNome());
        AndroidUtil.obterComponenteTextView(view, R.id.lt_list_alu_fone).setText(aluno.getFone());
        final ImageView foto = AndroidUtil.obterComponenteImageView(view, R.id.lt_list_alu_foto);
        if (aluno.getCaminhoFoto() != null) {
            final Bitmap bitmap = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
            final Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            foto.setImageBitmap(bitmapReduzido);
            foto.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return view;
    }
}
