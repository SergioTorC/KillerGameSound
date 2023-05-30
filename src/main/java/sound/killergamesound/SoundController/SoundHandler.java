/**
 * Class that handles sounds in a game.
 * Implements the P2PCommListener interface to receive communication messages.
 */
package sound.killergamesound.SoundController;

import communications.P2PCommListener;
import sound.killergamesound.SoundModel.BackgroundSound;
import sound.killergamesound.SoundModel.EventSound;
import sound.killergamesound.SoundModel.SoundType;

public class SoundHandler implements P2PCommListener {
    BackgroundSound backgroundSound;
    EventSound eventSound;

    /**
     * Constructor for the SoundHandler class.
     * Creates instances of BackgroundSound and EventSound.
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
