package test;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class RowController {
    @FXML private HBox rowRoot;
    @FXML private ComboBox<String> type;
    @FXML private ComboBox<String> category;
    @FXML private TextField damage;
    @FXML private PrimaryController controller;

    @FXML private int id;

    private Attack attack = new Attack();

    public String getData() {
        return damage.getText() + " " + type.getValue();
    }

    public void setValueDropdownType(String t)
    {
        type.setValue(t);
    }

    public ComboBox<String> getType()
    {
        return type;
    }

    public int getId()
    {
        return id;
    }

    public void SetController(PrimaryController c)
    {
        controller = c;
    }

    public void link(Attack a) {
        this.attack = a;
        type.valueProperty().bindBidirectional(this.attack.typeProperty());
        category.valueProperty().bindBidirectional(this.attack.nameProperty());
        damage.textProperty().bindBidirectional(this.attack.damageProperty());
    }

    @FXML
    private void handleRemoveRow() {
        Pane parent = (Pane) rowRoot.getParent();
        controller.delete(this.attack);

        if (parent != null) {
            parent.getChildren().remove(rowRoot);
        }

    }
}