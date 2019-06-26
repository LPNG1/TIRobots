package main;

import org.json.simple.JSONArray;

import communication.Communicator;
import data.JSONCreator;
import robot.RobotMap;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.TouchSensor;

public class MainClass {

	public static void main(String[] args) {
		
		Communicator.init();
		
		LargeMotor leftMotor = new LargeMotor("B");
		LargeMotor rightMotor = new LargeMotor("C");
		TouchSensor t = new TouchSensor(1);
		
		JSONArray msg = JSONCreator.createSendableJSON(RobotMap.getSensors(), RobotMap.getMotors());
		System.out.println(msg);
		Communicator.sendMessage(msg);
//		
//		long time = System.currentTimeMillis();
//		
//		while(!Communicator.hasNextMessage());
//		
//		while (Button.ESCAPE.isUp()) {
//			
//			JoystickData j = new JoystickData(Communicator.getNextMsg());
//			
//			System.out.println(j.getComponentValue(JoystickComponent.BUTTON_A));
//			
//		}
		
	}
	
}