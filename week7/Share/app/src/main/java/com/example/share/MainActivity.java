package com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        ib = findViewById(R.id.ib);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,et.getText().toString());
                share.setType("text/plain");
                share.setPackage("com.whatsapp");
                if(share.resolveActivity(getPackageManager())!= null)
                {
                    startActivity(share);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "WhatsApp Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
