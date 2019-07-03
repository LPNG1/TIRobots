package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lejos.hardware.Power;
import lejos.hardware.ev3.LocalEV3;
import robot.hardware.motors.RobotMotor;
import robot.hardware.sensors.RobotSensor;

/**
 * Utilities for creating JSON data easily
 * 
 * @author John
 *
 */

public class JSONCreator {

	/**
	 * Create a list of sensors with their respective ports, types, and values
	 * 
	 * @param sensors an array containing the sensor objects on the robot, should be
	 *                obtained via RobotMap
	 * @return
	 */
	public static JSONObject createSensorJSON(RobotSensor[] sensors) {

		JSONObject sensorData = new JSONObject();
		JSONArray sensorList = new JSONArray();

		for (int i = 0; i < sensors.length; i++) {
			if (sensors[i] != null) {
				JSONObject sensor = new JSONObject();
				sensor.put("port", Integer.toString(sensors[i].getPort()));
				sensor.put("type", sensors[i].getType());
				sensor.put("value", sensors[i].read());
				
				sensorList.add(sensor);
			}
		}

		sensorData.put("sensors", sensorList);
		return sensorData;
	}

	/**
	 * Create a list of motors with their respective ports, types, and encoder
	 * values
	 * 
	 * @param motors an array containing the motor objects on the robot, should be
	 *               obtained via RobotMap
	 * @return
	 */
	public static JSONObject createMotorJSON(RobotMotor[] motors) {

		JSONObject motorData = new JSONObject();
		JSONArray motorList = new JSONArray();

		for (int i = 0; i < motors.length; i++) {
			if (motors[i] != null) {
				JSONObject motor = new JSONObject();
				motor.put("port", motors[i].getPort());
				motor.put("type", motors[i].getType());
				motor.put("encoder-value", motors[i].readEncoder());
				motorList.add(motor);
			}
		}

		motorData.put("motors", motorList);
		return motorData;
	}
	
	/**
	 * Creates a JSON object with info about the brick battery
	 * TODO: get info from a method instead of reading from brick
	 * @return
	 */
	public static JSONObject createBatteryJSON() {
		JSONObject battery = new JSONObject();
		JSONObject batteryInfo = new JSONObject();
		Power brickBattery = LocalEV3.get().getPower();
		
		batteryInfo.put("voltage", brickBattery.getVoltage());
		batteryInfo.put("current", brickBattery.getBatteryCurrent());
		batteryInfo.put("motor-current", brickBattery.getMotorCurrent());
		
		battery.put("battery", batteryInfo);
		
		return battery;
	}
	
	/**
	 * Returns a JSON array with all of the data that should be sent to the driver station
	 * @param sensors
	 * @param motors
	 * @return
	 */
	public static JSONArray createSendableJSON(RobotSensor[] sensors, RobotMotor[] motors) {
		JSONArray sendData = new JSONArray();
		
		sendData.add(createSensorJSON(sensors));
		sendData.add(createMotorJSON(motors));
		sendData.add(createBatteryJSON());
		
		return sendData;
	}
	
}
