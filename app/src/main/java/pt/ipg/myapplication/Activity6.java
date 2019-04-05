package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);


        Button buttonCancelar = findViewById(R.id.buttonCancel2);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonPesquisar = findViewById(R.id.buttonDelete);
        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextFabricante = findViewById(R.id.TextInputLayoutNomeDel);
                String mensagem = editTextFabricante.getText().toString();

                if (mensagem.trim().length()==0) {
                    editTextFabricante.setError(getString(R.string.obrigatorio_escrever));
                }else if (!mensagem.matches("[a-zA-Z ]+")){
                    editTextFabricante.setError(getString(R.string.caracteres_especiais));
                }else{
                    finish();
                    Toast.makeText(Activity6.this,"Carro eliminado.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
