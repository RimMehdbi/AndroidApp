package com.rim.asus.gestioncontact;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends AppCompatActivity  implements View.OnClickListener {
    Button b_val_aj  ;
    Button b_qt_aj ;
    EditText ed_nom_ajout ;
    EditText ed_prenom_ajout ;
    EditText ed_tel_ajout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        ed_nom_ajout = findViewById(R.id.ed_nom_aj) ;
        ed_prenom_ajout = findViewById(R.id.ed_prenom_aj) ;
        ed_tel_ajout = findViewById(R.id.ed_tel) ;

        b_val_aj= findViewById(R.id.b_val_aj) ;
        b_val_aj.setOnClickListener(this);
        b_qt_aj= findViewById(R.id.b_qt_aj) ;
        b_qt_aj.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v == b_val_aj)
        {
            Contact c = new Contact(ed_nom_ajout.getText().toString() ,
                    ed_prenom_ajout.getText().toString(),ed_tel_ajout.getText().toString() ) ;
                    Accueil.data.add(c) ;




        }
        if (v == b_qt_aj)
        {

            Intent i = new Intent(Ajout.this,Afficher.class) ;
            startActivity(i);
            finish();
        }



    }
}


