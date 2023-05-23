package sound.killergamesound.SoundModel;

public enum SoundType {
    //EXPLOSION("explosion.wav"),
    LASER("laser.wav");

    private final String fileName;

    SoundType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}