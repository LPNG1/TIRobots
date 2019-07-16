package main;

import actions.ActionHandler;
import communication.tcp.TCPCommunicator;
import communication.udp.UDPCommunicator;
import communication.udp.UDPReaderThread;
import communication.udp.UDPSenderThread;
import data.JoystickComponent;
import lejos.hardware.Button;
import lejos.utility.Delay;
import main.user.HardwareCreator;
import robot.RobotMap;
import robot.hardware.motors.LargeMotor;

public class MainClass {
	
	public static void main(String[] args) {
		
		System.out.println("Code started");
		System.out.println("Init hardware");
		
		HardwareCreator.init();
		
		System.out.println("Wait for connection");
		
		TCPCommunicator.init();
		
		System.out.println("Open UDP socket");
		
		UDPCommunicator.init();
		
		System.out.println("Starting threads");
		
		EventManager.send = new UDPSenderThread(50);
		EventManager.read = new UDPReaderThread();
		
		EventManager.send.start();
		EventManager.read.start();
		
		System.out.println("Start Action Handler");
		
		ActionHandler a = new ActionHandler();
		a.start();
		
		System.out.println("Ready");
		
	}
	
}
