package robot.hardware.sensors.advanced;

import lejos.hardware.sensor.EV3ColorSensor;
import robot.hardware.sensors.ColorSensor;

/**
 * Interface for working directly with leJOS color sensor
 * Use this with getRedMode() to work directly with rthe leJOS light sensor as it uses the same hardware
 * @author John
 *
 */
public class AdvancedColorSensor extends ColorSensor{

	public AdvancedColorSensor(int port) {
		super(port);
	}
	
	public EV3ColorSensor getHardware() {
		return this.c;
	}

}
