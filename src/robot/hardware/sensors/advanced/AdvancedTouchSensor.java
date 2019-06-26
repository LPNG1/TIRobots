package robot.hardware.sensors.advanced;

import lejos.hardware.sensor.EV3TouchSensor;
import robot.hardware.sensors.TouchSensor;

/**
 * Interface for working directly with leJOS touch sensor
 * @author John
 *
 */
public class AdvancedTouchSensor extends TouchSensor{

	public AdvancedTouchSensor(int port) {
		super(port);
	}
	
	public EV3TouchSensor getHardware() {
		return this.t;
	}

}
