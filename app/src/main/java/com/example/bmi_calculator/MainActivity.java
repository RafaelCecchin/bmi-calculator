package com.example.bmi_calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bBMI;
    private Button bBMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bBMI = (Button) findViewById(R.id.btnBMI);
        this.bBMR = (Button) findViewById(R.id.btnBMR);

        this.bBMI.setOnClickListener(bmiActivity);
        this.bBMR.setOnClickListener(bmrActivity);
    }

    View.OnClickListener bmiActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent bmiView = new Intent(MainActivity.this, BMI.class);
            MainActivity.this.startActivity(bmiView);
        }
    };

    View.OnClickListener bmrActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent bmiView = new Intent(MainActivity.this, BMR.class);
            MainActivity.this.startActivity(bmiView);
        }
    };
}