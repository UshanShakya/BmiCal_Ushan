package com.example.bmi_ushan;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight, etBmi;
    Button btnCompute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etBmi = findViewById(R.id.etBmi);
        btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height, weight, bmi;
                height= (Double.parseDouble(etHeight.getText().toString()))/100;

                weight = Double.parseDouble(etWeight.getText().toString());

                bmi = weight/(height*height);
                bmi = Math.round(bmi*100)/100.0D;

                etBmi.setText(Double.toString(bmi));

                if (bmi<18.5){
                    Toast.makeText(MainActivity.this, "Underweight",Toast.LENGTH_LONG).show();
                }
                else if(bmi>18.5 && bmi<24.9){
                    Toast.makeText(MainActivity.this, "Normal Weight",Toast.LENGTH_LONG).show();

                }
                else if(bmi>25 && bmi<29.9){
                    Toast.makeText(MainActivity.this, "Overweight",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Obesity",Toast.LENGTH_LONG).show();

                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCompute.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);


            }
        });
    }
}
