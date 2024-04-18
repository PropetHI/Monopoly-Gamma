package adrian.roszkowski.monopolygamma.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class Player extends SimpleObjectProperty<Player> {

    private String name;
    private IntegerProperty money;
    private IntegerProperty position;

    private Color color;

    public void setMoney(int money) {
        this.money.set(money);
    }
    public IntegerProperty getMoney() {
        return money;
    }

    public Player(String name) {
        this.name = name;
        money = new SimpleIntegerProperty(1500);
        position = new SimpleIntegerProperty(0);
    }

    public Player(String name, Color color) {
        System.out.println("Creating player: " + name
                + " with color: " + color.toString());
        this.name = name;
        this.color = color;
        money = new SimpleIntegerProperty(1500);
        position = new SimpleIntegerProperty(0);
    }

    public Color getColor() {
        return color;
    }

    public IntegerProperty getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position.set(position);
    }

    @Override
    public String toString() {
        return name;
    }
}
