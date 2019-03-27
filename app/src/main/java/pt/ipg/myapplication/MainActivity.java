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

        Button button1 = findViewById(R.id.buttonCarros);
        Button button2 = findViewById(R.id.buttonMotas);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);



        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.buttonCarros:
            openActivity2();
            break;
        case R.id.buttonMotas:
            openActivity3();
            break;

    }
}



        public void openActivity2() {
            Intent intent = new Intent(this, Activity2.class);
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
