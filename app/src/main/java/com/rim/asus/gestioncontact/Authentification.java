package com.rim.asus.gestioncontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Authentification extends AppCompatActivity implements View.OnClickListener {

    Button b_val  ;
    Button b_qt  ;
    EditText ed_nom ;
    EditText ed_pass_auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        b_val=(Button)findViewById(R.id.b_val);
        b_qt=(Button)findViewById(R.id.b_qt);
        ed_nom=(EditText) findViewById(R.id.ed_nom);
        ed_pass_auth=(EditText)findViewById(R.id.ed_pass_auth);
        b_val.setOnClickListener(this);
        b_qt.setOnClickListener(this);


        // Toast.makeText(this, "succee", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v==b_val)
        {
            String nom = ed_nom.getText().toString() ;
            String pass= ed_pass_auth.getText().toString() ;
            if ((nom.equals("rim")&&pass.equals("123")) || (nom.equals("sahar")&&pass.equals("123")) )
            {
                Intent i = new Intent(Authentification.this,Accueil.class) ;
                i.putExtra("nom", nom);
                startActivity(i);
                finish();


            }

        }
        else if (v==b_qt)
        {
            this.finish();
        }
    }
}
