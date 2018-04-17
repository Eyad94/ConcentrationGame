package com.eyad.concentrationgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private static final int[] idArray = {R.id.btn_Easy, R.id.btn_Medium, R.id.btn_Hard};
    private Button[] buttonArray = new Button[idArray.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView lblNameAndAge = (TextView) findViewById(R.id.lbl_nameAndAge);
        Bundle bund = getIntent().getExtras();
        final String name = bund.getString("name");
        String age = bund.getString("age");
        lblNameAndAge.setText("Hello " + name + " ," + age + " years old");

        for(int i=0; i<idArray.length; i++){
            buttonArray[i] = (Button) findViewById(idArray[i]);
            buttonArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(getApplicationContext(), Main3Activity.class);
                    Bundle bund = new Bundle();
                    bund.putInt("id", view.getId());
                    bund.putString("name", name);
                    myIntent.putExtras(bund);
                    startActivity(myIntent);
                }
            });
        }
    }
}
