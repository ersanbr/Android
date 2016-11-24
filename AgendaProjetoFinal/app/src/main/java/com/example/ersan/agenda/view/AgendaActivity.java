package com.example.ersan.agenda.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;

public class AgendaActivity extends AppCompatActivity {

    EditText edtCompromissoTipo, edtCompromissoComplmento, edtCompromissoHora;
    Button btnGravar, btnEditar, btnEmail, btnApagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        edtCompromissoTipo = (EditText) findViewById(R.id.edtCompromissoTipo);
        edtCompromissoComplmento = (EditText) findViewById(R.id.edtCompromissoComplmento);
        edtCompromissoHora = (EditText) findViewById(R.id.edtCompromissoHora);
        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnApagar = (Button) findViewById(R.id.btnApagar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        String tipo = getIntent().getStringExtra("CompromissoTipo");
        String complemento = getIntent().getStringExtra("CompromissoComplmento");
        String hora = getIntent().getStringExtra("CompromissoHora");
        if (tipo != null && complemento != null && hora != null){
            edtCompromissoTipo.setText(tipo);
            edtCompromissoTipo.setEnabled(false);
            edtCompromissoHora.setText(hora);
            edtCompromissoHora.setEnabled(false);
            edtCompromissoComplmento.setText(complemento);
            edtCompromissoComplmento.setEnabled(false);
            btnEditar.setVisibility(View.VISIBLE);

        }


    }

    public void btnGravarClick(View view) {
        if (!edtCompromissoTipo.getText().toString().equals("")){
            Compromisso com = new Compromisso();
            com.setTipo(edtCompromissoTipo.getText().toString());
            com.setComplemento(edtCompromissoComplmento.getText().toString());
            com.setHora(edtCompromissoHora.getText().toString());
            CompromissosDal.adiconaCompromisso(com);
//            edtCompromissoTipo.setText("");
//            edtCompromissoHora.setText("");
//            edtCompromissoComplmento.setText("");

            finish();

        } else {
            Toast.makeText(this, "Favor preencher o tipo de agendamento", Toast.LENGTH_LONG).show();
        }

    }
}
