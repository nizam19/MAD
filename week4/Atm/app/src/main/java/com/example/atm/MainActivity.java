package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit,withdraw,deposit,balance,exit;
    EditText pin,bal;
    TextView show;
    long amt = 100000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pin = findViewById(R.id.pin);
        submit = findViewById(R.id.submit);
        bal = findViewById(R.id.bal);
        withdraw = findViewById(R.id.withdraw);
        deposit = findViewById(R.id.deposit);
        balance = findViewById(R.id.balance);
        exit = findViewById(R.id.exit);
        show = findViewById(R.id.show);

        bal.setVisibility(View.INVISIBLE);
        withdraw.setVisibility(View.INVISIBLE);
        deposit.setVisibility(View.INVISIBLE);
        balance.setVisibility(View.INVISIBLE);
        exit.setVisibility(View.INVISIBLE);
        show.setVisibility(View.INVISIBLE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pin.getText().toString().isEmpty()){
                    pin.setError("Empty");
                    pin.requestFocus();
                    return;
                }
                if(pin.getText().toString().equals("1234")){

                    pin.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);

                    bal.setVisibility(View.VISIBLE);
                    withdraw.setVisibility(View.VISIBLE);
                    deposit.setVisibility(View.VISIBLE);
                    balance.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);

                    withdraw.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            show.setVisibility(View.INVISIBLE);

                            if(bal.getText().toString().isEmpty()){
                                bal.setError("Empty");
                                bal.requestFocus();
                                return;
                            }
                            if(Long.parseLong(bal.getText().toString())%100==0){
                                if(Long.parseLong(bal.getText().toString())<=amt){
                                    amt-=Long.parseLong(bal.getText().toString());
                                    show.setText("Balance = "+amt);
                                    Toast.makeText(MainActivity.this,"Withdrawn"+bal.getText().toString(),Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(MainActivity.this,"Insufficient baalance",Toast.LENGTH_SHORT).show();
                                }
                            } else{
                                Toast.makeText(MainActivity.this,"Enter multiples of 100 only",Toast.LENGTH_SHORT).show();
                            }
                            bal.setText("");
                        }
                    });

                    deposit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            show.setVisibility(View.INVISIBLE);
                            if(bal.getText().toString().isEmpty()){
                                bal.setError("Empty");
                                bal.requestFocus();
                                return;
                            }
                            amt+=Long.parseLong(bal.getText().toString());
                            show.setText("Balance = "+amt);
                            Toast.makeText(MainActivity.this,"Deposited"+Long.parseLong(bal.getText().toString()),Toast.LENGTH_SHORT).show();
                            bal.setText("");
                        }
                    });

                    balance.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            show.setVisibility(View.VISIBLE);
                            show.setText("Balance = "+amt);
                        }
                    });

                    exit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            pin.setVisibility(View.VISIBLE);
                            submit.setVisibility(View.VISIBLE);

                            show.setVisibility(View.INVISIBLE);
                            bal.setVisibility(View.INVISIBLE);
                            withdraw.setVisibility(View.INVISIBLE);
                            deposit.setVisibility(View.INVISIBLE);
                            balance.setVisibility(View.INVISIBLE);
                            exit.setVisibility(View.INVISIBLE);

                        }
                    });

                } else{
                    Toast.makeText(MainActivity.this,"Invalid PIN",Toast.LENGTH_SHORT).show();
                }
                pin.setText(null);
            }
        });

    }
}
