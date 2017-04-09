package com.dvb.electroniclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Selction extends AppCompatActivity {

Spinner s_section,s_collage,s_levels;
    Button s_okey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selction);
        TextView t_visitor = (TextView) findViewById(R.id.textv);
         s_collage = (Spinner) findViewById(R.id.collage);
         s_section = (Spinner) findViewById(R.id.section);
         s_levels = (Spinner) findViewById(R.id.levels);
         s_okey = (Button) findViewById(R.id.search);


        // TO DECLARE THE INPUT INSIDE THE SPINNER (DROP DOWN LIST)
        ArrayAdapter<String> A_collage = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.collage));
        A_collage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_collage.setAdapter(A_collage);
        s_collage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // FOR CHECKING THE (DROP DOWN LIST) VALIDATION TO OPEN THE NEXT SPINNER
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (s_collage.getSelectedItem().equals("علوم و هندسة الحاسب الآلي")){
                    ArrayAdapter A_section = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.collage_Sience,android.R.layout.simple_list_item_1);
                    s_section.setAdapter(A_section);
                } else if (s_collage.getSelectedItem().equals("الهندسة")){
                    ArrayAdapter A_section1 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.engennering,android.R.layout.simple_list_item_1);
                    s_section.setAdapter(A_section1);
                } else if (s_collage.getSelectedItem().equals("إدارة الأعمال")){
                    ArrayAdapter A_section0 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.mangment,android.R.layout.simple_list_item_1);
                    s_section.setAdapter(A_section0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter<String> A_level = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.levels));
        A_level.setDropDownViewResource(android.R.layout.simple_list_item_1);
        s_levels.setAdapter(A_level);
        // THE ACTION AFTER CLICKING THE BUTTON
        s_okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s_collage.isClickable() && s_levels.isClickable() && s_section.isClickable()){
                    Intent i = new Intent(getApplicationContext(),Spage.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"PLEASE CHOOSE",Toast.LENGTH_LONG).show();
                }
            }
        });
       s_okey.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),subject.class);
               startActivity(i);
           }
       });

    }
}
