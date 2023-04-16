/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import java.io.IOException;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; 
import javafx.stage.Stage;

/**
 *
 * @author devvu
 */
public class TableList extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene scene;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("/tablelist/FXML.fxml")));
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
