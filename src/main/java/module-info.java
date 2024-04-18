module adrian.roszkowski.monopolygamma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;
    requires javafx.graphics;

    exports adrian.roszkowski.monopolygamma.vinnsla;
    opens adrian.roszkowski.monopolygamma.vinnsla to javafx.fxml, com.fasterxml.jackson.databind;

    exports adrian.roszkowski.monopolygamma.vidmot;
    opens adrian.roszkowski.monopolygamma.vidmot to javafx.fxml;

}