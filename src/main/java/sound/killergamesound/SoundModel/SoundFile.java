package sound.killergamesound.SoundModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class SoundFile {
    private final MediaPlayer mediaPlayer;
    private static final String SOUNDS_DIR = "Sounds/";

    public SoundFile(SoundType soundType) {
        String soundFile = SOUNDS_DIR + soundType.getFileName();
        Media media = new Media(new File(soundFile).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
    }


    public void startAudio() {
        try {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.stop(); // Detener la reproducción si está en ejecución
            }
            mediaPlayer.seek(mediaPlayer.getStartTime()); // Reiniciar la posición al inicio
            mediaPlayer.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
