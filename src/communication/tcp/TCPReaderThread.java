package communication.tcp;

import org.json.simple.JSONArray;

import data.GamestateData;
import data.JoystickData;

public class TCPReaderThread extends Thread{
	
	private volatile boolean active;
	
	@Override
	public void run() {
		
		this.active = true;
		
		while(!this.isInterrupted()) {
			
			/*
			 * TODO New code goes here
			 */

		}
		
		this.active = false;
		return;
		
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	
}
