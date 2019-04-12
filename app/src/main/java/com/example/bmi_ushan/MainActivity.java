package com.example.bmi_ushan;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    TextView tvBmis;
    Button btnCompute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvBmis = findViewById(R.id.tvBmis);
        btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height, weight, bmi;

                if(TextUtils.isEmpty(etHeight.getText().toString())){
                    etHeight.setError("Please enter Height");
                    return;
                }
                if(TextUtils.isEmpty(etHeight.getText().toString())){
                    etHeight.setError("Please enter Weight");
                    return;
                }
                height= Double.parseDouble(etHeight.getText().toString());

                weight = Double.parseDouble(etWeight.getText().toString());

               BmiCalculator bmiCalculator= new BmiCalculator(height, weight);
               bmi= bmiCalculator.Bmi();
               tvBmis.setText(Double.toString(bmi));

               Toast.makeText(MainActivity.this, bmiCalculator.Category(), Toast.LENGTH_LONG).show();


                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCompute.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);


            }
        });
    }
}
