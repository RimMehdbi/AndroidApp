package com.rim.asus.gestioncontact;

public class Contact {

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Contact(String nom, String prenom, String tel) {

        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    private String nom ;
    private String prenom ;
    private String tel ;


    @Override
    public String toString() {
        return (nom+" " + prenom+ " " + tel ) ;
    }

     }
