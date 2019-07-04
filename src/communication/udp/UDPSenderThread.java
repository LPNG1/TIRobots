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
	
	private volatile boolean active;
	private JSONArray msg = null;
	
	private long messageInterval;
	
	public UDPSenderThread(long interval) {
		this.messageInterval = interval;
	}
	
	@Override
	public void run() {
		
		this.active = true;
		
		while(!this.isInterrupted()) {
			JSONArray msg = JSONCreator.createSendableJSON(RobotMap.getSensors(), RobotMap.getMotors());
			UDPCommunicator.sendMessage(msg);
			msg = null;
			
			try {
				Thread.sleep(messageInterval);
			} catch (InterruptedException e) {
				return;
			}
		}
		
		this.active = false;
		
	}
	
	public boolean isActive() {
		return this.active;
	}
	
}
