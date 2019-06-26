package robot.hardware.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

/**
 * Generalization of a robot sensor
 * @author John
 *
 */
public class RobotSensor {

	protected SensorType type;
	protected int portName;
	protected Port port;

	/**
	 * Constructor for a general robot sensor
	 * @param type
	 * @param port
	 */
	public RobotSensor(SensorType type, int port) {
		
		this.type = type;
		this.portName = port;
		setPort(port);
	}
	
	private void setPort(int port) {
		switch(port) {
		case 1:
			this.port = SensorPort.S1;
			break;
		case 2:
			this.port = SensorPort.S2;
			break;
		case 3:
			this.port = SensorPort.S3;
			break;
		case 4:
			this.port = SensorPort.S4;
			break;
		}
	}
	
	public int getPort() {
		return this.portName;
	}
	
	public String getType() {
		switch(this.type) {
		case GYRO:
			return "gyro";
		case LIGHT:
			return "light";
		case COLOR:
			return "color";
		case TOUCH:
			return "touch";
		case ULTRASONIC:
			return "ultrasonic";
		}
		return "null";
	}
	
	/**
	 * Reads a sensor and returns its current value
	 */
	public double read() {
		//Should be implemented per sensor
		return 0;
	}
	
	/**
	 * Resets or calibrates a sensor
	 */
	public void reset() {
		//Should be implemented per sensor
		return;
	}
	
}
