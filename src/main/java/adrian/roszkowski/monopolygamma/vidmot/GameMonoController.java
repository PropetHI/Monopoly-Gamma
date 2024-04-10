package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.Random;

public class GameMonoController {
    Game game;


    @FXML
    public void initialize(){
        game = new Game();
        game.setPlayers(Game.getPlayerList());
    }



}
