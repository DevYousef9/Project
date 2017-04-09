package com.dvb.electroniclibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class subject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        TextView subject_cod = (TextView) this.findViewById(R.id.subject_cod);
        TextView t = new TextView(getApplicationContext());
    }
}
