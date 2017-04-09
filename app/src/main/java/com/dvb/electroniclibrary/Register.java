package com.dvb.electroniclibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextView T_name , T_email , T_pass , T_collage , T_section , T_id , T_level;
    EditText d_name , d_email , e_pass , e_id ;
    Spinner S_collage , S_section , S_level ;
    Button B_Ok;
String lname,lemail,pass,id,level;
    S_DataSource s_data;
    dataconection MYDB;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        T_name = (TextView) findViewById(R.id.T_name);
        T_email = (TextView) findViewById(R.id.T_email);
       T_pass = (TextView) findViewById(R.id.T_password);
        T_collage = (TextView) findViewById(R.id.T_collage);
        T_section = (TextView) findViewById(R.id.T_section);
       T_id = (TextView) findViewById(R.id.T_id);
        T_level = (TextView) findViewById(R.id.T_level);
        d_name = (EditText) findViewById(R.id.E_name);
        lname = d_name.getText().toString();
        d_email = (EditText) findViewById(R.id.E_email);
        lemail = d_email.getText().toString();
        e_pass = (EditText) findViewById(R.id.E_pass);
        pass = e_pass.getText().toString();
        e_id = (EditText) findViewById(R.id.E_Id);
        id = e_id.getText().toString();
        S_collage = (Spinner) findViewById(R.id.S_collage);
        S_section = (Spinner) findViewById(R.id.S_Section);
        S_level = (Spinner) findViewById(R.id.S_Level);
      //  level = S_level.getSelectedItem().toString();
        B_Ok = (Button) findViewById(R.id.B_save);
         MYDB = new dataconection (getApplicationContext()) ;
        s_data = new S_DataSource(getApplicationContext());


        B_Ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    try {
                        s_data.open();

                        MYDB.Add_student(student);
                        s_data.C_Student( lname.toString(), id, S_collage.getSelectedItem().toString(),
                                S_section.getSelectedItem().toString(), pass, lemail, S_level.getSelectedItem().toString());
                        s_data.close();
                        Toast.makeText(getApplicationContext(), "okey", Toast.LENGTH_LONG).show();

                    } catch(Exception e){
                        Log.d("ronge",e.getMessage());
                    }

            }
        });

       ArrayAdapter<String> A_level = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.levels));
        A_level.setDropDownViewResource(android.R.layout.simple_list_item_1);
        S_level.setAdapter(A_level);
        ArrayAdapter<String> A_collage = new ArrayAdapter<String>(getApplicationContext(),
              android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.collage));
        A_collage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        S_collage.setAdapter(A_collage);
        S_collage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            // FOR CHECKING THE (DROP DOWN LIST) VALIDATION TO OPEN THE NEXT SPINNER
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (S_collage.getSelectedItem().equals("علوم و هندسة الحاسب الآلي")){
                    ArrayAdapter A_section = ArrayAdapter.createFromResource(getApplicationContext(),
                           R.array.collage_Sience,android.R.layout.simple_list_item_1);
                   S_section.setAdapter(A_section);
                } else if (S_collage.getSelectedItem().equals("الهندسة")){
                    ArrayAdapter A_section1 = ArrayAdapter.createFromResource(getApplicationContext(),
                           R.array.engennering,android.R.layout.simple_list_item_1);
                    S_section.setAdapter(A_section1);
                } else if (S_collage.getSelectedItem().equals("إدارة الأعمال")){
                   ArrayAdapter A_section0 = ArrayAdapter.createFromResource(getApplicationContext(),
                           R.array.mangment,android.R.layout.simple_list_item_1);
                    S_section.setAdapter(A_section0);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
