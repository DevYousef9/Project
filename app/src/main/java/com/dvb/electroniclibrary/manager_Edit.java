package com.dvb.electroniclibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class manager_Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager__edit);
        ListView sub_selction = (ListView) findViewById(R.id.selction);

        ArrayAdapter<String> A_list = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_checked,getResources().getStringArray(R.array.subject));
        sub_selction.setAdapter(A_list);

    }
}
