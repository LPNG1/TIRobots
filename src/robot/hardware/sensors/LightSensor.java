package robot.hardware.sensors;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import robot.RobotMap;

public class LightSensor extends RobotSensor{

	private EV3ColorSensor l;
	private SampleProvider s;
	
	/**
	 * Constructor for a new light sensor
	 * TODO: handle bad or taken input for port
	 * @param port
	 */
	public LightSensor(int port) {
		
		super(SensorType.LIGHT, port);
		this.l = new EV3ColorSensor(this.port);
		s = this.l.getRedMode();
		RobotMap.addSensor(this);
	}
	
	@Override
	public double read() {
		
		float[] sample = new float[5];
		double sum = 0;
		
		for (int i = 0; i < sample.length; i++) {
			this.s.fetchSample(sample, i);
			sum += sample[i];
		}
		
		return sum/5;
	}

	@Override
	public void reset() {
		// This sensor can't reset
		return;	
	}
	
}
