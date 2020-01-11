package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,num,email,pwd,cpwd;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        name = findViewById(R.id.et1);
        num = findViewById(R.id.et2);
        email = findViewById(R.id.et3);
        pwd= findViewById(R.id.et4);
        cpwd= findViewById(R.id.et5);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()){
                    name.setError("Empty");
                    name.requestFocus();
                } else if(num.getText().toString().isEmpty()){
                    num.setError("Empty");
                    num.requestFocus();
                } else if(email.getText().toString().isEmpty()){
                    email.setError("Empty");
                    email.requestFocus();
                } else if(pwd.getText().toString().isEmpty()){
                    pwd.setError("Empty");
                    pwd.requestFocus();
                } else if(cpwd.getText().toString().isEmpty()){
                    cpwd.setError("Empty");
                    cpwd.requestFocus();
                } else{
                    if(pwd.getText().toString().equals(cpwd.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_LONG).show();
                    } else{
                        cpwd.setError("Passwords don't match");
                        cpwd.requestFocus();
                    }
                }
            }
        });

    }
}
