package br.com.felipe.agenda;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.TextUtil;

/**
 * Created by felipe on 27/01/2017.
 */
public class ListaAlunosHelper {

    private ListaAlunosActivity activity;
    private Aluno alunoSelecionado;

    private ListaAlunosHelper(ListaAlunosActivity activity) {
        this.activity = activity;
        this.alunoSelecionado = Aluno.create();
    }

    public static synchronized ListaAlunosHelper create(ListaAlunosActivity activity) {
        return new ListaAlunosHelper(activity);
    }


    public void carregarListaAluno(final ListView alunoList) {
        final AlunoDao dao = AlunoDao.create(this.activity);
        alunoList.setAdapter(new ArrayAdapter<Aluno>(this.activity, android.R.layout.simple_list_item_1, dao.buscarAlunoList()));
        dao.close();
    }

    public void selecionarParaInsercao() {
        final Button btnInserir = (Button) this.activity.findViewById(R.id.lista_aluno_btn_inserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(activity, FormularioActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    public void selecionarParaEdicao(final ListView alunoList) {
        alunoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Aluno aluno = (Aluno) alunoList.getItemAtPosition(position);
                final Intent intent = new Intent(activity, FormularioActivity.class);
                intent.putExtra("aluno", aluno);
                activity.startActivity(intent);
            }
        });
    }

    public void injetarMenuEnviaSms(ContextMenu menu, final Aluno aluno) {
        final MenuItem enviaSms = menu.add("Enviar SMS");
        final Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse("sms:" + aluno.getFone()));
        enviaSms.setIntent(intent);
    }

    public void injetarMenuVisitaSite(ContextMenu menu, final Aluno aluno) {
        final MenuItem visitaSite = menu.add("Visitar Site");
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(TextUtil.adjustUrl(aluno.getSite())));
        visitaSite.setIntent(intent);
    }

    public void injetarMenuRemove(ContextMenu menu, final Aluno aluno, final ListView alunoList) {
        final MenuItem remove = menu.add("Remover");
        remove.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final AlunoDao dao = AlunoDao.create(activity);
                dao.excluir(aluno);
                dao.close();

                carregarListaAluno(alunoList);

                Toast.makeText(activity, "Aluno " + aluno.getNome() + " removido com Sucesso!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void injetarMenuVisualizaMapa(ContextMenu menu, final Aluno aluno) {
        MenuItem visualizaMapa = menu.add("Visualizar no mapa");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + aluno.getEndereco()));
        visualizaMapa.setIntent(intent);
    }

    public void injetarMenuLigar(ContextMenu menu, Aluno aluno) {
        MenuItem ligar = menu.add("Ligar");
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + aluno.getFone()));
        ligar.setIntent(intent);
    }
}
