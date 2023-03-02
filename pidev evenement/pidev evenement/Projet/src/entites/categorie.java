/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;
import org.w3c.dom.ls.LSOutput;

import java.awt.Image;

/**
 *
 * @author turki
 */
public class categorie {
    private int id_categorie;
    private String nom ;
    private String descriptif;
    private int id_evenement; 

    public categorie() {
    }

    public categorie(String nom) {
        this.nom = nom;
    }

    public categorie(String nom, String descriptif) {
        this.nom = nom;
        this.descriptif = descriptif;
    }

    public categorie(String nom, String descriptif, int id_evenement) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.id_evenement = id_evenement;
    }
    

    public categorie(int id_categorie, String nom, String descriptif, int id_evenement) {
        this.id_categorie = id_categorie;
        this.nom = nom;
        this.descriptif = descriptif;
        this.id_evenement = id_evenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }
    
    
    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_categorie=" + id_categorie + ", nom=" + nom + ", descriptif=" + descriptif + ", id_evenement=" + id_evenement + '}';
    }
    
}