package adrian.roszkowski.monopolygamma.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Game {
    Tile[] tiles = new Tile[36];

    static ObservableList<Player> playerList = FXCollections.observableArrayList();

    int activePlayerIndex = 0;

    void nextTurn() {
        if (activePlayerIndex < playerList.size() - 1) {
            activePlayerIndex++;
        } else {
            activePlayerIndex = 0;
        }
    }

    public void setPlayers(Player[] players) {
        playerList.setAll(players);
    }

    public void setPlayers(ObservableList<Player> players){
        playerList = players;
    }

    public void addPlayer(Player player){
        if (player == null) return;
        playerList.add(player);
    }

    public void removePlayer(Player player){
        playerList.remove(player);
    }

    public void removePlayer(){
        playerList.removeLast();
    }

    static public ObservableList<Player> getPlayerList(){
        return playerList;
    }

    public int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public Player getActivePlayer() {
        return playerList.get(activePlayerIndex);
    }

    public static void cleanseGame(){
        playerList.clear();
    }


}
