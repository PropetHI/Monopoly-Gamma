package adrian.roszkowski.monopolygamma.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class BoardController {

    @FXML
    AnchorPane BoardAP_ID;
    @FXML
    ImageView DiceImageContainerLeft_ID;
    @FXML
    ImageView DiceImageContainerRight_ID;

    Random random = new Random();

    boolean isRolled = false;

    public void initialize() {
        for (Node r : BoardAP_ID.getChildren()) {
            if (!(r instanceof Rectangle))
                continue;
            System.out.println(r.getId());
        }
    }

    @FXML
    public void OnRollDice(ActionEvent e){
        DiceImageContainerLeft_ID.getStyleClass().clear();
        DiceImageContainerRight_ID.getStyleClass().clear();

        int number = random.nextInt(6) + 1;
        DiceImageContainerRight_ID.getStyleClass().add("Dice" + number);

        int number2 = random.nextInt(6) + 1;
        DiceImageContainerLeft_ID.getStyleClass().add("Dice" + number2);
        int timesPaired = 0;

        System.out.println(number + " " + number2);

        if (number != number2) {
            isRolled = true;
        }
        else {
            timesPaired++;
            isRolled = false;
        }
    }
}
