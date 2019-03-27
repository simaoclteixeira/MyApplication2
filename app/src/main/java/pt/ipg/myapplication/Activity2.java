package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Button buttonCancelar = findViewById(R.id.buttonCancelar);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonPesquisar = findViewById(R.id.buttonPesquisar);
        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextFabricante = findViewById(R.id.editTextFabricante);
                String mensagem = editTextFabricante.getText().toString();

                if (mensagem.trim().length()==0) {
                    editTextFabricante.setError(getString(R.string.obrigatorio_escrever));
                }else if (!mensagem.matches("[a-zA-Z ]+")){
                    editTextFabricante.setError(getString(R.string.caracteres_especiais));
                }else{
                    finish();
                    Toast.makeText(Activity2.this,"A pesquisar...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
