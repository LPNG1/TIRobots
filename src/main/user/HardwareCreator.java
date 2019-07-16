package main.user;

import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.GyroSensor;
import robot.hardware.sensors.TouchSensor;

public class HardwareCreator{

	public static void init() {
		// TODO create your hardware here!
		//e.g. new LargeMotor("B", "leftMotor");
		
		new LargeMotor("B", "leftMotor");
		new LargeMotor("C", "rightMotor");
		
		new TouchSensor(3, "touch");
		new GyroSensor(1, "gyro");
		
	}

}
