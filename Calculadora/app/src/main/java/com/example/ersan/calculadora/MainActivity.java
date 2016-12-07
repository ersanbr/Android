package com.example.ersan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPonto,btnAdicao,btnSubtracao,btnMultiplicacao,btnDivisao,btnIgual;
    TextView txtResultado;
    int MAX=12;
    float numero1,numero2;
    String operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculadora);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnPonto = (Button) findViewById(R.id.btnPonto);

        btnIgual = (Button) findViewById(R.id.btnIgual);

        btnAdicao = (Button) findViewById(R.id.btnAdicionar);
        btnSubtracao = (Button) findViewById(R.id.btnSubtrair);
        btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicar);
        btnDivisao = (Button) findViewById(R.id.btnDividir);

        txtResultado = (TextView) findViewById(R.id.txtResultado);

    }

    public void btn0Click(View view) {
        pegaNumero(view);
    }

    public void btn1Click(View view) {
        pegaNumero(view);
    }

    public void btn2Click(View view) {
        pegaNumero(view);
    }

    public void btn3Click(View view) {
        pegaNumero(view);
    }

    public void btn4Click(View view) {
        pegaNumero(view);
    }

    public void btn5Click(View view) {
        pegaNumero(view);
    }

    public void btn6Click(View view) {
        pegaNumero(view);
    }

    public void btn7Click(View view) {
        pegaNumero(view);
    }

    public void btn8Click(View view) {
        pegaNumero(view);
    }

    public void btn9Click(View view) {
        pegaNumero(view);
    }

    public void btnPontoClick(View view) {
        Button b = (Button)view;

        if (txtResultado.getText().toString().length()<MAX) {
            if (!txtResultado.getText().toString().contains(".")){
                txtResultado.setText(txtResultado.getText().toString() + b.getText().toString());
            }
        }
        else{
            Toast.makeText(MainActivity.this,"Limite de Caracteres Atingido",Toast.LENGTH_LONG).show();
        }

    }

    public void btnAdicaoClick(View view) {
        guardaNumero(view);
    }

    public void btnSubtracaoClick(View view) {
        guardaNumero(view);
    }

    public void btnMultiplicacaoClick(View view) {
        guardaNumero(view);
    }

    public void btnDivisaoClick(View view) {
        guardaNumero(view);
    }

    public void btnIgualClick(View view) {
        efetualCalculo(view);
    }

    private void pegaNumero(View view) {
        Button b = (Button)view;

        if (txtResultado.getText().toString().length()<MAX) {
            txtResultado.setText(txtResultado.getText().toString() + b.getText().toString());
        }
        else{
            Toast.makeText(MainActivity.this,"Limite de Caracteres Atingido",Toast.LENGTH_LONG).show();
        }
    }

    private void guardaNumero(View view) {
        Button b = (Button)view;
        numero1= Float.parseFloat (txtResultado.getText().toString());
        operacao = b.getText().toString();
        txtResultado.setText("");
    }

    private void efetualCalculo(View view){
        numero2 = Float.parseFloat(txtResultado.getText().toString());
        Float resultado;

        if (operacao != null) {
            switch (operacao) {
                case "+":
                    resultado = numero1 + numero2;
                    txtResultado.setText(resultado.toString());
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    txtResultado.setText(resultado.toString());
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    txtResultado.setText(resultado.toString());
                    break;
                case "/":
                    if (0 != numero2) {
                        resultado = numero1 / numero2;
                        txtResultado.setText(resultado.toString());
                    } else {
                        Toast.makeText(MainActivity.this, "Divisão por zero impossível", Toast.LENGTH_LONG).show();
                        txtResultado.setText("");
                    }
                    break;
            }
        }
        else {
            Toast.makeText(MainActivity.this,"Operação não selecionada!",Toast.LENGTH_LONG).show();
        }
    }

    public void btnCClick(View view) {
        numero1 = 0;
        numero2 = 0;
        txtResultado.setText("");
        operacao = null;
    }

    public void btnApagarClick(View view) {
        if (!txtResultado.getText().toString().equals(null) && txtResultado.getText().length() > 0){
            txtResultado.setText(txtResultado.getText().toString().substring(0, txtResultado.getText().length()-1));


        }
    }
}
