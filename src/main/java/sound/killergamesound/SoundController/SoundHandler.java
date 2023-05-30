package sound.killergamesound.SoundController;


import communications.P2PCommListener;
import sound.killergamesound.SoundModel.BackgroundSound;
import sound.killergamesound.SoundModel.EventSound;
import sound.killergamesound.SoundModel.SoundType;

public class SoundHandler implements P2PCommListener {
    BackgroundSound backgroundSound;
    EventSound eventSound;

    public SoundHandler() {
        backgroundSound = new BackgroundSound();
        eventSound = new EventSound();
    }

    public void recieveObject(Object message) {
        System.out.println(message);
        if (message.equals("LASER")) {
            eventSound.playSound(SoundType.LASER);
        } else if (message.equals("CALM")) {
            backgroundSound.reproduceCalm();
        } else if (message.equals("COMBAT")) {
            backgroundSound.reproduceCombat();
        } else if (message.equals("EXPLOSION")){
            eventSound.playSound(SoundType.EXPLOSION);
        }
    }

    @Override
    public void onIncomingMessage(String ip, Object message) {
        recieveObject(message);
    }

    @Override
    public void onConnectionClosed(String ip) {

    }

    @Override
    public void onConnectionLost(String ip) {

    }

    @Override
    public void onNewConnection(String ip) {

    }
}
