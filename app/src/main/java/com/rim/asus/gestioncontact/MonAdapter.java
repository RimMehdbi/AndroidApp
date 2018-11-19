package com.rim.asus.gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    Context con ;
    ArrayList<Contact> l ;

    public MonAdapter(Context con , ArrayList<Contact> l ) {

        this.con = con ;
        this.l = l ;


    }

    @Override
    public int getCount() {
        return (l.size());
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
      /*  TextView t1 = new TextView(con);
        t1.setText(l.get(pos).getNom());
        TextView t2 = new TextView(con);
        t2.setText(l.get(pos).getPrenom());
        TextView t3 = new TextView(con);
        t3.setText(l.get(pos).getTel());
        LinearLayout l1 = new LinearLayout(con) ;
        l1.setOrientation(LinearLayout.VERTICAL);
        LinearLayout l2 = new LinearLayout(con) ;
        l2.setOrientation(LinearLayout.HORIZONTAL);
        l1.addView(t2);
        l1.addView(t3);
        l2.addView(t1);
        l2.addView(l1);
        return l2 ;*/

        LinearLayout li ;
        LayoutInflater inf = LayoutInflater.from(con);
        li= (LinearLayout)  inf.inflate(R.layout.view,null) ;
        TextView t1 = li.findViewById(R.id.txt_nomAd) ;
        t1.setText(l.get(pos).getNom());
        TextView t2 = li.findViewById(R.id.txt_prenomAd);
        t2.setText(l.get(pos).getPrenom());
        TextView t3 = li.findViewById(R.id.txt_numAd) ;
        t3.setText(l.get(pos).getTel());


        // ImageView im = li.findViewById(R.id.img) ;

        return li ;









    }
}
