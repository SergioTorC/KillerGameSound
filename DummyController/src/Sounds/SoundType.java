package Sounds; /**
 * The Sounds.SoundType enum represents the types of sounds in the game.
 * Each enum constant specifies the file name of the corresponding sound.
 * It implements the Serializable interface to allow for object serialization.
 */

import java.io.Serializable;

public enum SoundType implements Serializable {
    EXPLOSION("explosion.mp3"),
    LASER("laser.mp3"),
    HIT("hit.mp3");

    private final String fileName;

    /**
     * Constructor for the Sounds.SoundType enum.
     * Initializes the enum constant with the specified file name.
     * @param fileName The file name of the sound.
     */
    SoundType(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the file name of the sound.
     * @return The file name.
     */
    public String getFileName() {
        return fileName;
    }
}
