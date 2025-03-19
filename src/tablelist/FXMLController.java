/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author devvu
 */
public class FXMLController implements Initializable {

    @FXML
    private StackPane pan;
    @FXML
    private Button btnPrint;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        FXVulembereList list = new FXVulembereList();
        list.setSize(10, 200, 100, 100, 300, 200);
        list.setSeparatorVertical(true);
        ArrayList<ArrayList<String>> data = getListe_data();
        ScrollPane ScrollPane = list.getList(data, "Liste");

        pan.getChildren().add(ScrollPane);

        btnPrint.setOnAction((event) -> {
            try {
                TablePrint.Print(data);
            } catch (Exception ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public static ArrayList getListe_data() {
        ArrayList<ArrayList<String>> data = new ArrayList();
        for (int i = 0; i < 15; i++) {
            ArrayList<String> data_ = new ArrayList();
            data_.add(i + "");
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
