package main;

import communication.tcp.TCPCommunicator;
import communication.udp.UDPCommunicator;
import lejos.hardware.Button;
import robot.hardware.motors.LargeMotor;

public class TestMain {

	private static LargeMotor leftMotor;
	private static LargeMotor rightMotor;
	
	public static void main(String[] args) {

		leftMotor = new LargeMotor("B", "leftMotor");
		rightMotor = new LargeMotor("C", "rightMotor");
		//MediumMotor arm = new MediumMotor("D");
		//TouchSensor t = new TouchSensor(2);
		//GyroSensor gyro = new GyroSensor(1);
		
		System.out.println("ready for connection");
		
		TCPCommunicator.init();
		UDPCommunicator.init();
		
		
		System.out.println("connected");
		
		while(!TCPCommunicator.hasNextMessage());
		
		System.out.println(TCPCommunicator.getNextMessage().get("event-id"));
		
		Button.waitForAnyPress();
		
//		
//		UDPSenderThread send = new UDPSenderThread(50);
//		
//		send.start();
//		
//		UDPReaderThread read = new UDPReaderThread();
//		read.start();
//		
//		leftMotor.drive(0.5);
//		
//		while(Button.ESCAPE.isUp()) {
//			
//			try {
//				double rotate = -(read.getJoystickData().getComponentValue(JoystickComponent.R_STICK_HOR));
//				double move = -(read.getJoystickData().getComponentValue(JoystickComponent.L_STICK_VER));
//				arcadeDrive(move, rotate);
//			} catch (NullPointerException e) {}
//			
//		}
//		
//		read.interrupt();
//		send.interrupt();
	}
	
	public static void arcadeDrive(double moveValue, double rotateValue) {

        double leftMotorSpeed;
        double rightMotorSpeed;

        moveValue = Math.copySign(moveValue * moveValue, moveValue);
        rotateValue = Math.copySign(rotateValue * rotateValue, rotateValue);

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
        
        leftMotor.drive(leftMotorSpeed);
        rightMotor.drive(rightMotorSpeed);
	}

}