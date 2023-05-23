package sound.killergamesound.SoundModel;

public class EventSound {
    private static final String SOUNDS_DIR = "src/Sounds/";
    private final SoundFile laser;
    //private final SoundFile explosion;
    //private final SoundFile laser;
    //private final SoundFile laser;


    // Constructor que carga los sonidos normales
    public EventSound() {
        this.laser = new SoundFile(SoundType.LASER);
    }

    // Método que reproduce el sonido correspondiente al tipo de sonido recibido
    public void playSound(SoundType soundType) {
        try {
            switch (soundType) {
                case LASER -> laser.startAudio();
                //case EXPLOSION -> explosion.startAudio();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

