/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.categorie;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.categori;

/**
 * FXML Controller class
 *
 * @author anash
 */
public class CategorieController implements Initializable {

    @FXML
    private TextField tf_idcat;
    @FXML
    private TextField tf_comcat;
    @FXML
    private TextField tf_descri;
    @FXML
    private TextField tf_id_eve;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TableColumn clm_cat;
    @FXML
    private TableColumn clm_nom;
    @FXML
    private TableColumn clm_descr;
    @FXML
    private TableColumn clm_event;
    private categori categori = new categori();
    @FXML
    private TableView<categorie> tab_cat;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          clm_cat.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
        clm_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        clm_descr.setCellValueFactory(new PropertyValueFactory<>("descriptif"));
        clm_event.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
       
        // récupère les données des utilisateurs depuis la base de données
       
        // affiche les données dans le tableau
        List<categorie> categorielist = categori.readAll();
       
        // affiche les données dans le tableau
        tab_cat.getItems().setAll(categorielist);
        // TODO
        // TODO
    }    

    @FXML
    private void click_on_ajouter(ActionEvent event) {
         int id_categorie = Integer.parseInt(tf_idcat.getText());
        String nom = tf_comcat.getText();
        String descriptif = tf_descri.getText();
        int id_evenement = Integer.parseInt(tf_id_eve.getText());
         
     categori sp=new categori();
   categorie e = new categorie(id_categorie,nom,descriptif,id_evenement);
   sp.insert(e);
   List<categorie> categorielist = categori.readAll();
   tab_cat.getItems().setAll(categorielist);
    }

    @FXML
    private void click_on_supprimer(ActionEvent event) {
          categorie selectedCategorie = (categorie) tab_cat.getSelectionModel().getSelectedItem();
       
        if (selectedCategorie == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No category selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a category in the table.");
            alert.showAndWait();
            return;
    }
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected category?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           
            categori.delete(selectedCategorie);
             List<categorie> topicList = categori.readAll();
       
        // affiche les données dans le tableau
        tab_cat.getItems().setAll(topicList);
        }
       
    
    }

    @FXML
    private void click_on_modifier(ActionEvent event) {
        int id_categorie=Integer.parseInt(tf_idcat.getText());
        String nom=tf_comcat.getText();
         String descriptif = tf_descri.getText();
        int id_evenement = Integer.parseInt(tf_id_eve.getText());
        categorie c=new categorie(id_categorie,nom,descriptif,id_evenement);
        categori cs=new categori();
        cs.update(c);
                     List<categorie> categorielist = categori.readAll();

                tab_cat.getItems().setAll(categorielist);
    }
    }
    

