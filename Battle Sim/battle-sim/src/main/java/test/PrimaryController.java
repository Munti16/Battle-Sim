package test;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryController {

    private ItemController itemController = App.getItemController();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML private VBox rowContainer;

    @FXML
    private void handleAddRow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RowItem.fxml"));
            HBox newRow = loader.load();
            
            RowController rowController = (RowController) loader.getController();
            rowController.SetController(this);

            Attack newAttack = new Attack(null, null, null); 
            itemController.getAttacks().add(newAttack);

            rowController.link(newAttack);

            rowContainer.getChildren().add(newRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleAddRow(String type, String damage) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RowItem.fxml"));
        HBox newRow = loader.load();
        RowController rowController = loader.getController();

        Attack newAttack = new Attack("", "", ""); 
        
        itemController.getAttacks().add(newAttack);

        rowController.link(newAttack);

        rowContainer.getChildren().add(newRow);
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Attack a)
    {
        for (int i = 0; i < itemController.getSize(); i++) {
            if (itemController.getAttack(i) == a) {
                itemController.removeAttack(i);
            }
        }
    }

    @FXML
    public void initialize() {
        if (rowContainer != null) {
            List<Attack> attacks = itemController.getAttacks();
            for (Attack attack : attacks) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("RowItem.fxml"));
                    HBox row = loader.load();
                    
                    RowController controller = (RowController) loader.getController();
                    controller.SetController(this);
                    controller.link(attack);
                    
                    rowContainer.getChildren().add(row);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
