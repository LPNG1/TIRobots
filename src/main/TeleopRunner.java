package main;

import main.user.TeleopCode;
import robot.RobotMap;

public class TeleopRunner extends RobotThread {
	@Override
	public void run() {

		while (this.isActive()) {

			if (EventManager.robotEnabled) {
				TeleopCode.runOneCycle();
			} else {
				RobotMap.stopAllMotors();
			}

		}
		
		RobotMap.stopAllMotors();
		System.out.println("Teleop Over");
		
	}
}
