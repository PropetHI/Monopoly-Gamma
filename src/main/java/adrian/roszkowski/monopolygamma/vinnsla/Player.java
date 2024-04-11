package adrian.roszkowski.monopolygamma.vinnsla;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class Player extends SimpleObjectProperty<Player> {

    private String name;
    private int money;
    private int position;

    private Color color;

    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public Player(String name) {
        this.name = name;
        money = 1500;
        position = 0;
    }

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        money = 1500;
        position = 0;
    }

    public Color getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name;
    }
}
