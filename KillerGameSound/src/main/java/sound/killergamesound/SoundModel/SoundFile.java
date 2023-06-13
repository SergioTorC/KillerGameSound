/**
 * The SoundFile class represents a sound file in the game.
 * It uses JavaFX MediaPlayer to play the audio.
 */
package sound.killergamesound.SoundModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundFile {
    private final MediaPlayer mediaPlayer;
    private static final String SOUNDS_DIR = "Sounds/";

    /**
     * Constructor for the SoundFile class.
     * Initializes the MediaPlayer with the specified sound file.
     * @param soundType The type of sound file to load.
     */
    public SoundFile(SoundType soundType) {
        String soundFile = SOUNDS_DIR + soundType.getFileName();
        Media media = new Media(new File(soundFile).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
    }

    /**
     * Starts playing the audio file.
     * If the audio is already playing, it stops and restarts from the beginning.
     */
    public void startAudio() {
        try {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.stop();
            }
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
