/**
 * The Main class is the entry point of the application.
 * It extends the JavaFX Application class and defines the main method.
 * It initializes the connection controller and sound handler, and sets the sound handler as the communication listener.
 */
package sound.killergamesound.Main;

import communications.ConnectionController;
import sound.killergamesound.SoundController.SoundHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application by calling the launch method.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is called when the application is launched.
     * It initializes the connection controller and sound handler, and sets the sound handler as the communication listener.
     * @param primaryStage The primary stage of the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        ConnectionController connectionController = new ConnectionController();
        SoundHandler soundHandler = new SoundHandler();
        connectionController.setCommListener(soundHandler);
        connectionController.initialize();
    }
}
