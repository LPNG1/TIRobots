package main;

import communication.udp.UDPReaderThread;
import communication.udp.UDPSenderThread;
import robot.RobotMap;

public class EventManager {
	
	public static volatile boolean matchActive = false;
	public static volatile boolean robotEnabled = false;
	
	public static volatile boolean autoActive = false;
	public static volatile boolean teleopActive = false;
	
	public static UDPSenderThread send;
	public static UDPReaderThread read;
	
	public static AutonomousRunner autoThread;
	public static TeleopRunner teleopThread;
	
	private static RobotThread currentThread;
	
	
	public static void resetEvents() {
		matchActive = false;
		robotEnabled = false;
		
		autoActive = false;
		teleopActive = false;
	}
	
	public static void startAuto() {
		autoThread = new AutonomousRunner();
		autoThread.activate();
		autoActive = true;
	}
	
	public static void stopAuto() {
		autoThread.deactivate();
		autoActive = false;
		RobotMap.stopAllMotors();
	}
	
	public static void startTeleop() {
		teleopThread = new TeleopRunner();
		teleopThread.activate();
		teleopActive = true;
	}
	
	public static void stopTeleop() {
		teleopThread.deactivate();
		teleopActive = false;
		RobotMap.stopAllMotors();
	}
	
	public static RobotThread getCurrentThread() {
		return currentThread;
	}
	
	public static void setCurrentThread(RobotThread thread) {
		currentThread = thread;
	}
}
