package robot.hardware.sensors;

import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import robot.RobotMap;

public class GyroSensor extends RobotSensor{

	protected EV3GyroSensor g;
	private SampleProvider s;
	
	/**
	 * Constructor for a new gyro sensor
	 * TODO: handle bad or taken input for port
	 * @param port
	 */
	public GyroSensor(int port, String name) {
		
		super(SensorType.GYRO, false, port, name);
		this.g = new EV3GyroSensor(this.port);
		s = this.g.getAngleMode();
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
		this.g.reset();
	}

}
