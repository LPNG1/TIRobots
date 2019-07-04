package communication;

import communication.tcp.TCPCommunicator;
import communication.udp.UDPCommunicator;

/**
 * Communication wrapper for both TCP and UDP streams
 * @author John
 *
 */
public class Communicator {
	
	public static void initCommuniction() {
		
		//TODO not hardcode ports 
		TCPCommunicator.init();
		UDPCommunicator.init(TCPCommunicator.getIP());
		
	}
	
	
}
