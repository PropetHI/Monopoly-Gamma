module adrian.roszkowski.monopolygamma {
    requires javafx.controls;
    requires javafx.fxml;


    opens adrian.roszkowski.monopolygamma to javafx.fxml;
    exports adrian.roszkowski.monopolygamma;
    exports adrian.roszkowski.monopolygamma.vidmot;
    opens adrian.roszkowski.monopolygamma.vidmot to javafx.fxml;
}