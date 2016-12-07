package com.example.deynesonborba.listas.view;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deynesonborba.listas.R;
import com.example.deynesonborba.listas.dao.MotocicletaDao;
import com.example.deynesonborba.listas.model.Motocicleta;

public class CadastroActivity extends AppCompatActivity {

    Button btnGravar;
    EditText edtMarca, edtModelo, edtAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnGravar = (Button) findViewById(R.id.btnGravar);
        edtMarca = (EditText) findViewById(R.id.edtMarca);
        edtModelo = (EditText) findViewById(R.id.edtModelo);
        edtAno = (EditText) findViewById(R.id.edtAno);
    }

    public void btnGravarClick(View view) {
        if(!edtMarca.getText().toString().equals("")) {
            if (!edtModelo.getText().toString().equals("")) {
                if(!edtAno.getText().toString().equals("")){
                    Motocicleta m = new Motocicleta();
                    m.setMarca(edtMarca.getText().toString());
                    m.setModelo(edtModelo.getText().toString());
                    m.setAno(Integer.parseInt(edtAno.getText().toString()));

                    long id = MotocicletaDao.addMotocicleta(m, CadastroActivity.this);

                    //Inicio implementação notificação
                    //Deve-se colocar uma imagem pnj no drawable para aparecer na notificação,
                    //  de preferência a mesma imagem do icone da aplicação.
                    final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);//Passando o contexto
                    builder.setSmallIcon(R.drawable.ic_launcher);//setando a imagem da notificação
                    builder.setContentTitle("Novo registro adicionado");//título da notificação
                    //Alterar metódo no dao para retornar o id do item adicionado, só para mostrar na notificação.
                    builder.setContentText("Id do registro: " + id);

                    //Parametros:Primeiro contex é onde vc está e o segundo context é a intent que vai
                    //  abrir quando vc clicar na notificação.
                    Intent notificationIntent = new Intent(this, CadastroActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity
                            (this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    builder.setContentIntent(pendingIntent);

                    //Gerenciador de notificações
                    final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                    //Runnable para a notificação esperar 5 seg para aparecer e não travar o celular neste meio tempo
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Coloca o que quiser em uma thread secundária.
                            //Boa utilização seria rodar aqui uma requisição rest,
                            //      assim o sistema não fica esperando a requisição terminar.

                            //Mandar esperar 5 seg para mostrar
                            try{
                                Thread.sleep(5000);

                                //Mostrar notificação
                                notificationManager.notify(0, builder.build());

                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();//start thread

                    //O builder e o notificationManager são 'final' para funcionar o método run.
                }
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
