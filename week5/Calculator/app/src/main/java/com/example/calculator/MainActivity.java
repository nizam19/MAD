package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button clicked;
    Button[] b;
    EditText et;
    char op;
    String num1,num2;
    long res;
    int[] id = {R.id.b0,R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.add,R.id.sub,R.id.mul,R.id.div,R.id.eq,R.id.clear};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       b = new Button[16];
       for(int i=0;i<16;i++)
       {
            b[i] = findViewById(id[i]);
            b[i].setOnClickListener(this);
       }
       et = findViewById(R.id.et);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        clicked = findViewById(id);
        switch (id){
            case R.id.clear:
                et.setText("");
                break;
            case R.id.add:
                op = '+';
                num1 = et.getText().toString();
                et.setText("");
                break;
            case R.id.sub:
                op = '-';
                num1 = et.getText().toString();
                et.setText("");
                break;
            case R.id.mul:
                op = '*';
                num1 = et.getText().toString();
                et.setText("");
                break;
            case R.id.div:
                op = '/';
                num1 = et.getText().toString();
                et.setText("");
                break;
            case R.id.eq:
                num2 = et.getText().toString();
                switch(op){
                    case '+':
                        res=Integer.parseInt(num1)+Integer.parseInt(num2);
                        break;
                    case '-':
                        res=Integer.parseInt(num1)-Integer.parseInt(num2);
                        break;
                    case '*':
                        res=Integer.parseInt(num1)*Integer.parseInt(num2);
                        break;
                    case '/':
                        if(num2.equals("0"))
                            res=0;
                        else
                            res=Integer.parseInt(num1)/Integer.parseInt(num2);
                        break;
                }
                et.setText(res+"");
                break;
            default:
                et.setText(et.getText()+clicked.getText().toString());
        }
    }
}