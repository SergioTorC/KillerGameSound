module sound.killergamesound {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires connections;


    opens sound.killergamesound to javafx.fxml;
    exports sound.killergamesound;
    exports sound.killergamesound.Main;
    opens sound.killergamesound.Main to javafx.fxml;
}