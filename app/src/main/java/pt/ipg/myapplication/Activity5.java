package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity5 extends AppCompatActivity {

    private EditText TextInputEditOld;
    private EditText TextInputEditNew;
    private Button botaoguardar;
    private Button botaocancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);


        TextInputEditOld = (EditText) findViewById(R.id.TextInputEditOld);
        TextInputEditNew = (EditText) findViewById(R.id.TextInputEditNew);
        botaocancelar = (Button) findViewById(R.id.buttonCancel1);
        botaoguardar = (Button) findViewById(R.id.buttonSave1);

        botaoguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = TextInputEditOld.getText().toString();
                String mensagem2 = TextInputEditNew.getText().toString();
                if (mensagem.trim().length() == 0){
                    TextInputEditOld.setError(getString(R.string.obrigatorio_escrever));
                }else if (mensagem2.trim().length() == 0){
                    TextInputEditNew.setError(getString(R.string.obrigatorio_escrever));
                }else {
                    finish();
                    Toast.makeText(Activity5.this, "Edição concluida.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaocancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
