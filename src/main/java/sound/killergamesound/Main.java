package sound.killergamesound;

import communications.ConnectionController;
import sound.killergamesound.SoundController.SoundHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ConnectionController connectionController = new ConnectionController();
        SoundHandler soundHandler = new SoundHandler();
        connectionController.setCommListener(soundHandler);
        connectionController.initialize();
    }
}