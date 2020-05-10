package com.example.android_1_my_dz_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if(savedInstanceState != null){
            firstValues = savedInstanceState.getDouble("firstValues");
            secondValues = savedInstanceState.getDouble("secondValues");
            operation = savedInstanceState.getString("operation");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(firstValues != null){
            outState.putDouble("firstValues",firstValues);
        }
        if(secondValues != null){
            outState.putDouble("secondValues",secondValues);
        }
        if(operation != null){
            outState.putString("operation",operation);
        }
    }


    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.zero:
                result.append("0");
                break;
            case R.id.point:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + ".");
                operation = ".";
                break;
            case R.id.clear:
                result.setText(null);
                break;
            case R.id.back:
                String str;
                str = result.getText().toString();
                result.setText(null);
                str = str.substring(0, str.length() - 1);
                result.setText(result.getText() + str);
                break;
        }
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
                break;
            case R.id.multiplication:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
                break;
            case R.id.division:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.equally:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, " ");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plus();
                            break;

                        case "-":
                            minus();
                            break;

                        case "*":
                            multiplication();
                            break;

                        case "/":
                            division();
                            break;
                    }
                }
                break;
        }
    }
    public void plus() {
        result_op = firstValues + secondValues;
        result.setText(firstValues + "+" + secondValues + "=" + result_op);
    }

    public void minus() {
        result_op = firstValues - secondValues;
        result.setText(firstValues + "-" + secondValues + "=" + result_op);
    }

    public void multiplication() {
        result_op = firstValues * secondValues;
        result.setText(firstValues + "*" + secondValues + "=" + result_op);
    }

    public void division() {
        result_op = firstValues / secondValues;
        result.setText(firstValues + "/" + secondValues + "=" + result_op);
    }

    }

