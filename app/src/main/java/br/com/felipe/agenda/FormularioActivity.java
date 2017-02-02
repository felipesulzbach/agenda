package br.com.felipe.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.felipe.agenda.dao.AlunoDao;
import br.com.felipe.agenda.model.Aluno;
import br.com.felipe.agenda.util.AndroidUtil;

public class FormularioActivity extends AppCompatActivity {

    private static final int CAMERA = 1;
    private FormularioHelper helper;
    private String caminhoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.helper = FormularioHelper.create(this);
        this.helper.carregarAluno(this);

        Button button = findViewById(R.id.formulario_btn_foto);
        button.setOnClickListener(View.OnClickListener() {
            @Override
            public void onClick (View v){
                final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                final File file = new File(caminhoFoto);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent, CAMERA);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                this.helper.salvar();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protect void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA) {
            final ImageView foto = (ImageView) findViewById(R.id.formulario_foto);
            final Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            final Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            foto.setImageBitmap(bitmapReduzido);
            foto.setScaleType(ImageView.ScaleType.FIT_XY);
            foto.setTag(cminhoFoto);
        }
    }
}
