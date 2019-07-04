package communication.udp;

import org.json.simple.JSONArray;

import data.GamestateData;
import data.JoystickData;
import data.RobotStatus;

/**
 * Thread that constantly reads the UDP stream
 * @author John
 *
 */
public class UDPReaderThread extends Thread{
	
	private volatile boolean active;

	private JoystickData joystick;
	private GamestateData gamestate;
	private RobotStatus status;
	
	@Override
	public void run() {

		this.active = true;

		while (!this.isInterrupted()) {

			// get next UDP message
			JSONArray msg = null;
			while (msg == null && !this.isInterrupted()) {
				msg = UDPCommunicator.getMessage();
			}

			//updte joystick data
			joystick = new JoystickData(msg);
			
			//update gamestate data
			gamestate = new GamestateData(msg);
			
			//update robot stauts
			status = new RobotStatus(msg);

		}

		this.active = false;

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
		return this.active;
	}

	
}
