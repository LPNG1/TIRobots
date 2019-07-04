package communication.tcp;

import org.json.simple.JSONArray;

import data.JSONCreator;
import robot.RobotMap;

/**
 * Thread that sends messages over the TCP stream at regular intervals
 * @author John
 *
 */
public class TCPSenderThread extends Thread{
	
	private volatile boolean active;
	private JSONArray msg = null;

	private long messageInterval;
	
	@Override
	public void run() {
		
		this.active = true;
		
		while(!this.isInterrupted()) {
			
			/*
			 * TODO New code goes here
			 */
			
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
