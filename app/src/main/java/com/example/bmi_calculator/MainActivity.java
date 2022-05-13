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




public class MainActivity extends AppCompatActivity {
    private EditText eAge;
    private EditText eHeight;
    private EditText eWeight;
    private RadioGroup eGender;
    private Button bCalc;

    private Float height, weight;
    private Integer age;
    private String gender, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.eHeight = (EditText) findViewById(R.id.editHeight);
        this.eWeight = (EditText) findViewById(R.id.editWeight);
        this.eAge = (EditText) findViewById(R.id.editAge);
        this.eGender = (RadioGroup) findViewById(R.id.editGender);
        this.bCalc = (Button) findViewById(R.id.btnCalc);

        this.bCalc.setOnClickListener(dados);
    }

    View.OnClickListener dados = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateAllData()) {

                Float bmi = getWeight() / ( getHeight() * getHeight() );

                if (bmi >= 18.5 && bmi < 25) {
                    setResult("Normal weight");
                } else if (bmi >= 25 && bmi < 30) {
                    setResult("Overweight");
                } else if (bmi >= 30 && bmi < 35) {
                    setResult("Grade 1 obesity");
                } else if (bmi >= 35 && bmi < 40) {
                    setResult("Grade 2 obesity");
                } else {
                    setResult("Values out of reality");
                }

                Toast.makeText(getBaseContext(), "BMI: "+getResult(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), "Invalid data", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public boolean validateAllData() {
        return this.validateHeight() && validateWeight() && validateAge() && validateGender();
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
            this.setAge( Integer.parseInt(eAge.getText().toString()) );
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public boolean validateGender() {
        Integer selectedGenderID;
        RadioButton selectedGenderOption;

        try {
            selectedGenderID = eGender.getCheckedRadioButtonId();
            selectedGenderOption = (RadioButton) findViewById(selectedGenderID);
            this.setGender( selectedGenderOption.getText().toString() );

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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}