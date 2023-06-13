package main;

import communications.ConnectionController;

public class Main {

	public static void main(String[] args) {
		startAsteroidsController();
	}
	
	@SuppressWarnings("unused")
	static private void startAsteroidsController() {
		var comm = new ConnectionController();
		var controller = new controller.ControlController();
		controller.setComm(comm);
		comm.setCommListener(controller);
		comm.initialize();
	}

}
