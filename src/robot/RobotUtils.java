package robot;

/**
 * Robot management utilities
 * @author John
 *
 */
public class RobotUtils {

	/**
	 * Stops all motors
	 */
	public static void stopAllMotors() {
		for (int i = 0; i < RobotMap.getMotors().length; i++) {
			if(RobotMap.getMotors()[i] != null) {
				RobotMap.getMotors()[i].brake(true);
			}
		}
	}
	
	
}
