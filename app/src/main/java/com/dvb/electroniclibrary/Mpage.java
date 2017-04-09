package com.dvb.electroniclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Mpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpage);
        Spinner s_Msection = (Spinner) findViewById(R.id.M_section);
        EditText e_Mname = (EditText) findViewById(R.id.M_name);
        TextView v_name = (TextView) findViewById(R.id.Sname);
        TextView v_Msection = (TextView) findViewById(R.id.Section);
        TextView v_Mid = (TextView) findViewById(R.id.M_id);
        EditText e_Mid = (EditText) findViewById(R.id.M_ID);
        TextView e_mail = (TextView) findViewById(R.id.M_mail);
        EditText E_mail = (EditText) findViewById(R.id.M_Mail);
        TextView V_collage = (TextView) findViewById(R.id.M_collage);
        Spinner s_collage = (Spinner) findViewById(R.id.M_Collage);
        Button Save = (Button) findViewById(R.id.save);
        Button edit = (Button) findViewById(R.id.Edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Add_Subject.class);
                startActivity(i);
            }
        });
    }
}
