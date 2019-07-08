package communication.udp;

import org.json.simple.JSONArray;

import communication.tcp.TCPCommunicator;
import data.JSONCreator;
import robot.RobotMap;

/**
 * Thread that sends robot data to the DS at regular intervals though UDP
 * @author John
 *
 */
public class UDPSenderThread extends Thread{
	
	private boolean active = false;
	private long messageInterval;
	
	public UDPSenderThread(long interval) {
		this.messageInterval = interval;
	}
	
	@Override
	public void run() {
		
		active = true;
		
		while(active) {
			JSONArray msg = JSONCreator.createSendableJSON(RobotMap.getSensors(), RobotMap.getMotors());
			UDPCommunicator.sendMessage(msg);
			msg = null;
			
			try {
				Thread.sleep(messageInterval);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void deactivate() {
		active = false;
		this.interrupt();
	}
	
}
