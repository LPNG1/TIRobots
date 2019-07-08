package robot.hardware.motors.advanced;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import robot.hardware.motors.LargeMotor;

public class AdvancedLargeMotor extends LargeMotor{

	public AdvancedLargeMotor(String port, String name) {
		super(port, name);
	}
	
	public EV3LargeRegulatedMotor getHardware() {
		return this.l;
	}

}
