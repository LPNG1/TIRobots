package communication.udp;

import org.json.simple.JSONArray;

import data.GamestateData;
import data.JoystickData;
import data.RobotStatus;

/**
 * Thread that constantly reads the UDP stream
 * 
 * @author John
 *
 */
public class UDPReaderThread extends Thread {

	private boolean active = false;

	private JoystickData joystick;
	private GamestateData gamestate;
	private RobotStatus status;

	@Override
	public void run() {

		active = true;

		while (active) {

			// get next UDP message
			JSONArray msg = null;
			try {
				msg = UDPCommunicator.getMessage();
			} catch (NullPointerException e) {
				continue;
			}
			
			// update joystick data
			joystick = new JoystickData(msg);

			// update gamestate data
			gamestate = new GamestateData(msg);

			// update robot status
			status = new RobotStatus(msg);

		}

	}

	public JoystickData getJoystickData() {
		return this.joystick;
	}

	public GamestateData getGamestateData() {
		return this.gamestate;
	}

	public RobotStatus getRobotStatus() {
		return this.status;
	}

	public boolean isActive() {
		return active;
	}

	public void deactivate() {
		active = false;
		this.interrupt();
	}

}
