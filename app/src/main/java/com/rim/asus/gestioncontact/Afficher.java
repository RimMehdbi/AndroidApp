package com.rim.asus.gestioncontact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.widget.Toast.LENGTH_SHORT;

public class Afficher extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener , AlertDialog.OnClickListener {

    ArrayList<Contact> repertoire = Accueil.data ;
    ListView l ;
    int indice ;

    EditText t1 ;

    EditText t2 ;

    EditText t3  ;
    AlertDialog.Builder alertq ;
   // Context con = this  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);
        l=  (ListView )findViewById(R.id.lv_aff) ;
    //    ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,repertoire) ;
        MonAdapter m = new MonAdapter(this,repertoire) ;
        l.setAdapter(m);
        l.setOnItemClickListener(this);
        l.setOnItemLongClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       /* indice=position ;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Attention") ;
        alert.setMessage("Choisir une action") ;
        alert.setPositiveButton("supprimer",this) ;
        alert.setNegativeButton("Supprimer tous",this) ;
        alert.setNeutralButton("modifer",this) ;

        alert.show() ;*/

        //return false;

        //toujours false

        Toast.makeText(this, "you clicked ", LENGTH_SHORT).show();



    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
         indice=position ;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
      //  con=alert.getContext() ;
        alert.setTitle("Attention") ;
        alert.setMessage("Choisir une action") ;
        alert.setPositiveButton("supprimer",this) ;
        alert.setNegativeButton("Supprimer tous",this) ;
        alert.setNeutralButton("modifer",this) ;

        alert.show() ;

        return false;

        //toujours false
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == dialog.BUTTON_POSITIVE)
        {
            Accueil.data.remove(indice) ;
            l.invalidateViews();

        }
        else if (which == dialog.BUTTON_NEGATIVE)

        {

            Accueil.data.clear();
            l.invalidateViews();

        }
        else if (which == dialog.BUTTON_NEUTRAL)
        {
            Toast.makeText(this, "you clicked modifiéé", LENGTH_SHORT).show();

            AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
          //  alertq = alert2 ;
            alert2.setTitle("Modifier ") ;
            alert2.setMessage("Modifier") ;
            LayoutInflater inf = LayoutInflater.from(this) ;
            LinearLayout av ;
            av=(LinearLayout)inf.inflate(R.layout.alert_view , null) ;
            t1 = av.findViewById(R.id.e1) ;
            t1.setText(repertoire.get(indice).getNom());
            t2 = av.findViewById(R.id.e2) ;
            t2.setText(repertoire.get(indice).getPrenom());
            t3 = av.findViewById(R.id.e3) ;
            t3.setText(repertoire.get(indice).getTel());
            Button b = av.findViewById(R.id.b_mod_alert) ;
            b.setOnClickListener(new View.OnClickListener( ) {
                @Override
                public void onClick(View v) {



                    Contact c = new Contact(t1.getText().toString(), t2.getText().toString(),t3.getText().toString()) ;
                    repertoire.set(indice,c);
                }
            });
            Button b2 = av.findViewById(R.id.b_mod_quit) ;
            b2.setOnClickListener(new View.OnClickListener( ) {
                @Override
                public void onClick(View v) {

                  //alertq.cancel
                }
            });
            alert2.setView(av) ;
            alert2.show() ;



        }



    }
}
