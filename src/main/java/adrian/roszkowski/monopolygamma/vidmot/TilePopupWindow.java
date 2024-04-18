package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TilePopupWindow {

    static boolean answer;

    TileUI tileProperty;

    @FXML
    Label TileName_ID;
    @FXML
    Label PricePerLevelText_ID;
    @FXML
    Label RentPerLevelText_ID;
    @FXML
    Button BuyPropertyTileButton_ID;
    @FXML
    Button SellButton_ID;

    Player player;



    public void initialize_Called() {
        BuyPropertyTileButton_ID.disableProperty().bind((new SimpleBooleanProperty(tileProperty.getOwner() == null).not()));
        SellButton_ID.disableProperty().bind(isEqual(player, tileProperty.getOwner()));

        TileName_ID.setText(tileProperty.getName());

        PricePerLevelText_ID.setText("Price per level: " + tileProperty.getPricePerLevel()[0]);

        RentPerLevelText_ID.setText("Rent per level: " + tileProperty.getRentPerLevel()[0]);
    }

    public void initialize_Called(TileUI tile, Player _player) {
        tileProperty = tile;
        player = _player;


        TileName_ID.setText(tileProperty.getName());

        PricePerLevelText_ID.setText("Price per level: " + tileProperty.getPricePerLevel()[0]);

        RentPerLevelText_ID.setText("Rent per level: " + tileProperty.getRentPerLevel()[0]);



        if(tileProperty.getOwner().getName().equals("NONEXISTENT")) {
            SellButton_ID.setDisable(true);
            BuyPropertyTileButton_ID.setDisable(false);
        } else if (tileProperty.getOwner().getName().equals(player.getName())) {
            SellButton_ID.setDisable(false);
            BuyPropertyTileButton_ID.setDisable(true);
        }

        if (!tileProperty.getOwner().equals(player) && !tileProperty.getOwner().getName().equals("NONEXISTENT")) {
            System.out.println("DESTA");
            BuyPropertyTileButton_ID.setDisable(true);
            SellButton_ID.setDisable(true);
            player.setMoney(player.getMoney().get() - tileProperty.getPricePerLevel()[0]);
            return;
        }

//        BuyPropertyTileButton_ID.disableProperty().bind((new SimpleBooleanProperty(tileProperty.getOwner() == null).not()));
//        SellButton_ID.disableProperty().bind(isEqual(player, tileProperty.getOwner()).not());
        tileProperty.getOwner().addListener((obs, old, newval) -> {
            if(newval.getName().equals("NONEXISTENT")) {
                SellButton_ID.setDisable(true);
                BuyPropertyTileButton_ID.setDisable(false);
            } else if (Objects.equals(newval.getName(), player.getName())) {
                System.out.println(player.getName());
                SellButton_ID.setDisable(false);
                BuyPropertyTileButton_ID.setDisable(true);
            }
        });

    }

    SimpleBooleanProperty isEqual(Object o1, Object o2) {
        return new SimpleBooleanProperty(Objects.equals(o1, o2));
    }

    /**
     * Displays a popup window.
     *
     * @param tile Tile information to display
     * @param _player The player who landed on the tile.
     * @return Modified tile information.
     * @throws IOException If the fxml loading fails.
     *
     *      Inspired / based on: http://www.learningaboutelectronics.com/Articles/How-to-communicate-between-windows-in-JavaFX.php
     *      Written by : UNKNOWN
     */
    public TileUI display(TileUI tile, Player _player) throws IOException {
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("TileUI-Popup-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 720);



        popupwindow.setScene(scene);

        TilePopupWindow controller = fxmlLoader.getController();
        controller.initialize_Called(tile, _player);
        popupwindow.showAndWait();


        return controller.tileProperty;
    }

    @FXML
    public void OnSellProperty() {
        if (player.getName().equals("NONEXISTENT")) {
            return;
        }
        System.out.println("Selling property");
        player.setMoney(player.getMoney().get() + (tileProperty.getPricePerLevel()[0] / 2));
        tileProperty.setOwner(new Player("NONEXISTENT"));
    }

    @FXML
    public void OnBuyProperty() {
        if (player.getMoney().get() < tileProperty.getPricePerLevel()[0]) {
            return;
        }
        player.setMoney(player.getMoney().get() - tileProperty.getPricePerLevel()[0]);
        tileProperty.setOwner(player);
    }
}



