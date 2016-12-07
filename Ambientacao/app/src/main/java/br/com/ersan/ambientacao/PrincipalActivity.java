package br.com.ersan.ambientacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    //declaração as views do .xml

    EditText edtNumero1,edtNumero2;
    Button btnCalcular;
    TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //programação começa a partir daqui
        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void btnCalcularClick(View view) {
        //int iNumero1,iNumero2;
        float fResultado,fNumero1,fNumero2;

        //verifica se existe números vazios que impossibilitem a execução do calculo
        if (!edtNumero1.getText().toString().equals("") && !edtNumero2.getText().toString().equals("")){
            fNumero1 = Float.parseFloat(edtNumero1.getText().toString());
            fNumero2 = Float.parseFloat(edtNumero2.getText().toString());
            fResultado = (fNumero1 + fNumero2) / 2;
            //imprimir msg na activity
            //Toast.makeText(PrincipalActivity.this,"Média dos números:" + fResultado,Toast.LENGTH_LONG).show();
            txtResultado.setText("Média: " + fResultado);
            Log.v("Teste","Chegou aqui");
        }
        else {
            Toast.makeText(PrincipalActivity.this,"Há Campos em branco",Toast.LENGTH_LONG).show();
        }

    }
}
