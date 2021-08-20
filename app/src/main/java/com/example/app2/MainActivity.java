package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_temp;
    RadioButton rd_btn1;
    RadioButton rd_btn2;
    Button btn_cal;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rd_btn1 = findViewById(R.id.rd_btn1);
        rd_btn2 = findViewById(R.id.rd_btn2);
        btn_cal = findViewById(R.id.btn_cal);
        textView = findViewById(R.id.textView);
    }
    //ch

    @Override
    protected void onResume() {
        super.onResume();
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){ //calculate answer method
        Calculations cal1 = new Calculations();
       String value = et_temp.getText().toString();
       if(TextUtils.isEmpty(value)){
           Toast.makeText(this, "Enter the Temperature", Toast.LENGTH_SHORT).show();//creating a new toast
       }else{
           Float temp = Float.parseFloat(value);
           if(rd_btn1.isChecked()){
               temp = cal1.convertCelsiusToFarenheit(temp);
           }else if(rd_btn2.isChecked()){
               temp = cal1.convertFarenheitToCelsius(temp);
           }else{
               Toast.makeText(this, "Select the Radio button", Toast.LENGTH_SHORT).show();
               temp=0.0f;
           }
           textView.setText(new Float(temp).toString());
       }
    }
}





















