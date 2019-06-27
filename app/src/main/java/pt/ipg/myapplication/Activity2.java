package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.myapplication.Entidades.Carro;
import pt.ipg.myapplication.Entidades.Carros_Sql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class Activity2 extends AppCompatActivity {

    private Button buttonCancelar,buttonSave;
    private BaseDados BD;
    private Carros_Sql Sql_Carros;
    private SQLiteDatabase conn;
    private ListView ListaCarros;

    private TextInputEditText editMarca, editModelo, editLotacao, editTracao, editPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
try {
    BD = new BaseDados(this);
    conn = BD.getWritableDatabase();
    Sql_Carros = new Carros_Sql(conn);

    ListaCarros = findViewById(R.id.ListViewCarros);

    editMarca = (TextInputEditText) findViewById(R.id.TextInputLayoutMarca);
    editModelo = (TextInputEditText) findViewById(R.id.TextInputLayoutModelo);
    editLotacao = (TextInputEditText) findViewById(R.id.TextInputLayoutLotacao);
    editTracao = (TextInputEditText) findViewById(R.id.TextInputLayoutTracao2);
    editPeso = (TextInputEditText) findViewById(R.id.TextInputLayoutPeso3);
    buttonSave =  findViewById(R.id.buttonSaveNovo);

    ListaCarros.setAdapter(Sql_Carros.listar(this));

    buttonCancelar = findViewById(R.id.buttonCancelar);
    buttonCancelar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });


    buttonSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                Carro novocarro = new Carro();
                novocarro.setMarca(editMarca.getText().toString());
                novocarro.setModelo(editModelo.getText().toString());
                novocarro.setLotacao(Float.parseFloat(editLotacao.getText().toString()));
                novocarro.setTracao(editTracao.getText().toString());
                novocarro.setPeso(Float.parseFloat(editPeso.getText().toString()));

                Sql_Carros.inserir(novocarro);

                Toast.makeText(Activity2.this, "Carro adicionado.", Toast.LENGTH_SHORT).show();
                ListaCarros.setAdapter(Sql_Carros.listar(Activity2.this));
            }

    });
}catch (Exception e){
    Toast.makeText(Activity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();

}
    }

}
