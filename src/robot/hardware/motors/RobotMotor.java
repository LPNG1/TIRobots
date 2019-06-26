package robot.hardware.motors;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;

public class RobotMotor {

	private MotorType type;
	private String portName;
	protected Port port;
	
	/**
	 * Constructor for a general motor
	 * TODO: handle invalid or taken port unputs
	 * @param type
	 * @param port
	 */
	public RobotMotor(MotorType type, String port) {
		this.type = type;
		this.portName = port;
		setPort(port);
	}
	
	private void setPort(String port) {
		switch(port) {
		case "A":
			this.port = MotorPort.A;
			break;
		case "B":
			this.port = MotorPort.B;
			break;
		case "C":
			this.port = MotorPort.C;
			break;
		case "D":
			this.port = MotorPort.D;
			break;
		default:
			System.out.println("Error! Invalid port!");
		}
	}
	
	public String getPort() {
		return this.portName;
	}
	
	public String getType() {
		switch(this.type) {
		case LARGE:
			return "large";
		case MEDIUM:
			return "meduim";
		}
		return "null";
	}
	
	/**
	 * Set motor power
	 * @param power % of power between -100 and 100, negative values go backwards
	 */
	public void setPower(int power) {
		//Should be implemented on a per motor basis
		return;
	}
	
	/**
	 * Stops the motor
	 */
	public void brake() {
		//Should be implemented on a per motor basis
		return;
	}
	
	/**
	 * Stops powering the motor until it coasts to a stop
	 */
	public void coast() {
		//Should be implemented on a per motor basis
		return;
	}
	
	/**
	 * Resets the motor's encoder
	 */
	public void resetEncoder() {
		//Should be implemented on a per motor basis
		return;
	}
	
	/**
	 * Reads the motors encoder
	 * @return the value of the motor's encoder, in degrees
	 */
	public int readEncoder() {
		//Should be implemented on a per motor basis
		return 0;
	}
	
	/**
	 * Drives the motor for set power until further instruction
	 * @param power
	 */
	public void drive(int power) {
		//Should be implemented on a per motor basis
		return;
	}
	
	/**
	 * Drive the motor for set power a certain amount of degrees
	 * @param power 
	 * @param degrees
	 */
	public void driveDegrees(int power, int degrees) {
		//Should be implemented on a per motor basis
		return;
	}
	
}
