package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class AskrifandiDialog extends Dialog<Player> {
    @FXML
    private TextField userInput_ID;
    @FXML
    private ColorPicker colorInput_ID;


    /**
     * Establishes the dialog. Creates the logic for the dialog.
     */
    AskrifandiDialog() {
        super();
        setDialogPane(readAskrifandiDialog());

        setResultConverter(dialogButton -> {
            if (dialogButton.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return new Player(userInput_ID.getText(), colorInput_ID.getValue());
            } else {
                return null;
            }
        });
    }

    /**
     * Loads the fxml file and returns it.
     * @return DialogPane
     */
    private DialogPane readAskrifandiDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("askrifandi-view.fxml"));
        fxmlLoader.setController(this);

        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Shows the dialog and waits for the result.
     * @return Askrifandi or null
     */
    public Player getAskrifandi() {
        Optional<Player> result = showAndWait();
        return result.orElse(null);
    }

}
