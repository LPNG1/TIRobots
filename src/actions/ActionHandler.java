package actions;

import org.json.simple.JSONObject;

import communication.tcp.TCPCommunicator;
import main.EventManager;

/**
 * Reads actions sent from the driver station and handles them accordingly
 * 
 * @author John
 *
 */
public class ActionHandler extends Thread {

	@Override
	public void run() {
		JSONObject msg = new JSONObject();
		while (!this.isInterrupted()) {
			if (TCPCommunicator.hasNextMessage()) {
				msg = TCPCommunicator.getNextMessage();

				String eventID = (String) msg.get("event-id");

				switch (eventID) {
				case "start-auto":
					handleStartAuto();
					break;
				case "stop-auto":
					handleStopAuto();
					break;
				case "start-teleop":
					handleStartTeleop();
					break;
				case "stop-teleop":
					handleStopTeleop();
					break;
				case "enable":
					handleEnable();
					break;
				case "disable":
					handleDisable();
					break;
				}
			}
		}
	}

	private void handleStartAuto() {
		if (!EventManager.autoActive && !EventManager.matchActive && EventManager.robotEnabled && !EventManager.teleopActive) {
			System.out.println("Auto Started");

			EventManager.startAuto();
			sendResponse(true);

		} else {
			System.out.println("Auto Start Failed");
			sendResponse(false);
		}
	}

	private void handleStopAuto() {
		if (EventManager.autoActive && !EventManager.matchActive && !EventManager.teleopActive) {
			System.out.println("Auto Stopped");

			EventManager.stopAuto();
			sendResponse(true);

		} else {
			System.out.println("Auto Stop Failed");
			sendResponse(false);
		}
	}

	private void handleEnable() {
		if(!EventManager.matchActive && !EventManager.robotEnabled) {
			System.out.println("Robot Enabled");

			// TODO send auto stop command that actually runs the code and updates event
			// and remove this line VV
			EventManager.robotEnabled = true;

			sendResponse(true);
		} else {
			System.out.println("Robot Enable Failed");
			sendResponse(false);
		}
	}
	
	private void handleDisable() {
		if(!EventManager.matchActive && EventManager.robotEnabled) {
			System.out.println("Robot Disabled");

			// TODO send auto stop command that actually runs the code and updates event
			// and remove this line VV
			EventManager.robotEnabled = false;

			sendResponse(true);
		} else {
			System.out.println("Robot Enable Failed");
			sendResponse(false);
		}
	}
	
	private void handleStartTeleop() {
		if (!EventManager.autoActive && !EventManager.matchActive && !EventManager.teleopActive) {
			System.out.println("Teleop Started");

			EventManager.startTeleop();
			sendResponse(true);

		} else {
			System.out.println("Teleop Start Failed");
			sendResponse(false);
		}
	}
	
	private void handleStopTeleop() {
		if (!EventManager.autoActive && !EventManager.matchActive && EventManager.teleopActive) {
			System.out.println("Teleop Stopped");

			EventManager.stopTeleop();
			sendResponse(true);

		} else {
			System.out.println("Teleop Stop Failed");
			sendResponse(false);
		}
	}

	private void sendResponse(boolean success) {
		JSONObject msg = new JSONObject();
		msg = new JSONObject();

		if (success) {
			msg.put("response", "success");
		} else {
			msg.put("response", "faliure");
		}

		TCPCommunicator.sendMessage(msg);
	}

}
