/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

/**
 *
 * @author turki
 */
public class evenement {
    private int id_evenement ;
    private String nom ;
    private String descriptif ;
    private String image;

    public evenement() {
    }


    public evenement(int id_evenement, String nom, String descriptif, String image) {
        this.id_evenement = id_evenement;
        this.nom = nom;
        this.descriptif = descriptif;
        this.image = image;
    }

    public evenement(String nom, String descriptif, String image) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.image = image;
    }
    public evenement(String nom, String descriptif) {
        this.nom = nom;
        this.descriptif = descriptif;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "evenement{" + "id_evenement=" + id_evenement + ", nom=" + nom + ", descriptif=" + descriptif + ", image=" + image + '}';
    }
}