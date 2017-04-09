package com.dvb.electroniclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioG);
        RadioButton members = (RadioButton) findViewById(R.id.rmember);
        RadioButton students = (RadioButton) findViewById(R.id.rstudent);
        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SLogin.class);
                startActivity(i);
            }
        });
        members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MLogin.class);
                startActivity(i);
            }
        });



    }
}
