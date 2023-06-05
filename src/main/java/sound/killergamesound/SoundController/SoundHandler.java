/**
 * Class that handles sounds in a game.
 * Implements the P2PCommListener interface to receive communication messages.
 */
package sound.killergamesound.SoundController;

import communications.P2PCommListener;
import sound.killergamesound.SoundModel.BackgroundSound;
import sound.killergamesound.SoundModel.EventSound;
import sound.killergamesound.SoundModel.MusicType;
import sound.killergamesound.SoundModel.SoundType;

public class SoundHandler implements P2PCommListener {
    BackgroundSound backgroundSound;
    EventSound eventSound;

    /**
     * Constructor for the SoundHandler class.
     * Create instances of BackgroundSound and EventSound.
     */
    public SoundHandler() {
        backgroundSound = new BackgroundSound();
        eventSound = new EventSound();
    }

    /**
     * Method that receives an object and performs actions based on the message content.
     * @param message Received object.
     */
    public void receiveObject(Object message) {
        if (message.equals(SoundType.LASER.getFileName())) {
            eventSound.playSound(SoundType.LASER);
        } else if (message.equals(MusicType.CALM.getFileName())) {
            backgroundSound.reproduceCalm();
        } else if (message.equals(MusicType.COMBAT.getFileName())) {
            backgroundSound.reproduceCombat();
        } else if (message.equals(SoundType.EXPLOSION.getFileName())){
            eventSound.playSound(SoundType.EXPLOSION);
        } else if (message.equals(MusicType.MENU.getFileName())){
            backgroundSound.reproduceMenu();
        } else if (message.equals(SoundType.HIT.getFileName())){
            eventSound.playSound(SoundType.HIT);
        }
    }

    /**
     * Method from the P2PCommListener interface that is called when a new message is received.
     * Calls the receiveObject method to process the received message.
     * @param ip Sender's IP address.
     * @param message Received message.
     */
    @Override
    public void onIncomingMessage(String ip, Object message) {
        receiveObject(message);
    }

    /**
     * Method from the P2PCommListener interface that is called when a connection is closed.
     * @param ip Sender's IP address.
     */
    @Override
    public void onConnectionClosed(String ip) {}

    /**
     * Method from the P2PCommListener interface that is called when a connection is lost with a sender.
     * @param ip Sender's IP address.
     */
    @Override
    public void onConnectionLost(String ip) {}

    /**
     * Method from the P2PCommListener interface that is called when a new connection is established.
     * @param ip Sender's IP address.
     */
    @Override
    public void onNewConnection(String ip) {}
}
