package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GamestateData {

	private String gamestate;
	
	/**
	 * Contructor for gamestate data structure
	 * TODO: implement "mode" as well as gamestate and other info if required
	 */
	public GamestateData(JSONArray message) {
		
		JSONObject gamestateJSON = (JSONObject) message.get(1);
		
		this.gamestate = (String) gamestateJSON.get("gamestate");
	}
	
	public String getGamestate() {
		return this.gamestate;
	}
}
