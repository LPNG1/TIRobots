package main;

import main.user.AutoCode;
import robot.RobotMap;

public class AutonomousRunner extends RobotThread{

	@Override
	public void run() {
		EventManager.setCurrentThread(this);
		long startTime = System.currentTimeMillis();
		AutoCode.run();
		
		while(this.isActive() && System.currentTimeMillis() - startTime < 15000);
		System.out.println("Auto over");
		EventManager.autoActive = false;
		RobotMap.stopAllMotors();
	}
	
}
