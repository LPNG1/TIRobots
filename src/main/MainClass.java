package main;

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
		
		
	}
	
}
