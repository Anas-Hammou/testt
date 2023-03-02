/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.categorie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.MyBD;

/**
 *
 * @author anash
 */
public class categori implements ICategori<categorie> {
    
    private Connection conn;

    public categori() {
        conn=MyBD.getInstance().getCnx();
    }

    
    public static boolean estChaineValide(String chaine) {
    // Vérifier si la chaîne est vide ou nulle
    if (chaine == null || chaine.trim().isEmpty()) {
        return false;
    }
    
    // Vérifier si la chaîne ne contient que des lettres
    if (!chaine.matches("[a-zA-Z ]+")) {
        return false;
    }
    
    // La chaîne est valide si elle passe toutes les vérifications
return true;
    }
    
    public boolean isStringLengthLessThanForty(String str) {
    return str.length() < 40;
}
    
    public void insert(categorie t){
        String requete="insert into categorie (nom,descriptif,id_evenement) values (?,?,?)";
        try {
            PreparedStatement categori=conn.prepareStatement(requete);
            
            t.setDescriptif(t.getDescriptif().trim());
            t.setNom(t.getNom().trim());
            
            
            if (estChaineValide(t.getDescriptif())&&estChaineValide(t.getNom())&&isStringLengthLessThanForty(t.getNom())){
            categori.setString(1, t.getNom());
            categori.setString(2, t.getDescriptif());
            categori.setInt(3, t.getId_evenement());
            categori.executeUpdate();
            } else {
                System.out.println("erreur controle de saisie");
            }
        } catch (SQLException ex) {
            Logger.getLogger(categori.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public void delete(categorie t) {
        String requete="delete from categorie where id_categorie = "+t.getId_categorie();
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(categori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void update(categorie t) {
        String requete = "update categorie set  nom=?,descriptif=?,id_evenement=? where id_categorie="+t.getId_categorie();
        try {
            PreparedStatement categori = conn.prepareStatement(requete);
            t.setDescriptif(t.getDescriptif().trim());
            t.setNom(t.getNom().trim());
            
            
            if (estChaineValide(t.getDescriptif())&&estChaineValide(t.getNom())&&isStringLengthLessThanForty(t.getNom())){
            categori.setString(1, t.getNom());
            categori.setString(2,t.getDescriptif());
            categori.setInt(3, t.getId_evenement());
            categori.executeUpdate();
            System.out.println("categorie mise à jour");
            } else {
                System.out.println("erreur controle de saisie");
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de la categorie" + ex.getMessage());
        }
    }

    public List<categorie> readAll() {
        String requete ="select * from categorie";
        List<categorie> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               categorie t=new categorie

        (rs.getInt("id_categorie"), rs.getString("nom"), rs.getString("descriptif"), rs.getInt("id_evenement"));
               list.add(t);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(categori.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public categorie readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    @Override
    public void insertcategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertcategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public void insertcategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatecategori(categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
