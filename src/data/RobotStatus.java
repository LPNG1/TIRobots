package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RobotStatus {

	private String robotStatus;
	
	public RobotStatus(JSONArray message) {
		JSONObject robotStatusJSON = (JSONObject) message.get(2);
		
		this.robotStatus = (String) robotStatusJSON.get("status");
	}
	
	public String getStatus() {
		return this.robotStatus;
	}
	
}