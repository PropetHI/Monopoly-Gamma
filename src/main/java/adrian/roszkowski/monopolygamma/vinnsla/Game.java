package adrian.roszkowski.monopolygamma.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Game {
    Tile[] tiles = new Tile[36];

    static ObservableList<Player> playerList = FXCollections.observableArrayList();

    javafx.beans.property.IntegerProperty activePlayerIndex = new javafx.beans.property.SimpleIntegerProperty(0);

    public void nextTurn() {
        if (activePlayerIndex.get() < playerList.size() - 1) {
            activePlayerIndex.set(activePlayerIndex.get() + 1);
        } else {
            activePlayerIndex.set(0);
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
        return activePlayerIndex.get();
    }

    public javafx.beans.property.IntegerProperty getActivePlayerIndexProperty(){
        return activePlayerIndex;
    }

    public Player getActivePlayer() {
        return playerList.get(activePlayerIndex.get());
    }

    public static void cleanseGame(){
        playerList.clear();
    }


}
