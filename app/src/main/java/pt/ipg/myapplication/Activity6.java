package pt.ipg.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.myapplication.Entidades.Carro;
import pt.ipg.myapplication.Entidades.Carros_Sql;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;


public class Activity6 extends AppCompatActivity {
    private BaseDados BD;
    private Carros_Sql Sql_Carros;
    private SQLiteDatabase conn;
    private ListView ListaCarros;
    private Carro carro_sel;
    private TextInputEditText editMarca, editModelo, editLotacao, editTracao, editPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        try {
            BD = new BaseDados(this);
            conn = BD.getWritableDatabase();
            Sql_Carros = new Carros_Sql(conn);

            ListaCarros = findViewById(R.id.ListViewCarros2);

            editMarca = (TextInputEditText) findViewById(R.id.TextInputLayoutMarca2);
            editModelo = (TextInputEditText) findViewById(R.id.TextInputLayoutModelo2);
            editLotacao = (TextInputEditText) findViewById(R.id.TextInputLayoutLotacao2);
            editTracao = (TextInputEditText) findViewById(R.id.TextInputLayoutTracao2);
            editPeso = (TextInputEditText) findViewById(R.id.TextInputLayoutPeso2);

            ListaCarros.setAdapter(Sql_Carros.listar(this));

            ListaCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    carro_sel = (Carro)ListaCarros.getItemAtPosition(position);

                    editMarca.setText(carro_sel.getMarca());
                    editModelo.setText(carro_sel.getModelo());
                    editLotacao.setText(String.valueOf(carro_sel.getLotacao()));
                    editTracao.setText(carro_sel.getTracao());
                    editPeso.setText(String.valueOf(carro_sel.getPeso()));
                }
            });






            Button buttonCancelar = findViewById(R.id.buttonCancelar2);
            buttonCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (carro_sel==null) {
                        Toast.makeText(Activity6.this, "Erro", Toast.LENGTH_LONG);
                    }
                    else {
                        AlertDialog.Builder msg = new AlertDialog.Builder(Activity6.this);
                        msg.setMessage("Deseja Eliminar?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Sql_Carros.eliminar(carro_sel.getId_Carros());
                                        Toast.makeText(Activity6.this, "Eliminado", Toast.LENGTH_LONG);
                                        ListaCarros.setAdapter(Sql_Carros.listar(Activity6.this));
                                        carro_sel=null;
                                        editMarca.setText("");
                                        editModelo.setText("");
                                        editLotacao.setText("");
                                        editTracao.setText("");
                                        editPeso.setText("");

                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();

                    }



                    ListaCarros.setAdapter(Sql_Carros.listar(Activity6.this));
                  //  finish();
                }
            });

            Button buttonPesquisar = findViewById(R.id.buttonSaveNovo2);
            buttonPesquisar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (carro_sel==null) {
                        Toast.makeText(Activity6.this, "Erro", Toast.LENGTH_LONG);
                    }
                    else {
                        carro_sel.setMarca(editMarca.getText().toString());
                        carro_sel.setModelo(editModelo.getText().toString());
                        carro_sel.setLotacao(Float.parseFloat(editLotacao.getText().toString()));
                        carro_sel.setTracao(editTracao.getText().toString());
                        carro_sel.setPeso(Float.parseFloat(editPeso.getText().toString()));

                        Sql_Carros.editar(carro_sel);
                        Toast.makeText(Activity6.this, "Editado", Toast.LENGTH_LONG);
                        ListaCarros.setAdapter(Sql_Carros.listar(Activity6.this));
                    }
                }
            });


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }
}
