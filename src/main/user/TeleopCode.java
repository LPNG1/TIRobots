package main.user;

import communication.tcp.TCPCommunicator;
import communication.udp.UDPReaderThread;
import data.JoystickComponent;
import main.EventManager;
import robot.RobotMap;

public class TeleopCode {

	public static void runOneCycle() {
		arcadeDrive(-(EventManager.read.getJoystickData().getComponentValue(JoystickComponent.L_STICK_VER)),
				-(EventManager.read.getJoystickData().getComponentValue(JoystickComponent.R_STICK_HOR)));
	}

	private static void arcadeDrive(double moveValue, double rotateValue) {
		double leftMotorSpeed;
		double rightMotorSpeed;

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
		RobotMap.getMotor("leftMotor").drive(leftMotorSpeed);
		RobotMap.getMotor("rightMotor").drive(rightMotorSpeed);
	}

}
