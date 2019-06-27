package pt.ipg.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button buttonA = findViewById(R.id.buttonAdicionar2);
        Button buttonG = findViewById(R.id.buttonGerir);

        buttonA.setOnClickListener(this);
        buttonG.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdicionar2:
                openActivity5();
                break;
            case R.id.buttonGerir:

            break;
        }
    }





    public void openActivity5() {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }




}