package pt.ipg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonCarros;
    private Button buttonMotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button6carros);
        Button button2 = findViewById(R.id.button5motas);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);



        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.button6carros:
            openMenuCarros();
            break;
        case R.id.button5motas:
            openActivity3();
            break;

    }
}



        public void openMenuCarros() {
            Intent intent = new Intent(this, MenuCarros.class);
            startActivity(intent);
        }

        public void openActivity3() {
            Intent intent = new Intent(this, Activity3.class);
            startActivity(intent);
        }

    public void openActivity4() {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

}
