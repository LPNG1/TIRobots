package robot.hardware.sensors;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import robot.RobotMap;

public class TouchSensor extends RobotSensor{

	protected EV3TouchSensor t;
	private SampleProvider s;
	
	/**
	 * Constructor for a new touch sensor
	 * TODO: handle bad or taken input for port
	 * @param port
	 */
	public TouchSensor(int port, String name) {
		
		super(SensorType.TOUCH, false, port, name);
		this.t = new EV3TouchSensor(this.port);
		s = this.t.getTouchMode();
		RobotMap.addSensor(this);
	}
	
	@Override
	public double read() {
		float[] sample = new float[1];
		this.s.fetchSample(sample, 0);	
		return sample[0];
	}

	@Override
	public void reset() {
		// This sensor can't reset
		return;
	}
}
