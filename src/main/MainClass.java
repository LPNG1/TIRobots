package main;

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
		
		/**
		 * logic:
		 * this needs to have a main loop which waits for either a "command" or a "match"
		 * status. when command is active it needs to be able to stop.
		 * 
		 * when match active is received it interrupts all commands and sets the robot up for a match
		 * during a match the robot runs auto for 15 seconds, and uses gametime to keep
		 * track of the status. when gametime is 0 (use server time not local time) match is still
		 * enabled but state is endgame. after referees submit and the match is "complete"
		 * the state changes to match disabled and the robot can now respond to commands again
		 * (returns to main loop)
		 * 
		 */
		
		System.out.println("Code started");
		System.out.println("Init hardware");
		
		HardwareCreator.init();
		
		System.out.println("Wait for connection");
		
		TCPCommunicator.init();
		
		System.out.println("Open UDP socket");
		
		UDPCommunicator.init();
		
		System.out.println("Starting threads");
		
		UDPSenderThread send = new UDPSenderThread(50);
		UDPReaderThread read = new UDPReaderThread();
		
		send.start();
		read.start();
		
		System.out.println("Ready");
		
		//now create action handler and start doing stuff
		
		
		while(Button.ESCAPE.isUp()) {
			try {
				System.out.println(read.getJoystickData().getComponentValue(JoystickComponent.BUTTON_A));
			} catch(NullPointerException e) {
				System.out.println("Null");
			}
			
		}
		
		send.deactivate();
		read.deactivate();
		
		System.out.println(send.isAlive());
		System.out.println(read.isAlive());
		
		Button.waitForAnyPress();
		
	}
	
}
