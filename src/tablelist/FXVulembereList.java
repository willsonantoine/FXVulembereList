/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author devvu
 */
public class FXVulembereList {

    private int[] size;
    private List<String> column;
    private boolean separatorHorizontal;
    private boolean separatorVertical;
    private int space;

    public ScrollPane getList(ArrayList<ArrayList<String>> data) {

        System.out.println(data);
        VBox list = new VBox();
        list.setFocusTraversable(false);
        list.setPrefWidth(Region.USE_COMPUTED_SIZE);
        this.column = data.get(0);
        if (data.size() > 0) {
            if (this.getColumn().size() == this.getSize().length) {

                for (int i = 0; i < data.size(); i++) {
                    List<String> row = data.get(i);
                    list.getChildren().add(boxColmun(row));
                    if (this.isSeparatorHorizontal()) {
                        list.getChildren().add(new Separator(Orientation.HORIZONTAL));
                    }

                }
            } else {
                throw new Error("La liste des colonnes et la liste des tailles doivent être de la même taille.");
            }
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(list);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color:white;");

        return scrollPane;
    }
 
    private int color_alternance = 0;

    public HBox boxColmun(List<String> row) {
        HBox box = new HBox(5);
        box.setId(row.get(0));
        box.setSpacing(space);
        box.setPrefWidth(Region.USE_COMPUTED_SIZE);
        box.setPrefHeight(20);
        int x = 0;
        for (String colone : row) {
            Label lab = new Label(colone);
            lab.setPrefWidth(this.size[x]);
            lab.setPrefHeight(20);

            box.getChildren().add(lab);
            lab.prefWidthProperty().bind(box.widthProperty());
            if (this.isSeparatorVertical()) {
                box.getChildren().add(new Separator(Orientation.VERTICAL));
            }
            x++;
        }

        HBox.setHgrow(box, Priority.ALWAYS);
        box.setFillHeight(true);
        if (color_alternance == 0) {
            box.setStyle("-fx-background-color:#E9EFF8;;-fx-font-size: 15");
            color_alternance = 1;
        } else {
            box.setStyle("-fx-background-color:#FFFFFF;;-fx-font-size: 15");
            color_alternance = 0;
        }

        return box;
    }

    /**
     *
     * @param rqt la requette sql
     * @param parametresStrings La liste des parametres exemple {string2,sting2}
     * @return
     */
    public ArrayList getListe_data(ResultSet rs) {
        ArrayList<ArrayList<String>> data = new ArrayList();
        int x = 1;
        try {

            ResultSetMetaData rsm = rs.getMetaData();
            ArrayList<String> col = new ArrayList();
            col.add("N °");
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                col.add(rsm.getColumnLabel(i));
            }
            data.add(col);

            while (rs.next()) {

                ArrayList<String> ob = new ArrayList();
                ob.add(x + "");
                ResultSetMetaData m = rs.getMetaData();
                for (int i = 1; i <= m.getColumnCount(); i++) {
                    ob.add(rs.getString(m.getColumnLabel(i)));
                }

                data.add(ob);
                x++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXVulembereList.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int... size) {
        this.size = size;
    }

    public List<String> getColumn() {
        return column;
    }

    public void setColumn(List<String> column) {
        this.column = column;
    }

    public boolean isSeparatorHorizontal() {
        return separatorHorizontal;
    }

    public void setSeparatorHorizontal(boolean separatorHorizontal) {
        this.separatorHorizontal = separatorHorizontal;
    }

    public boolean isSeparatorVertical() {
        return separatorVertical;
    }

    public void setSeparatorVertical(boolean separatorVertical) {
        this.separatorVertical = separatorVertical;
    }

    public int isSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

}
