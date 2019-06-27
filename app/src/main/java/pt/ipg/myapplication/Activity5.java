package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.myapplication.Entidades.Mota;
import pt.ipg.myapplication.Entidades.Motas_Sql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class Activity5 extends AppCompatActivity {

    private Button buttonCancelar,buttonGuardar;
    private BaseDados BD;
    private Motas_Sql Sql_Motas;
    private SQLiteDatabase conn;
    private ListView ListaMotas;

    private TextInputEditText editMarca, editModelo, editCilindrada, editPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        try {
            BD = new BaseDados(this);
            conn = BD.getWritableDatabase();
            Sql_Motas = new Motas_Sql(conn);

            ListaMotas = findViewById(R.id.ListViewMotas2);

            editMarca = (TextInputEditText) findViewById(R.id.TextInputLayoutMarca3);
            editModelo = (TextInputEditText) findViewById(R.id.TextInputLayoutModelo3);
            editCilindrada = (TextInputEditText) findViewById(R.id.TextInputLayoutCilindrada);
            editPeso = (TextInputEditText) findViewById(R.id.TextInputLayoutPeso3);
            buttonGuardar =  findViewById(R.id.buttonSave3);

            ListaMotas.setAdapter(Sql_Motas.listar(this));

            buttonCancelar = findViewById(R.id.buttonCancelar3);
            buttonCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


            buttonGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Mota novamota = new Mota();
                    novamota.setMarca(editMarca.getText().toString());
                    novamota.setModelo(editModelo.getText().toString());
                    novamota.setCilindrada(Float.parseFloat(editCilindrada.getText().toString()));
                    novamota.setPeso(Float.parseFloat(editPeso.getText().toString()));


                    Sql_Motas.inserir(novamota);

                    Toast.makeText(Activity5.this, "Mota adicionada.", Toast.LENGTH_SHORT).show();
                    ListaMotas.setAdapter(Sql_Motas.listar(Activity5.this));
                }
                /* }*/
            });
        }catch (Exception e){
            Toast.makeText(Activity5.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

}