package robot.hardware.sensors.advanced;

import lejos.hardware.sensor.EV3GyroSensor;
import robot.hardware.sensors.GyroSensor;

/**
 * Interface for working directly with leJOS gyro sensor
 * @author John
 *
 */
public class AdvancedGyroSensor extends GyroSensor{

	public AdvancedGyroSensor(int port) {
		super(port);
	}
	
	public EV3GyroSensor getHardware() {
		return this.g;
	}

}
