package com.example.deyneson.media;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber1,edtNumber2;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = (EditText) findViewById(R.id.edtNumber1);
        edtNumber2 = (EditText) findViewById(R.id.edtNumber2);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
    }

    public void btnCalculateClick(View view) {
        int iNum1 = Integer.parseInt(edtNumber1.getText().toString());
        int iNum2 = Integer.parseInt(edtNumber2.getText().toString());
        float iResult = (iNum1 + iNum2) / 2;
        Toast.makeText(MainActivity.this,"A média é: " + iResult,Toast.LENGTH_LONG).show();
    }
}
