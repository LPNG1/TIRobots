package robot.hardware.motors;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import robot.RobotMap;

public class LargeMotor extends RobotMotor{

	protected EV3LargeRegulatedMotor l;
	
	public LargeMotor(String port) {
		super(MotorType.LARGE, port);
		this.l = new EV3LargeRegulatedMotor(this.port);
		RobotMap.addMotor(this);
	}
	
	@Override
	public void setPower(int power) {
		//map to 0-800 speed
		int speed = Math.min(Math.max((Math.abs(power)*8), 0), 800);
		
		l.setSpeed(speed);
	}
	
	@Override
	public void drive(int power) {
		this.setPower(power);
		
		if(power > 0) {
			l.forward();
		}
		else if(power < 0) {
			l.backward();
		}
		else {
			l.flt();
		}
	}
	
	@Override
	public void brake() {
		l.stop();
	}
	
	@Override
	public void coast() {
		l.flt();
	}
	
	@Override
	public void resetEncoder() {
		l.resetTachoCount();
	}
	
	@Override
	public int readEncoder() {
		return l.getTachoCount();
	}
	
	@Override
	public void driveDegrees(int power, int degrees) {
		this.setPower(power);
		//TODO: implement in respect to thread interruptions
	}
}
