package com.example.ersan.agenda.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;

public class AgendaActivity extends AppCompatActivity {

    EditText /*edtCompromissoTipo,*/ edtCompromissoComplmento, edtCompromissoHora;
    Button btnGravar, btnEditar, btnEmail, btnApagar;
    Spinner spnTipoCompromisso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

//        edtCompromissoTipo = (EditText) findViewById(R.id.edtCompromissoTipo);
        edtCompromissoComplmento = (EditText) findViewById(R.id.edtCompromissoComplmento);
        edtCompromissoHora = (EditText) findViewById(R.id.edtCompromissoHora);

        spnTipoCompromisso = (Spinner) findViewById(R.id.spnTipoCompromisso);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipoCompromissos_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnTipoCompromisso.setAdapter(adapter);

        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnApagar = (Button) findViewById(R.id.btnApagar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        String tipo = getIntent().getStringExtra("CompromissoTipo");
        String complemento = getIntent().getStringExtra("CompromissoComplmento");
        String hora = getIntent().getStringExtra("CompromissoHora");
        if (tipo != null && complemento != null && hora != null){
            spnTipoCompromisso.setSelection(adapter.getPosition(tipo));
            spnTipoCompromisso.setEnabled(false);
            edtCompromissoHora.setText(hora);
            edtCompromissoHora.setEnabled(false);
            edtCompromissoComplmento.setText(complemento);
            edtCompromissoComplmento.setEnabled(false);
            btnEditar.setVisibility(View.VISIBLE);

        }


    }

    public void btnGravarClick(View view) {
        if (!spnTipoCompromisso.getSelectedItem().toString().equals("Escolha um tipo")/*!edtCompromissoTipo.getText().toString().equals("")*/){
            Compromisso com = new Compromisso();
            com.setTipo(spnTipoCompromisso.getSelectedItem().toString());
            com.setComplemento(edtCompromissoComplmento.getText().toString());
            com.setHora(edtCompromissoHora.getText().toString());
            CompromissosDal.adicionaCompromisso(this,com);
//            edtCompromissoTipo.setText("");
//            edtCompromissoHora.setText("");
//            edtCompromissoComplmento.setText("");

            finish();

        } else {
            Toast.makeText(this, "Favor preencher o tipo de agendamento", Toast.LENGTH_LONG).show();
            spnTipoCompromisso.setBackgroundColor(Color.parseColor("#479cf4"));
        }

    }
}
