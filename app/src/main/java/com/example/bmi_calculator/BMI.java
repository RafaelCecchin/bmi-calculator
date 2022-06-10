package com.example.bmi_calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class BMI extends AppCompatActivity {
    private EditText eAge;
    private EditText eHeight;
    private EditText eWeight;
    private Button bCalc;

    private Float height, weight;
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        this.eHeight = (EditText) findViewById(R.id.editHeight);
        this.eWeight = (EditText) findViewById(R.id.editWeight);
        this.eAge = (EditText) findViewById(R.id.editAge);
        this.bCalc = (Button) findViewById(R.id.btnCalc);

        this.bCalc.setOnClickListener(dados);
    }

    View.OnClickListener dados = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateAllData()) {
                String bmi = getBMIResult();
                Toast.makeText(getBaseContext(), (String) getString(R.string.bmi)+": "+bmi, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), (String) getString(R.string.invalid_data), Toast.LENGTH_SHORT).show();
            }
        }
    };

    public String getBMIResult() {

        String result;
        Float bmi = getWeight() / ( getHeight() * getHeight() );



        if (bmi >= 18.5 && bmi < 25) {
            result = (String) getString(R.string.normal_weight);
        } else if (bmi >= 25 && bmi < 30) {
            result = (String) getString(R.string.overweight);
        } else if (bmi >= 30 && bmi < 35) {
            result = (String) getString(R.string.grade_1_obesity);
        } else if (bmi >= 35 && bmi < 40) {
            result = (String) getString(R.string.grade_2_obesity);
        } else {
            result = (String) getString(R.string.values_out_of_reality);
        }

        return result;
    }

    public boolean validateAllData() {
        return this.validateHeight() && this.validateWeight() && this.validateAge();
    }
    public boolean validateHeight() {
        try {
            this.setHeight( Float.parseFloat(eHeight.getText().toString()) );
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public boolean validateWeight() {
        try {
            this.setWeight( Float.parseFloat(eWeight.getText().toString()) );
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public boolean validateAge() {
        try {
            this.setAge(Integer.parseInt(eAge.getText().toString()));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Float getHeight() {
        return height;
    }
    public void setHeight(Float height) {
        this.height = height;
    }
    public Float getWeight() {
        return weight;
    }
    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}