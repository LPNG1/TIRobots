package robot.hardware.motors;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import main.EventManager;
import robot.RobotMap;

public class MediumMotor extends RobotMotor{

	protected EV3MediumRegulatedMotor m;
	
	public MediumMotor(String port, String name) {
		super(MotorType.LARGE, port, name);
		this.m = new EV3MediumRegulatedMotor(this.port);
		RobotMap.addMotor(this);
	}
	
	@Override
	public void setPower(double power) {
		//map to 0-800 speed
		int speed = (int) Math.min(Math.max((Math.abs(power)*800), 0), 800);
		
		m.setSpeed(speed);
	}
	
	@Override
	public void drive(double power) {
		this.setPower(power);
		
		if(power > 0) {
			m.forward();
		}
		else if(power < 0) {
			m.backward();
		}
		else {
			m.flt();
		}
	}
	
	@Override
	public void brake(boolean immediateReturn) {
		m.stop(immediateReturn);
	}
	
	@Override
	public void coast() {
		m.flt();
	}
	
	@Override
	public void resetEncoder() {
		m.resetTachoCount();
	}
	
	@Override
	public int readEncoder() {
		return m.getTachoCount();
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
