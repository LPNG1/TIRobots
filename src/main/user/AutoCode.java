package main.user;

import robot.RobotMap;

public class AutoCode {
	
	public static void run() {
		
		RobotMap.getMotor("leftMotor").driveDegrees(0.5, 360, false);
		
	}
	
}
