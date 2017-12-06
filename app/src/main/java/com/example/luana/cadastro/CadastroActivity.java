package com.example.luana.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

public class CadastroActivity extends AppCompatActivity {

     EditText IDnome,IDsenha,IDrepetir,IDemail;
     RadioButton RBmasculino,RBfeminino;
     Button BTcadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button cadastrar = (Button)findViewById(R.id.BTcadastrar);

        final EditText IDnome = (EditText)findViewById(R.id.IDnome);
        final EditText IDsenha = (EditText)findViewById(R.id.IDsenha);
        final EditText IDrepetir = (EditText)findViewById(R.id.IDrepetir);
        final EditText IDemail = (EditText)findViewById(R.id.IDemail);
        final RadioGroup sexoOpçoes = (RadioGroup)findViewById(R.id.sexoOpçoes);
        cadastrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                int s = sexoOpçoes.getCheckedRadioButtonId();
                String sexo = "";
                if (IDsenha.getText().toString().equals(IDrepetir.getText().toString())) {
                    if (s == R.id.RBmasculino)
                    sexo = "Masculino";
                else
                    sexo = "Feminino";
                    String msg = "Nome : " + IDnome.getText().toString();
                    //a barra n é quebra de texto
                    msg += "\nSenha: " + IDsenha.getText().toString();
                    msg += "\nemail: " + IDemail.getText().toString();
                    msg += "\nsexo: " + sexo;

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(CadastroActivity.this);
                    dialogo.setTitle("Cadastro");
                    dialogo.setMessage(msg);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }else{
                    Toast.makeText(CadastroActivity.this, "A primeira senha informada não confere com segunda", Toast.LENGTH_SHORT).show();

                    }
            }

        });
    }
}
