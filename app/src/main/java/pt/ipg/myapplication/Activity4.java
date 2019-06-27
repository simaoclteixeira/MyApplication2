package pt.ipg.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.myapplication.Entidades.Carro;
import pt.ipg.myapplication.Entidades.Mota;
import pt.ipg.myapplication.Entidades.Motas_Sql;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;


public class Activity4 extends AppCompatActivity {
    private BaseDados BD;
    private Motas_Sql Sql_Motas;
    private SQLiteDatabase conn;
    private ListView ListaMotas;
    private Mota mota_sel;
    private TextInputEditText editMarca, editModelo, editCilindrada, editPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        try {
            BD = new BaseDados(this);
            conn = BD.getWritableDatabase();
            Sql_Motas = new Motas_Sql(conn);
            mota_sel=new Mota();

            ListaMotas = findViewById(R.id.ListViewCarros2);

            editMarca = (TextInputEditText) findViewById(R.id.TextInputLayoutMarca4);
            editModelo = (TextInputEditText) findViewById(R.id.TextInputLayoutModelo4);
            editCilindrada = (TextInputEditText) findViewById(R.id.TextInputLayoutCilindrada4);
            editPeso = (TextInputEditText) findViewById(R.id.TextInputLayoutPeso4);

            ListaMotas.setAdapter(Sql_Motas.listar(this));

            ListaMotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mota_sel = (Mota) ListaMotas.getItemAtPosition(position);

                    editMarca.setText(mota_sel.getMarca());
                    editModelo.setText(mota_sel.getModelo());
                    editCilindrada.setText(String.valueOf(mota_sel.getCilindrada()));
                    editPeso.setText(String.valueOf(mota_sel.getPeso()));
                }
            });






            Button buttonCancelar = findViewById(R.id.buttonCancelar2);
            buttonCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if ((mota_sel.getId_Motas() <= 0)) {
                        Toast.makeText(Activity4.this, "Erro", Toast.LENGTH_LONG).show();
                    } else {
                        AlertDialog.Builder msg = new AlertDialog.Builder(Activity4.this);
                        msg.setMessage("Deseja Eliminar?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        try {
                                            Sql_Motas.eliminar(mota_sel.getId_Motas());
                                            Toast.makeText(Activity4.this, "Eliminado", Toast.LENGTH_LONG).show();
                                            ListaMotas.setAdapter(Sql_Motas.listar(Activity4.this));

                                            mota_sel = null;
                                            editMarca.setText("");
                                            editModelo.setText("");
                                            editCilindrada.setText("");
                                            editPeso.setText("");

                                        }catch (Exception e) {
                                            Toast.makeText(Activity4.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                        }
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();

                    }


                        ListaMotas.setAdapter(Sql_Motas.listar(Activity4.this));
                    //  finish();
                }

            });

            Button buttonPesquisar = findViewById(R.id.buttonSaveNovo2);
            buttonPesquisar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mota_sel==null) {
                        Toast.makeText(Activity4.this, "Erro", Toast.LENGTH_LONG);
                    }
                    else {
                        mota_sel.setMarca(editMarca.getText().toString());
                        mota_sel.setModelo(editModelo.getText().toString());
                        mota_sel.setCilindrada(Float.parseFloat(editCilindrada.getText().toString()));
                        mota_sel.setPeso(Float.parseFloat(editPeso.getText().toString()));

                        Sql_Motas.editar(mota_sel);
                        Toast.makeText(Activity4.this, "Editado", Toast.LENGTH_LONG);
                        ListaMotas.setAdapter(Sql_Motas.listar(Activity4.this));
                    }
                }
            });


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }
}
