package adrian.roszkowski.monopolygamma.vinnsla;

public class Tile {
    String name;
    int initialPrice;
    int rent;

    int initialLvlUpPrice;
    int lvlUpCost;
    int level;

    int[] pricePerLevel = new int[5];

    public Tile(String name, int InitialPrice, int rent, int lvlUpCost, int[] pricePerLevel) {
        this.name = name;
        this.initialPrice = InitialPrice;
        this.rent = rent;
        this.lvlUpCost = lvlUpCost;
        level = 0;
        this.pricePerLevel = pricePerLevel;
    }

    void levelUp() {
        if (level < 5) {
            level++;
        }
    }
}
