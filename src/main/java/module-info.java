module local.commandpattern {
    requires javafx.controls;
    requires javafx.fxml;


    opens local.commandpattern to javafx.fxml;
    exports local.commandpattern;
}