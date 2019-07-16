package main;

public class RobotThread extends Thread{
	
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	
	public void activate() {
		this.active = true;
		this.start();
	}
	
	public void deactivate() {
		this.active = false;
	}
	
	
}
