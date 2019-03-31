package com.example.squareequationchart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText et1, et2, et3;
    TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3= findViewById(R.id.editText3);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
    }


    public void calculate(View view){
        float a = Float.parseFloat(et1.getText().toString());
        float b = Float.parseFloat(et2.getText().toString());
        float c = Float.parseFloat(et3.getText().toString());


        float delta = b*b - 4*a*c;
        tv1.setText("Delta = " + String.valueOf(delta));

        float p = (-b)/(2*a);
        float q = (-delta)/(4*a);
        tv2.setText("p = " + String.valueOf(p));
        tv3.setText("q = " + String.valueOf(q));

        double x1 = (-b-sqrt(delta))/(2*a);
        double x2 = (-b+sqrt(delta))/(2*a);
        tv4.setText("x1 = " + String.valueOf(x1));
        tv5.setText("x2 = " + String.valueOf(x2));
    }

    public void drawGraph(View view){

        if(view.getId() == R.id.button2)
        {
            Intent intent = new Intent(this, Graph.class);
            float a = Float.parseFloat(et1.getText().toString());
            float b = Float.parseFloat(et2.getText().toString());
            float c = Float.parseFloat(et3.getText().toString());
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            startActivity(intent);
        }

    }
}
