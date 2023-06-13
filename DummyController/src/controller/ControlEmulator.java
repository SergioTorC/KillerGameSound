package controller;

import Sounds.MusicType;
import Sounds.SoundType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class ControlEmulator extends JFrame implements KeyListener {

	@Serial
	private static final long serialVersionUID = 1L;

	private static String message;
	private final ControlController controller;

	public ControlEmulator(ControlController controller) {
		this.controller = controller;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		add(new Label("Use arrow keys to control the sounds"), c);
		add(new Label("A W S D Q E"), c);
		
		addKeyListener(this);
		
		setTitle("Asteroids controller");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W -> {
				message = SoundType.LASER.getFileName();
				controller.sendShipControlMessage(message);
			}
			case KeyEvent.VK_A -> {
				message = MusicType.CALM.getFileName();
				controller.sendShipControlMessage(message);
			}
			case KeyEvent.VK_D -> {
				message = MusicType.COMBAT.getFileName();
				controller.sendShipControlMessage(message);
			}
			case KeyEvent.VK_S -> {
				message = SoundType.EXPLOSION.getFileName();
				controller.sendShipControlMessage(message);
			}
			case KeyEvent.VK_Q -> {
				message = MusicType.MENU.getFileName();
				controller.sendShipControlMessage(message);
			}
			case KeyEvent.VK_E -> {
				message = SoundType.HIT.getFileName();
				controller.sendShipControlMessage(message);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
