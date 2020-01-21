package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Spinner spn;
    Button b;
    TextView result;
    String[] curr = {"Dollar","Pound","Yen","Euro","Ringgit","Kuwaiti Dinar","Irani Rial"};
    ArrayAdapter ar;
    int i;
    Double conv;
    Double[] rates = {71.23, 92.65, 0.65, 78.98, 17.47, 234.38, 0.0020};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        spn = findViewById(R.id.spn);
        b = findViewById(R.id.b);
        result = findViewById(R.id.tv);

        ar = new ArrayAdapter(MainActivity.this,android.R.layout.simple_dropdown_item_1line,curr);  //ctrl + click
        spn.setAdapter(ar);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //ctrl + space
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conv = Double.parseDouble( et.getText().toString())/rates[i];
                result.setText(String.format("%.2f",conv));   //string.format() for 2 digit precision
            }
        });


    }
}
