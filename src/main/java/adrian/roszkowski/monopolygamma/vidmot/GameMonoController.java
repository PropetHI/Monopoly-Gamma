package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GameMonoController {
    Game game;

    @FXML
    public void initialize(){
        game = new Game();
        game.setPlayers(Game.getPlayerList());
    }

    @FXML
    public void OnRollDice(ActionEvent e){

    }


}
