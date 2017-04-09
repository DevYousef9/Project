package com.dvb.electroniclibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class downloadSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_subject);
        TextView sub_name =(TextView) findViewById(R.id.Subject_name);
        TextView sub_code =(TextView) findViewById(R.id.subject_cod);
        Button download_bt = (Button) findViewById(R.id.button_download);

    }
}
