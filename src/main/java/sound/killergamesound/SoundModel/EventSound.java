/**
 * The EventSound class represents an event sound in the game.
 * It implements the Serializable interface to allow for object serialization.
 */
package sound.killergamesound.SoundModel;

public class EventSound {
    private final SoundFile laser;
    private final SoundFile explosion;
    private final SoundFile hit;

    /**
     * Constructor for the EventSound class.
     * Initializes the laser and explosion SoundFile objects.
     */
    public EventSound() {
        this.explosion = new SoundFile(SoundType.EXPLOSION);
        this.laser = new SoundFile(SoundType.LASER);
        this.hit = new SoundFile(SoundType.HIT);
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
                case HIT -> hit.startAudio();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
