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

public class BMR extends AppCompatActivity {
    private EditText eAge;
    private EditText eHeight;
    private EditText eWeight;
    private RadioGroup eGender;
    private RadioGroup ePal;
    private Button bCalc;

    private Float height, weight;
    private Integer age;
    private String gender;
    private String pal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmr);

        this.eHeight = (EditText) findViewById(R.id.editHeight);
        this.eWeight = (EditText) findViewById(R.id.editWeight);
        this.eAge = (EditText) findViewById(R.id.editAge);
        this.eGender = (RadioGroup) findViewById(R.id.editGender);
        this.ePal = (RadioGroup) findViewById(R.id.editPal);
        this.bCalc = (Button) findViewById(R.id.btnCalc);

        this.bCalc.setOnClickListener(dados);
    }

    View.OnClickListener dados = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateAllData()) {
                Double bmr = getBMRResult();
                Toast.makeText(getBaseContext(), (String) getString(R.string.bmr)+": "+bmr.toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), (String) getString(R.string.invalid_data), Toast.LENGTH_SHORT).show();
            }
        }
    };

    public Double getBMRResult() {

        Double naf = 0.0, total_kcal = 0.0;

        String male = (String) getString(R.string.gender_male), female = (String) getString(R.string.gender_female);
        String light = (String) getString(R.string.light), moderate = (String) getString(R.string.moderate), intense = (String) getString(R.string.intense);

        if (this.getGender() == male) {
            if (this.getPal() == light) {
                naf = 1.56;
            }
            if (this.getPal() == moderate) {
                naf = 1.64;
            }
            if (this.getPal() == intense) {
                naf = 1.82;
            }

            total_kcal = (66.5 + (14*getWeight()) + (5*getHeight()) + (6.7*getAge())) * naf;
        }

        if (this.getGender() == female) {
            if (this.getPal() == light) {
                naf = 1.58;
            }
            if (this.getPal() == moderate) {
                naf = 1.78;
            }
            if (this.getPal() == intense) {
                naf = 2.10;
            }

            total_kcal = (65.5 + (9.6*getWeight()) + (1.8*getHeight()) + (4.7*getAge())) * naf;
        }

        return total_kcal;
    }

    public boolean validateAllData() {
        Boolean valid = true;

        if (!this.validateHeight()) {
            valid = false;
        }

        if (!this.validateWeight()) {
            valid = false;
        }

        if (!this.validateAge()) {
            valid = false;
        }

        if (!this.validateGender()) {
            valid = false;
        }

        if (!this.validatePal()) {
            valid = false;
        }

        return valid;
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
    public boolean validatePal() {
        Integer selectedPalID;
        RadioButton selectedPalOption;

        try {
            selectedPalID = ePal.getCheckedRadioButtonId();
            selectedPalOption = (RadioButton) findViewById(selectedPalID);
            this.setPal( selectedPalOption.getText().toString() );

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
    public String getPal() {
        return pal;
    }
    public void setPal(String pal) {
        this.pal = pal;
    }
}