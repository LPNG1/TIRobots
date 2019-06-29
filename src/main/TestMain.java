package main;

import org.json.simple.JSONArray;

import communication.Communicator;
import data.JSONCreator;
import robot.RobotMap;
import robot.hardware.motors.LargeMotor;
import robot.hardware.motors.MediumMotor;
import robot.hardware.sensors.GyroSensor;
import robot.hardware.sensors.TouchSensor;

public class TestMain {

	public static void main(String[] args) {

		Communicator.init();

		LargeMotor leftMotor = new LargeMotor("B");
		LargeMotor rightMotor = new LargeMotor("C");
		MediumMotor arm = new MediumMotor("D");
		TouchSensor t = new TouchSensor(2);
		GyroSensor gyro = new GyroSensor(1);
		
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() - time < 10000) {
			JSONArray msg = JSONCreator.createSendableJSON(RobotMap.getSensors(), RobotMap.getMotors());
			Communicator.sendMessage(msg);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// long time = System.currentTimeMillis();
		//
		// while(!Communicator.hasNextMessage());
		//
		// while (Button.ESCAPE.isUp()) {
		//
		// JoystickData j = new JoystickData(Communicator.getNextMsg());
		//
		// System.out.println(j.getComponentValue(JoystickComponent.BUTTON_A));
		//
		// }

	}

}