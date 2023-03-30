/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author devvu
 */
public class TableList extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        FXVulembereList list = new FXVulembereList();
        
        StackPane pan = new StackPane();
        list.setColumn("ID", "NAME", "PHONE", "AGE", "STATUS","DATE DE NAISSANCE");
        list.setSize(10, 200, 100, 100,300,200); 
        list.setSeparatorVertical(true);
        pan.getChildren().add(list.getList(getListe_data()));
        
        
        root.getChildren().add(pan);
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static ArrayList getListe_data() {
        ArrayList<ArrayList<String>> data = new ArrayList();
        for (int i = 0; i < 30; i++) {
            ArrayList<String> data_ = new ArrayList();
            data_.add("0101");
            data_.add("WILLSON");
            data_.add("+243990084881");
            data_.add("93 Ans");
            data_.add("MARIE");
            data_.add("02-04-1995");
            data.add(data_);
        }
        
        return data;
    }
    
}
