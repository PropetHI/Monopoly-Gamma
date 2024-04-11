package adrian.roszkowski.monopolygamma.vidmot;

import adrian.roszkowski.monopolygamma.vinnsla.Game;
import adrian.roszkowski.monopolygamma.vinnsla.Player;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Random;

public class BoardController {

    @FXML
    AnchorPane BoardAP_ID;
    @FXML
    ImageView DiceImageContainerLeft_ID;
    @FXML
    ImageView DiceImageContainerRight_ID;
    @FXML
    Button DiceButton_ID;

    Random random = new Random();

    Game game;

    ObservableList<TileUI> tiles = FXCollections.observableArrayList();
    ObservableList<Rectangle> playerModels = FXCollections.observableArrayList();

    BooleanProperty isRolled = new SimpleBooleanProperty(false);
    int timesPaired = 0;

    /**
     * Initializes the game with the board. Adds information to the tiles.
     *
     * TODO: Switch to JSON Format
     */
    public void initialize() {
        for (Node r : BoardAP_ID.getChildren()) {
            if (!(r instanceof TileUI))
                continue;
            switch (r.getId()) {
                case "Tile0":
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            false
                    );
                    break;
                case "Tile9":
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            false
                    );
                    break;
                case "Tile18":
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            false
                    );
                    break;
                case "Tile27":
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            false
                    );
                    break;
                case "Tile36":
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            false
                    );
                    break;
                default:
                    ((TileUI) r).initialize(
                            "Placeholder",
                            new int[] {150, 0, 0, 0, 0},
                            new int[] {50, 0, 0, 0, 0},
                            true
                    );
                    break;
            }

            tiles.add((TileUI) r);
        }
        DiceButton_ID.disableProperty().bind(isRolled);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean inBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }

    /**
     * Calculates the position of the player on the board after moving
     * @param player The player
     * @param position His "position" in the index
     */
    public void movePlayer(Player player, int position) {
        Rectangle rectangle = playerModels.get(position);
        Node tileLocation = tiles.get(player.getPosition());
        switch (player.getPosition()) {
            case 0:
                movePlayerCorner(position, rectangle, tileLocation);
                break;
            case 9:
                movePlayerCorner(position, rectangle, tileLocation);
                break;
            case 18:
                movePlayerCorner(position, rectangle, tileLocation);
                break;
            case 27:
                movePlayerCorner(position, rectangle, tileLocation);
                break;
        }
        if (inBetween(player.getPosition(), 1, 8)){
            rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() / 2 + 25 * position);
            rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() / 2);
        }
        else if (inBetween(player.getPosition(), 10, 17)){
            rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() / 2);
            rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() / 2 + 25 * position);
        }
        else if (inBetween(player.getPosition(), 19, 26)){
            rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() / 2 - 25 * position);
            rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() / 2);
        }
        else if (inBetween(player.getPosition(), 28, 36)){
            rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() / 2);
            rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() / 2 - 25 * position);
        }
    }

    /**
     * Handles movement to the corner tiles specificially
     * @param position the index of the player
     * @param rectangle the player model
     * @param tileLocation the tile to move to
     */
    private static void movePlayerCorner(int position, Rectangle rectangle, Node tileLocation) {
        switch (position){
            case 0:
                rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() - 10);
                rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() - 10);
                break;
            case 1:
                rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 + rectangle.getWidth() - 10);
                rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() - 10);
                break;
            case 2:
                rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() - 10);
                rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 + rectangle.getHeight() - 10);
                break;
            case 3:
                rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 + rectangle.getWidth() - 10);
                rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 + rectangle.getHeight() - 10);
                break;
            default:
                rectangle.setLayoutX(tileLocation.getLayoutX() + tileLocation.getBoundsInParent().getWidth() / 2 - rectangle.getWidth() - 10);
                rectangle.setLayoutY(tileLocation.getLayoutY() + tileLocation.getBoundsInParent().getHeight() / 2 - rectangle.getHeight() - 10);
                break;
        }
    }

    /**
     * Creates player models
     * @param players The players
     */
    public void createPlayers(ObservableList<Player> players) {
        players.forEach(player -> {
            Rectangle rectangle = new Rectangle(25, 25, player.getColor());
            playerModels.add(rectangle);
            BoardAP_ID.getChildren().add(rectangle);
            rectangle.toFront();
            movePlayer(player, players.indexOf(player));
//            rectangle.setX(rectangles.get(0).getLayoutX() + 25);
//            rectangle.setY(rectangles.get(0).getLayoutY() + 25);
        });
    }

    /**
     * Handles rolling the dice and calling to move the player
     * @param e unused
     */
    @FXML
    public void OnRollDice(ActionEvent e){
        DiceImageContainerLeft_ID.getStyleClass().clear();
        DiceImageContainerRight_ID.getStyleClass().clear();

        int number = random.nextInt(6) + 1;
        DiceImageContainerRight_ID.getStyleClass().add("Dice" + number);

        int number2 = random.nextInt(6) + 1;
        DiceImageContainerLeft_ID.getStyleClass().add("Dice" + number2);

        if (number != number2) {
            isRolled.set(true);
        }
        else {
            timesPaired++;
            isRolled.set(false);
        }

        int newPosition = game.getActivePlayer().getPosition() + number + number2;
        if (newPosition >= tiles.size()){
            int value = newPosition - tiles.size();
            game.getActivePlayer().setPosition(value);
        }
        else {
            game.getActivePlayer().setPosition(newPosition);
        }
        movePlayer(game.getActivePlayer(), game.getActivePlayerIndex());

        try {
            TilePopupWindow popupWindow = new TilePopupWindow();
            popupWindow.display(tiles.get(game.getActivePlayer().getPosition()), game.getActivePlayer());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println(game.getActivePlayer().getPosition() + " after ");
    }

    public BooleanProperty GetIsRolled() {
        return isRolled;
    }

    public void nextTurn(){
        isRolled.set(false);
    }
}
