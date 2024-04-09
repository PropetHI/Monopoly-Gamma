package adrian.roszkowski.monopolygamma.vinnsla;

public class Game {
    Tile[] tiles = new Tile[40];
    Player[] players = new Player[4];

    int activePlayerIndex = 0;

    void nextTurn() {
        if (activePlayerIndex < players.length - 1) {
            activePlayerIndex++;
        } else {
            activePlayerIndex = 0;
        }
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }


}
