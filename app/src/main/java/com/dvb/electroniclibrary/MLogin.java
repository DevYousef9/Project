package com.dvb.electroniclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlogin);
         EditText names = (EditText) findViewById(R.id.textn);
         EditText password = (EditText) findViewById(R.id.textp);
        Button ok = (Button) findViewById(R.id.Ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getApplicationContext(),Mpage.class);
                startActivity(i);



            }
        });
    }
}
