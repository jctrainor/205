package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ImageButton buttonTemp, buttonLength, buttonWeight;
    TextView result, result2, result3, unit, unit2,unit3;
    EditText user;

    String Options[] = {"KG", "cel", "meters"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        buttonLength = (ImageButton) findViewById(R.id.buttonLength);
        buttonTemp = (ImageButton) findViewById(R.id.buttonTemp);
        buttonWeight = (ImageButton) findViewById(R.id.buttonWeight);

        result = (TextView) findViewById(R.id.result2);
        result2 = findViewById(R.id.result);
        result3 = findViewById(R.id.result3);
        unit = findViewById(R.id.unit3);
        unit2 = findViewById(R.id.unit2);
        unit3 = findViewById(R.id.unit);
        user = findViewById(R.id.user);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.convert, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    String temp = spinner.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, temp + ", ", Toast.LENGTH_SHORT).show();
                    unit3.setText("Kelvin");
                    unit2.setText("farenheit");
                    unit.setText("");
                    result.setText("");
                    result2.setText("");
                    result3.setText("");

                    Temp();
                }
                else
                    Toast.makeText(MainActivity.this, "Error ", Toast.LENGTH_SHORT).show();
            }
        });

        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 1) {
                    String temp = spinner.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, temp + ", ", Toast.LENGTH_SHORT).show();
                    unit.setText("inch");
                    unit3.setText("Feet");
                    unit2.setText("Centimetre");
                    Length();
                }
                else
                    Toast.makeText(MainActivity.this, "Error ", Toast.LENGTH_SHORT).show();
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 2) {
                    String temp = spinner.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, temp + ", ", Toast.LENGTH_SHORT).show();
                    unit.setText("Grams");
                    unit2.setText("Ounces");
                    unit3.setText("Pounds");
                    Weight();
                }
                else
                    Toast.makeText(MainActivity.this, "Error ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void Length(){
        String ValueinMeter = user.getText().toString();
        double Meter = Double.parseDouble(ValueinMeter);
        double Centimetre = Math.round(Meter * 100);
        double Foot = Math.round( Meter * 3.281);
        double Inch = Math.round(Meter * 39.37);
        result.setText(""+ Centimetre);
        result2.setText("" + Foot);
        result3.setText("" + Inch);
    }



    public void Temp() {
        String ValueInCel = user.getText().toString();
        double Cel =  Double.parseDouble(ValueInCel);
        double Fahrenheit = (Cel * 1.8) + 32;
        double Kelvin = Cel + 273.15;
        result.setText("" + Fahrenheit);
        result2.setText("" + Kelvin);
    }

    public void Weight() {
        String ValueInKG = user.getText().toString();
        double KG = Double.parseDouble(ValueInKG);
        double Gram = Math.round(KG * 1000);
        double Ounce = Math.round(KG * 35.274);
        double Pound = Math.round(KG * 2.205);
        result3.setText(""+ Gram);
        result.setText(""+ Ounce);
        result2.setText(""+ Pound);
    }
}