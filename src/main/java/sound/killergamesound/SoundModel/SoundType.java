package sound.killergamesound.SoundModel;

import java.io.Serializable;

public enum SoundType implements Serializable {
    EXPLOSION("explosion.mp3"),
    LASER("laser.mp3");

    private final String fileName;

    SoundType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}