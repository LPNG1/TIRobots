package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Data structure for easily accessing specific joystick component values
 * @author John
 *
 */
public class JoystickData {

	private double BUTTON_A_VALUE;
	private double BUTTON_B_VALUE;
	private double BUTTON_X_VALUE;
	private double BUTTON_Y_VALUE;
	
	private double BUTTON_RB_VALUE;
	private double BUTTON_LB_VALUE;
	
	private double BUTTON_BACK_VALUE;
	private double BUTTON_START_VALUE;
	
	private double BUTTON_R_STICK_VALUE;
	private double BUTTON_L_STICK_VALUE;
	
	private double R_STICK_HOR_VALUE;
	private double R_STICK_VER_VALUE;
	
	private double L_STICK_HOR_VALUE;
	private double L_STICK_VER_VALUE;
	
	private double TRIGGERS_VALUE;
	
	private double POV_SWITCH_VALUE;
	
	/**
	 * Constuctor for a JoystickData object
	 * @param message message received from driver station
	 */
	public JoystickData(JSONArray message) {
		
		//TODO: smarter implementation than hard coded 0 index
		JSONObject joystickValueJSON = (JSONObject) message.get(0);
		JSONObject joystickJSON = (JSONObject) joystickValueJSON.get("joystickValues");
		
		this.BUTTON_A_VALUE = (double) joystickJSON.get("0");
		this.BUTTON_B_VALUE = (double) joystickJSON.get("1");
		this.BUTTON_X_VALUE = (double) joystickJSON.get("2");
		this.BUTTON_Y_VALUE = (double) joystickJSON.get("3");
		
		this.BUTTON_RB_VALUE = (double) joystickJSON.get("5");
		this.BUTTON_LB_VALUE = (double) joystickJSON.get("4");
		
		this.BUTTON_BACK_VALUE = (double) joystickJSON.get("6");
		this.BUTTON_START_VALUE = (double) joystickJSON.get("7");
		
		this.BUTTON_R_STICK_VALUE = (double) joystickJSON.get("9");
		this.BUTTON_L_STICK_VALUE = (double) joystickJSON.get("8");
		
		this.R_STICK_HOR_VALUE = (double) joystickJSON.get("rx");
		this.R_STICK_VER_VALUE = (double) joystickJSON.get("ry");
		
		this.L_STICK_HOR_VALUE = (double) joystickJSON.get("x");
		this.L_STICK_VER_VALUE = (double) joystickJSON.get("y");
		
		this.TRIGGERS_VALUE = (double) joystickJSON.get("z");
		
		this.POV_SWITCH_VALUE = (double) joystickJSON.get("pov");
	}
	
	/**
	 * Returns a value of a specific component
	 */
	public double getComponentValue(JoystickComponent comp) {
		
		switch (comp) {
		case BUTTON_A:
			return this.BUTTON_A_VALUE;
		case BUTTON_B:
			return this.BUTTON_B_VALUE;
		case BUTTON_X:
			return this.BUTTON_X_VALUE;
		case BUTTON_Y:
			return this.BUTTON_Y_VALUE;
		case BUTTON_LB:
			return this.BUTTON_LB_VALUE;
		case BUTTON_RB:
			return this.BUTTON_RB_VALUE;
		case BUTTON_BACK:
			return this.BUTTON_BACK_VALUE;
		case BUTTON_START:
			return this.BUTTON_START_VALUE;
		case R_STICK_BUTTON:
			return this.BUTTON_R_STICK_VALUE;
		case L_STICK_BUTTON:
			return this.BUTTON_L_STICK_VALUE;
		case R_STICK_HOR:
			return this.R_STICK_HOR_VALUE;
		case R_STICK_VER:
			return this.R_STICK_VER_VALUE;
		case L_STICK_HOR:
			return this.L_STICK_HOR_VALUE;
		case L_STICK_VER:
			return this.L_STICK_VER_VALUE;
		case TRIGGERS:
			return this.TRIGGERS_VALUE;
		case POV_SWITCH:
			return this.POV_SWITCH_VALUE;
		default:
			return 0;
		}
	}
}
