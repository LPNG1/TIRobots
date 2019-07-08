package robot.hardware.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

/**
 * Generalization of a robot sensor
 * @author John
 *
 */
public abstract class RobotSensor {

	private  SensorType type;
	private int portName;
	private String sensorName;
	private boolean resetable;
	protected Port port;

	/**
	 * Constructor for a general robot sensor
	 * @param type
	 * @param port
	 */
	public RobotSensor(SensorType type, boolean resetable, int port, String name) {
		this.type = type;
		this.portName = port;
		this.sensorName = name;
		this.resetable = resetable;
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
	
	public String getName() {
		return this.sensorName;
	}
	
	public boolean canReset() {
		return this.resetable;
	}
	
	/**
	 * Reads a sensor and returns its current value
	 */
	public abstract double read();
	
	/**
	 * Resets or calibrates a sensor
	 */
	public abstract void reset();
	
}
