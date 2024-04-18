package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import adrian.roszkowski.monopolygamma.vinnsla.Player;

import java.io.IOException;

public class TileUI extends Rectangle {

    String name;
    boolean purchasable;
    int[] pricePerLevel;
    int[] rentPerLevel;

    Color originalColor = Color.DODGERBLUE;

    Player owner = new Player("NONEXISTENT");

    public TileUI() {
        super();
//        load();
    }

    public TileUI(double x, double y) {
        super(x, y);
//        load();
    }

    public TileUI(double x, double y, double width, double height) {
        super(x, y, width, height);
//        load();
    }

    /**
     * REDUNDANT: Handles loading the FXML File
     */
    void load() {
        FXMLLoader fxmlLoader = new FXMLLoader(GameMonoController.class.getResource("TileUI-view.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void initialize(String name, int[] pricePerLevel, int[] rentPerLevel, boolean purchasable) {
        this.name = name;
        this.pricePerLevel = pricePerLevel;
        this.rentPerLevel = rentPerLevel;
        this.purchasable = purchasable;

    }

    public void readTileUI(TileUI tileUI) {
        this.name = tileUI.name;
        this.pricePerLevel = tileUI.pricePerLevel;
        this.rentPerLevel = tileUI.rentPerLevel;
        this.purchasable = tileUI.purchasable;
    }


    public void setOwner(Player _owner) {
        this.owner.set(_owner);
        this.setFill(_owner.getColor());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalColor(Color originalColor) {
        this.originalColor = originalColor;
    }

    public void setPricePerLevel(int[] pricePerLevel) {
        this.pricePerLevel = pricePerLevel;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public void setRentPerLevel(int[] rentPerLevel) {
        this.rentPerLevel = rentPerLevel;
    }


    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public int[] getPricePerLevel() {
        return pricePerLevel;
    }

    public int[] getRentPerLevel() {
        return rentPerLevel;
    }

    public Color getOriginalColor() {
        return originalColor;
    }
}
