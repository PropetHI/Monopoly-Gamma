module adrian.roszkowski.monopolygamma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    exports adrian.roszkowski.monopolygamma.vinnsla;
    opens adrian.roszkowski.monopolygamma.vinnsla to javafx.fxml;

    exports adrian.roszkowski.monopolygamma.vidmot;
    opens adrian.roszkowski.monopolygamma.vidmot to javafx.fxml;
}