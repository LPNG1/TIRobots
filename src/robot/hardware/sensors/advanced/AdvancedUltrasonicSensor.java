package robot.hardware.sensors.advanced;

import lejos.hardware.sensor.EV3UltrasonicSensor;
import robot.hardware.sensors.UltrasonicSensor;

/**
 * Interface for working directly with leJOS ultrasonic sensor
 * @author John
 *
 */
public class AdvancedUltrasonicSensor extends UltrasonicSensor{

	public AdvancedUltrasonicSensor(int port, String name) {
		super(port, name);
	}
	
	public EV3UltrasonicSensor getHardware() {
		return this.u;
	}

}
