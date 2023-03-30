/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablelist;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;

/**
 *
 * @author devvu
 */
public class FXVulembereList {

    private int[] size;
    private String[] column;
    private boolean separatorHorizontal;
    private boolean separatorVertical;
    private int space;

    public ListView getList(ArrayList<List<String>> data) {
        ListView list = new ListView();
        list.setFocusTraversable(false);
        list.getItems().add(boxColmun(getColumn()));  
        if (this.getColumn().length == this.getSize().length) {

            for (int i = 0; i < data.size(); i++) {
                List<String> row = data.get(i);
                list.getItems().add(boxColmun(row));
                if (this.isSeparatorHorizontal()) {
                    list.getItems().add(new Separator(Orientation.HORIZONTAL));
                }

            }
        } else {
            throw new Error("La liste des colonnes et la liste des tailles doivent être de la même taille.");
        }

        return list;
    }

    public HBox boxColmun(String[] colones) {
        HBox box = new HBox(5);
        for (String colone : colones) {
            Label lab = new Label(colone);
            lab.setPrefSize(100, 20);
            box.getChildren().add(lab);
              box.setSpacing(space);
            if (this.isSeparatorVertical()) {
                box.getChildren().add(new Separator(Orientation.VERTICAL));
            }

        }

        return box;
    }

    public HBox boxColmun(List<String> row) {
        HBox box = new HBox(5);
        for (String colone : row) {
            Label lab = new Label(colone);
            lab.setPrefSize(100, 20);
            box.getChildren().add(lab); 
            box.setSpacing(space);
            if (this.isSeparatorVertical()) {
                box.getChildren().add(new Separator(Orientation.VERTICAL));
            }
        }

        return box;
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int... size) {
        this.size = size;
    }

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String... column) {
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
