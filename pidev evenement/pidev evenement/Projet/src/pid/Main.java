/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author walid
 */
public class Main extends Application{
    Parent parent;
    Stage stage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        try {
            this.stage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/gui/evenement.fxml"));
            Scene sc = new Scene(root);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
}