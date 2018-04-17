package com.eyad.concentrationgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_goToActivity2 = (Button) findViewById(R.id.btn_goToActivity2);
        btn_goToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtName = (EditText) findViewById(R.id.txt_name);
                EditText txtAge = (EditText) findViewById(R.id.txt_age);
                Intent myIntent = new Intent(getApplicationContext(), Main2Activity.class);
                Bundle bund = new Bundle();
                bund.putString("name", txtName.getText().toString());
                bund.putString("age", txtAge.getText().toString());
                myIntent.putExtras(bund);
                if(txtName.length() > 0 && txtAge.length() > 0)
                    startActivity(myIntent);
                else
                    Toast.makeText(getApplicationContext(), "Please fill all the fields!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
