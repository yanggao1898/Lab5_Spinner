package com.example.lab5_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_Calculate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCalcBtnClick(v);
            }
        });

        Spinner spn = findViewById(R.id.spn_Tip);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                onCalcBtnClick(view);
                //onSpinnerItemSelect(pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onSpinnerItemSelect(int pos) {
        EditText et_amt = findViewById(R.id.et_Amount);

        double amt = Double.parseDouble(et_amt.getText().toString());

        //Spinner spn_Tip = findViewById(R.id.spn_Tip);

        int spn_Selection = pos;

        double tip_percent = 0;

        switch (spn_Selection) {
            case 0:
                tip_percent = 0.25;
                break;
            case 1:
                tip_percent = 0.2;
                break;
            case 2:
                tip_percent = 0.15;
                break;
            case 3:
                tip_percent = 0.1;
                break;
            default:
                tip_percent = 0;
                break;
        }

        double tip_amt = amt * tip_percent;

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        TextView tv_tip = findViewById(R.id.tv_Tip_Amount);

        tv_tip.setText(currency.format(tip_amt));

    }

    private void onCalcBtnClick(View v) {
        EditText et_amt = findViewById(R.id.et_Amount);

        if (et_amt.getText().toString().isEmpty())
            return;

        double amt = Double.parseDouble(et_amt.getText().toString());

        Spinner spn_Tip = findViewById(R.id.spn_Tip);

        int spn_Selection = spn_Tip.getSelectedItemPosition();

        double tip_percent = 0;

        switch (spn_Selection) {
            case 0:
                tip_percent = 0.25;
                break;
            case 1:
                tip_percent = 0.2;
                break;
            case 2:
                tip_percent = 0.15;
                break;
            case 3:
                tip_percent = 0.1;
                break;
            default:
                tip_percent = 0;
                break;
        }

        double tip_amt = amt * tip_percent;

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        TextView tv_tip = findViewById(R.id.tv_Tip_Amount);

        tv_tip.setText(currency.format(tip_amt));

    }
}
