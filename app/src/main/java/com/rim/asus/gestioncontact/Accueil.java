package com.rim.asus.gestioncontact;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements View.OnClickListener {
    TextView txt_acc ;
    String nom ;
    Button b_aj  ;
    Button b_aff ;
    public static ArrayList<Contact>data = new ArrayList<Contact>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        txt_acc=findViewById(R.id.txt_acc) ;
        nom= getIntent().getExtras().getString("nom");
        init() ;
        txt_acc.setText("Acceuil de Mm "+nom);

        b_aj=(Button)findViewById(R.id.b_aj);
        b_aff=(Button)findViewById(R.id.b_aff);
        b_aj.setOnClickListener(this);
        b_aff.setOnClickListener(this);

    }

    private void init() {

        String address = Environment.getExternalStorageDirectory().getPath() ;
        File f = new File(address,"fichier.txt") ;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr) ;
            String ligne = null ;
            while((ligne=br.readLine())!= null)
            {

                String[]t=ligne.split("#");
                data.add(new Contact(t[0],t[1],t[2]));

            }
            br.close();
            fr.close();
        }
        catch (Exception e )
        {

        }


    }

    @Override
    public void onClick(View v) {
        if (v==b_aj)
        {

                Intent i = new Intent(Accueil.this,Ajout.class) ;
                startActivity(i);
                //finish();



        }
        else if (v==b_aff)
        {
            Intent i = new Intent(Accueil.this,Afficher.class) ;
            startActivity(i);
          //  finish();


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onstart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onstop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {

       //sauvgarde de fichier
        String address = Environment.getExternalStorageDirectory().getPath() ;
        File f = new File(address,"fichier.txt") ;
        try {
            FileWriter fw = new FileWriter(f, false);
            PrintWriter pw = new PrintWriter(fw) ;
            for (int i =0 ; i<data.size(); i++)
            {
                pw.write(data.get(i).getNom()+"#"+data.get(i).getPrenom()+"#"+data.get(i).getTel()+"\n");


            }
            pw.close();
            fw.close();

        }
        catch (Exception e )
        {}


        super.onDestroy();
    }
}
