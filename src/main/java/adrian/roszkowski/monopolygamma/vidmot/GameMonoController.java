package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class GameMonoController {
    Game game;
    @FXML
    private AnchorPane Board_ID;
    @FXML
    private BoardController Board_IDController;
    @FXML
    private Button nextTurnButton_ID;
    @FXML
    private Label CharacterInfoText_ID;
    @FXML
    private Label HistoryText_ID;

    ChangeListener<Number> updateCharacterInfoListener = (observable, oldValue, newValue) -> updateCharacterInfo();


    /**
     * Calls the necessary methods to initialize the game.
     *
     * Binds the next turn button to the game, making sure that the player has completed all their rolls.
     */
    @FXML
    public void initialize(){
        game = new Game();
        game.setPlayers(Game.getPlayerList());

        Board_IDController.createPlayers(Game.getPlayerList());
        Board_IDController.setGame(game);
        updateCharacterInfo();

        game.getActivePlayer().getMoney().addListener(updateCharacterInfoListener);
        game.getActivePlayer().getPosition().addListener(updateCharacterInfoListener);
        nextTurnButton_ID.disableProperty().bind(Board_IDController.GetIsRolled().not());
    }

    @FXML
    public void OnNextTurn(ActionEvent e){
        game.getActivePlayer().getMoney().removeListener(updateCharacterInfoListener);
        game.getActivePlayer().getPosition().removeListener(updateCharacterInfoListener);
        game.nextTurn();
        Board_IDController.nextTurn();
        updateCharacterInfo();
        game.getActivePlayer().getMoney().addListener(updateCharacterInfoListener);
        game.getActivePlayer().getPosition().addListener(updateCharacterInfoListener);
    }

    public void updateCharacterInfo(){
        Player activePlayer = game.getActivePlayer();

        CharacterInfoText_ID.setText(new String(
                activePlayer.getName() + "\n" +
                        "Money: " + activePlayer.getMoney().get() + "\n" +
                        "Position: " + activePlayer.getPosition().get()
        ));
    }

}
