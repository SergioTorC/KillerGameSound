package Sounds; /**
 * The Sounds.MusicType enum represents the types of music in the game.
 * Each enum constant specifies the file name of the corresponding music.
 */

public enum MusicType {
    COMBAT("combat.mp3"),
    CALM("calm.mp3"),
    MENU("menu.mp3");

    private final String fileName;

    /**
     * Constructor for the Sounds.MusicType enum.
     * Initializes the enum constant with the specified file name.
     * @param fileName The file name of the music.
     */
    MusicType(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the file name of the music.
     * @return The file name.
     */
    public String getFileName() {
        return fileName;
    }
}
