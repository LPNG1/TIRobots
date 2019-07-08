package robot.hardware.sensors;

import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import robot.RobotMap;

public class UltrasonicSensor extends RobotSensor{

	protected EV3UltrasonicSensor u;
	private SampleProvider s;
	
	/**
	 * Constructor for a new ultrasonic sensor
	 * TODO: handle bad or taken input for port
	 * @param port
	 */
	public UltrasonicSensor(int port, String name) {
		
		super(SensorType.ULTRASONIC, false, port, name);
		this.u = new EV3UltrasonicSensor(this.port);
		s = this.u.getDistanceMode();
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
