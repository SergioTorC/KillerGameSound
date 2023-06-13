package controller;

import communications.ConnectionController;
import communications.P2PCommListener;

public class ControlController implements P2PCommListener{
	private ConnectionController comm;
	private ControlEmulator emulator;

	//private int team;
	
	public ControlController() {
		emulator = new ControlEmulator(this);
	}

	@Override
	public void onConnectionClosed(String ip) {
	}

	@Override
	public void onConnectionLost(String ip) {
	}

	@Override
	public void onIncomingMessage(String ip, Object message) {
	}

	@Override
	public void onNewConnection(String ip) {
	}

	public void sendShipControlMessage(Object message) {
		comm.sendFlood(message);
	}

	public void setComm(ConnectionController comm) {
		this.comm = comm;
	}

}
