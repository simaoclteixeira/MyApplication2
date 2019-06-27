package pt.ipg.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCarros extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carros);

        Button button4 = findViewById(R.id.buttonAdicionar2);
        Button button6 = findViewById(R.id.buttonDelete);

        button4.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdicionar2:
                openActivity2();
                break;
            case R.id.buttonDelete:
                openActivity6();
                break;
        }
    }



    private void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    private void openActivity6() {
        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);
    }


}