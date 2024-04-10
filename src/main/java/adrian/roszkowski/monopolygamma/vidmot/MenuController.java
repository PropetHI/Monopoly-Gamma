package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MenuController {

    @FXML
    HomeController gameController;

    public void initialize() {
    }

    @FXML
    protected void OnStart(ActionEvent event) {
        ViewSwitcher.switchTo(View.HOME);
        Game.cleanseGame();
    }

    @FXML
    protected void OnClose(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> Platform.exit());
    }

    /**
     * Creates a dialog with basic information about the game.
     * @param event is not used
     */
    @FXML
    protected void OnAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("This is a small replication of the Original Monopoly made with Javafx for the class HBV201G.\n" +
                "Made by Adrian Roszkowski in 2024/04.");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> alert.close());
    }
}
