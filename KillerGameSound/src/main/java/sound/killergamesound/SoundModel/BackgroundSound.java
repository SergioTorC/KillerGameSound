/**
 * The BackgroundSound class represents the background music in the game.
 * It uses JavaFX MediaPlayer to play the music.
 */
package sound.killergamesound.SoundModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundSound {
    private Boolean inCombat;
    private MediaPlayer mediaPlayer;
    private static final String SOUNDS_DIR = "Sounds/";

    /**
     * Constructor for the BackgroundSound class.
     * Initializes the inCombat flag as false.
     */
    public BackgroundSound() {
        this.inCombat = false;
        reproduceMenu();
    }

    /**
     * Plays the specified music.
     * Creates a new MediaPlayer with the given media and starts playing it.
     *
     * @param media The media object representing the music to play.
     */
    private void reproduceMusic(Media media) {
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(0.2); // Adjust the volume as needed
        new Thread(() -> {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setOnReady(mediaPlayer::play);
        }).start();
    }

    /**
     * Plays the combat music.
     * Stops the current music, loads the combat music file, and starts playing it.
     */
    public void reproduceCombat() {
        if (!inCombat) {
            stopMusic(getMediaPlayer());
            try {
                String combatMusicFile = SOUNDS_DIR + MusicType.COMBAT.getFileName();
                Media media = new Media(new File(combatMusicFile).toURI().toString());
                inCombat = true;
                reproduceMusic(media);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Plays the calm music.
     * Stops the current music, loads the calm music file, and starts playing it.
     */
    public void reproduceCalm() {
        if (inCombat) {
            stopMusic(getMediaPlayer());
            try {
                String calmMusicFile = SOUNDS_DIR + MusicType.CALM.getFileName();
                Media media = new Media(new File(calmMusicFile).toURI().toString());
                inCombat = false;
                reproduceMusic(media);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Plays the menu music.
     * Stops the current music, loads the menu music file, and starts playing it.
     */
    public void reproduceMenu() {
        stopMusic(getMediaPlayer());
        try {
            String menuMusicFile = SOUNDS_DIR + MusicType.MENU.getFileName();
            Media media = new Media(new File(menuMusicFile).toURI().toString());
            inCombat = false;
            reproduceMusic(media);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stops the specified MediaPlayer.
     * Stops and disposes the MediaPlayer to release resources.
     *
     * @param mediaPlayer The MediaPlayer to stop.
     */
    public void stopMusic(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }

    /**
     * Sets the MediaPlayer for the background music.
     *
     * @param mediaPlayer The MediaPlayer to set.
     */
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    /**
     * Returns the current MediaPlayer for the background music.
     *
     * @return The current MediaPlayer.
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
