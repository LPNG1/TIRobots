package robot.hardware.sensors;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import robot.RobotMap;

public class ColorSensor extends RobotSensor{

	protected EV3ColorSensor c;
	private SampleProvider s;
	
	/**
	 * Constructor for a new color sensor
	 * TODO: handle bad or taken input for port
	 * @param port
	 */
	public ColorSensor(int port) {
		
		super(SensorType.COLOR, port);
		this.c = new EV3ColorSensor(this.port);
		s = this.c.getColorIDMode();
		RobotMap.addSensor(this);
	}
	
	@Override
	public double read() {
		float[] sample = new float[1];
		this.s.fetchSample(sample, 0);
		return sample[0];
	}
}
