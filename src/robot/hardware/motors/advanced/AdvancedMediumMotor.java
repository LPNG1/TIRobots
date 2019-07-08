package robot.hardware.motors.advanced;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import robot.hardware.motors.MediumMotor;

public class AdvancedMediumMotor extends MediumMotor{

	public AdvancedMediumMotor(String port, String name) {
		super(port, name);
	}
	
	public EV3MediumRegulatedMotor getHardware() {
		return this.m;
	}

}
