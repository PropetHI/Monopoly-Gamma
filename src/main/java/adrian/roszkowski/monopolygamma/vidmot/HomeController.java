package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HomeController {

    Game game;

    @FXML
    private ListView<Player> playerList_ID;

    @FXML
    void initialize(){
        game = new Game();
        game.getPlayerList().addListener((ListChangeListener<Player>) change -> playerList_ID.getItems().setAll(game.getPlayerList()));
    }
    public HomeController(){

    }
    @FXML
    void OnPlay(){
        ViewSwitcher.switchTo(View.Game);
    }
    @FXML
    void OnAddPlayer(){
        AskrifandiDialog dialog = new AskrifandiDialog();
        game.addPlayer(dialog.getAskrifandi());
    }
    @FXML
    void OnRemovePlayer(){
        try {
            if(playerList_ID.getSelectionModel().getSelectedItem() == null) game.removePlayer();
            game.removePlayer(playerList_ID.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}