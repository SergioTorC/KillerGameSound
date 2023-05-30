/**
 * The EventSound class represents an event sound in the game.
 * It implements the Serializable interface to allow for object serialization.
 */
package sound.killergamesound.SoundModel;

import java.io.Serializable;

public class EventSound implements Serializable {
    private final SoundFile laser;
    private final SoundFile explosion;

    /**
     * Constructor for the EventSound class.
     * Initializes the laser and explosion SoundFile objects.
     */
    public EventSound() {
        this.explosion = new SoundFile(SoundType.EXPLOSION);
        this.laser = new SoundFile(SoundType.LASER);
    }

    /**
     * Plays the specified sound based on the given SoundType.
     * @param soundType The type of sound to play.
     */
    public void playSound(SoundType soundType) {
        try {
            switch (soundType) {
                case LASER -> laser.startAudio();
                case EXPLOSION -> explosion.startAudio();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
