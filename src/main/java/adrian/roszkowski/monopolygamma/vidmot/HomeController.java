package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class HomeController {

    Game game;

    @FXML
    private ListView<Player> playerList_ID;
    @FXML
    private Button playButton_ID;

    /**
     * Initializes the game. Adds rules to prevent a 0 player game. Permits 1 player for testing purposes.
     */
    @FXML
    void initialize(){
        game = new Game();
        game.getPlayerList().addListener((ListChangeListener<Player>) change -> {
            playerList_ID.getItems().setAll(game.getPlayerList());
            if (game.getPlayerList().size() > 0) playButton_ID.setDisable(false);
            else playButton_ID.setDisable(true);
        });
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