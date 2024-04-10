package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public void initialize(){
        game = new Game();
        game.setPlayers(Game.getPlayerList());

        Board_IDController.createPlayers(Game.getPlayerList());
        Board_IDController.setGame(game);

        nextTurnButton_ID.disableProperty().bind(Board_IDController.GetIsRolled().not());
    }

    @FXML
    public void OnNextTurn(ActionEvent e){
        game.nextTurn();
        Board_IDController.nextTurn();
    }

}
