/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.categorie;
import entites.evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utiles.MyBD;
/**
 *
 * @author turki
 */
public class Event implements IEvent<evenement> {
    
    private Connection conn;

    public Event() {
        conn=MyBD.getInstance().getCnx();
    }
    
    public static boolean estChaineValide(String chaine) {
   
    // Vérifier si la chaîne ne contient que des lettres et n'accepte pas les chaines vides ou qu'avec des espaces.
    if (!chaine.matches("[a-zA-Z ]+") || chaine.trim().isEmpty()) {
        return false;
    }
    
       return true;
    }
    
    // verifier que la longeur de la saisie ne depasse pas 40 caracteres.
    public boolean isStringLengthLessThanForty(String str) {
    return str.length() < 40;
}

    
    public void insert(evenement t){
        String requete="insert into evenement (nom,descriptif,image) values (?,?,?)";
        try {
            PreparedStatement event=conn.prepareStatement(requete);
            
            t.setDescriptif(t.getDescriptif().trim());
            t.setNom(t.getNom().trim());
            
            if (estChaineValide(t.getDescriptif())&&estChaineValide(t.getNom())&&isStringLengthLessThanForty(t.getNom())){
            event.setString(1, t.getNom());
            event.setString(2, t.getDescriptif());
            event.setString(3, t.getImage());
            event.executeUpdate(); } else {
                System.out.println("erreur controle de saisie evenement");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public void delete(evenement t) {
        String requete="delete from evenement where id_evenement = "+t.getId_evenement();
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void update(evenement t) {
        String requete = "update evenement set nom=?,descriptif=?,image=? where id_evenement="+t.getId_evenement();
        try {
            PreparedStatement event = conn.prepareStatement(requete);
            t.setDescriptif(t.getDescriptif().trim());
            t.setNom(t.getNom().trim());
            
            if (estChaineValide(t.getDescriptif())&&estChaineValide(t.getNom())&&isStringLengthLessThanForty(t.getNom())){
            event.setString(1, t.getNom());
            event.setString(2, t.getDescriptif());
            event.setString(3, t.getImage());
            event.executeUpdate();
            System.out.println("evenement mise à jour");
            } else {
                System.out.println("erreur controle de saisie evenement");
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de l'evenement" + ex.getMessage());
        }
    }

    @Override
    public List<evenement> readAll() {
        String requete ="select * from evenement";
        List<evenement> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               evenement t=new evenement

        (rs.getInt("id_evenement"), rs.getString("nom"), rs.getString("descriptif"), rs.getString("image"));
               list.add(t);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /*@Override
    public evenement readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public void insertevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateevent(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public evenement readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ObservableList<evenement> searchByEvenement(String titre) throws SQLException{
        String qry="SELECT * FROM evenement where nom LIKE '%"+titre+"%'" ;
                  System.out.println(qry);
        Connection cnx = MyBD.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
        ObservableList<evenement>  list = FXCollections.observableArrayList()  ; 
        while(rs.next()){
        evenement a = new evenement(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)); 
        list.add(a) ;
        }
         

        return list ;
    }

    }