package robot.hardware.motors;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import main.EventManager;
import robot.RobotMap;

public class LargeMotor extends RobotMotor{

	protected EV3LargeRegulatedMotor l;
	
	public LargeMotor(String port, String name) {
		super(MotorType.LARGE, port, name);
		this.l = new EV3LargeRegulatedMotor(this.port);
		RobotMap.addMotor(this);
	}
	
	@Override
	public void setPower(double power) {
		//map to 0-800 speed
		int speed = (int) Math.min(Math.max((Math.abs(power)*800), 0), 800);
		
		l.setSpeed(speed);
	}
	
	@Override
	public void drive(double power) {
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
	public void brake(boolean immediateReturn) {
		l.stop(immediateReturn);
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
	public void driveDegrees(double power, int degrees, boolean immediateReturn) {
		this.drive(power);
		int startEncoderValue = this.readEncoder();
		
		if(power > 0) {
			while(this.readEncoder() < startEncoderValue + degrees && EventManager.getCurrentThread().isActive());
		} if (power < 0) {
			while(this.readEncoder() > startEncoderValue - degrees && EventManager.getCurrentThread().isActive());
		}
		
		this.brake(immediateReturn);
	}
	
}
