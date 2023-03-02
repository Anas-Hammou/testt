/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entites.evenement;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
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
import services.Event;
import services.IEvent;

/**
 * FXML Controller class
 *
 * @author anash
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_descriptif;
    private TextField tf_image;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField ini;
    @FXML
    private TableView<evenement> tv_afficher;
    @FXML
    private TableColumn tc_eve;
    @FXML
    private TableColumn tc_nom;
    @FXML
    private TableColumn tc_desc;
    @FXML
    private TableColumn tc_image;
    private Event Event = new Event();
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_pdf;
    @FXML
    private TextField chercher;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tc_eve.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        tc_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tc_desc.setCellValueFactory(new PropertyValueFactory<>("descriptif"));
        tc_image.setCellValueFactory(new PropertyValueFactory<>("image"));
       
        // récupère les données des utilisateurs depuis la base de données
       
        // affiche les données dans le tableau
        List<evenement> evenementlist = Event.readAll();
       
        // affiche les données dans le tableau
        tv_afficher.getItems().setAll(evenementlist);
        // TODO
        // TODO
    }    

    @FXML
    private void click_on_ajouter(ActionEvent event) {
          int id_evenement = Integer.parseInt(tf_id.getText());
        String nom = tf_nom.getText();
        String descriptif = tf_descriptif.getText();
        String image = ini.getText();
         
     Event sp=new Event();
   evenement e = new evenement(id_evenement,nom,descriptif,image);
   sp.insert(e);
   List<evenement> evenementlist = Event.readAll();
   tv_afficher.getItems().setAll(evenementlist);
    }

    @FXML
    private void click_on_supprimer(ActionEvent event) {
         evenement selectedEvenement = (evenement) tv_afficher.getSelectionModel().getSelectedItem();
       
        if (selectedEvenement == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No event selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an event in the table.");
            alert.showAndWait();
            return;
    }
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected user?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           
            Event.delete(selectedEvenement);
             List<evenement> topicList = Event.readAll();
       
        // affiche les données dans le tableau
        tv_afficher.getItems().setAll(topicList);
        }
       
    
   
}

    @FXML
    private void click_on_modifier(ActionEvent event) {
          int id_evenement=Integer.parseInt(tf_id.getText());
        String nom=tf_nom.getText();
         String descriptif = tf_descriptif.getText();
        String image = ini.getText();
        evenement f=new evenement(id_evenement,nom,descriptif,image);
        Event fs=new Event();
        fs.update(f);
                     List<evenement> evenementlist = Event.readAll();

                tv_afficher.getItems().setAll(evenementlist);
    }
    
    @FXML
private void btnGenPDF(ActionEvent event) throws DocumentException, FileNotFoundException, IOException {
    long millis = System.currentTimeMillis();
    java.sql.Date DateRapport = new java.sql.Date(millis);

    String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);
    System.out.println("Date d'aujourdhui : " + DateLyoum);

    com.itextpdf.text.Document document = new com.itextpdf.text.Document();

    try {
        PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));
        document.open();
// Ajouter le logo
       /* Image logo = Image.getInstance("C://xampp//htdocs//onlywork/logo.png");
        logo.scaleAbsolute(100, 100);
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);*/
        // Ajouter un titre avec un style personnalisé
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Rapport détaillé de notre application", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Ajouter un paragraphe avec un style personnalisé
        Font paragraphFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);
        Paragraph ph1 = new Paragraph("Voici un rapport détaillé de notre application qui contient tous les événements. Pour chaque événement, nous fournissons des informations telles que la date d'aujourd'hui : " + DateRapport, paragraphFont);
        ph1.setSpacingAfter(10);
        document.add(ph1);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Créer une cellule avec un style personnalisé
        Font cellFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Titre", cellFont));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Description", cellFont));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Nom société", cellFont));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        evenement r = new evenement();
        Event sp = new Event();
        sp.readAll().forEach(e -> {
            table.addCell(String.valueOf(e.getNom()));
            table.addCell(String.valueOf(e.getDescriptif()));
            table.addCell(String.valueOf(e.getImage()));
        });

        document.add(table);
    } catch (Exception e) {
        System.out.println(e);
    }
    document.close();

    // Ouvrir le fichier PDF
    File file = new File(DateLyoum + ".pdf");
    Desktop desktop = Desktop.getDesktop();
    if (file.exists()) {
        desktop.open(file);
    }
}


    @FXML
    private void Recherche(javafx.scene.input.KeyEvent event) throws SQLException {
        evenement p=new evenement();
Event sp = new Event();
       tv_afficher.setItems(sp.searchByEvenement(chercher.getText()));
    }
    }
