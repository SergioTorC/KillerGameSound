package sound.killergamesound.SoundController;


import communications.P2PCommListener;
import sound.killergamesound.SoundModel.BackgroundSound;
import sound.killergamesound.SoundModel.EventSound;
import sound.killergamesound.SoundModel.MusicType;
import sound.killergamesound.SoundModel.SoundType;

public class SoundHandler implements P2PCommListener {
    BackgroundSound backgroundSound;
    EventSound eventSound;

    public SoundHandler() {
        backgroundSound = new BackgroundSound();
        eventSound = new EventSound();
        //backgroundSound.reproduceCombat();
    }

    public void recieveObject(Object message) {
        System.out.println(message);
        if (message.equals("UP")) {
            eventSound.playSound(SoundType.LASER);
        } else if (message.equals("LEFT")) {
            backgroundSound.reproduceCalm();
        } else if (message.equals("RIGHT")) {
            backgroundSound.reproduceCombat();
        } else if (message.equals("DOWN")){
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
