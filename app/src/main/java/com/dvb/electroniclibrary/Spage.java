package com.dvb.electroniclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Spage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spage);
        Spinner s_section = (Spinner) findViewById(R.id.section);
        EditText e_name = (EditText) findViewById(R.id.sname);
        TextView v_name = (TextView) findViewById(R.id.Sname);
        TextView v_section = (TextView) findViewById(R.id.Section);
        TextView v_id = (TextView) findViewById(R.id.id);
        EditText e_id = (EditText) findViewById(R.id.ID);
        TextView email = (TextView) findViewById(R.id.mail);
        EditText Email = (EditText) findViewById(R.id.Mail);
        TextView level = (TextView) findViewById(R.id.levels);
        Spinner s_levels = (Spinner) findViewById(R.id.Levels);
        Button Search = (Button) findViewById(R.id.search);
        Button edit = (Button) findViewById(R.id.Edit);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),subject.class);
                startActivity(i);
            }
        });
    }
}
