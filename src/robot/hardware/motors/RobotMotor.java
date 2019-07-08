package robot.hardware.motors;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;

public abstract class RobotMotor {

	private MotorType type;
	private String portName;
	private String motorName;
	protected Port port;
	
	/**
	 * Constructor for a general motor
	 * TODO: handle invalid or taken port unputs
	 * @param type
	 * @param port
	 */
	public RobotMotor(MotorType type, String port, String name) {
		this.type = type;
		this.portName = port;
		this.motorName = name;
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
	
	public String getName() {
		return this.motorName;
	}
	
	/**
	 * Set motor power
	 * @param power % of power between -1 and 1, negative values go backwards
	 */
	public abstract void setPower(double power);
	
	/**
	 * Stops the motor
	 */
	public abstract void brake(boolean immediateReturn);
	
	/**
	 * Stops powering the motor until it coasts to a stop
	 */
	public abstract void coast();
	
	/**
	 * Resets the motor's encoder
	 */
	public abstract void resetEncoder();
	
	/**
	 * Reads the motors encoder
	 * @return the value of the motor's encoder, in degrees
	 */
	public abstract int readEncoder();
	
	/**
	 * Drives the motor for set power until further instruction
	 * @param power
	 */
	public abstract void drive(double power);
	
	/**
	 * Drive the motor for set power a certain amount of degrees
	 * @param power 
	 * @param degrees
	 */
	public abstract void driveDegrees(double power, int degrees);
	
}
