package communication.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * TCP Communication utilities
 * @author John
 *
 */
public class TCPCommunicator {
	
	private static Socket TCPsendSocket;
	private static Socket TCPrecSoket;
	private static PrintStream ps;
	private static Scanner reader;
	
	private static JSONParser parser = new JSONParser();
	
	/**
	 * Initializes communication, waits for connection and creates components
	 */
	public static void init() {
		connectToDS();
		createPrintStream();
		createScanner();
	}
	
	/**
	 * Wait to receive connection from driver station
	 * TODO: make ports not hard coded
	 */
	private static void connectToDS(){
		try {
			ServerSocket ss = new ServerSocket(4590);
			TCPrecSoket = ss.accept();
			ss.close();
			ss = new ServerSocket(4591);
			TCPsendSocket = ss.accept();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a scanner that reads messages from the receive socket
	 */
	private static void createScanner() {
		if(TCPrecSoket.isConnected()) {
			try {
				reader = new Scanner(TCPrecSoket.getInputStream());
			} catch (IOException e) {
				System.out.println("Exception while creating scanner:");
				e.printStackTrace();
			}
		} else {
			System.out.println("Cannot create scanner - not connected");
		}
	}
	
	/**
	 * Creates a print stream that sends messages from the send socket
	 */
	private static void createPrintStream() {
		if(TCPsendSocket.isConnected()) {
			try {
				ps = new PrintStream(TCPsendSocket.getOutputStream());
			} catch (IOException e) {
				System.out.println("Exception while creating print stream:");
				e.printStackTrace();
			}
		} else {
			System.out.println("Cannot create print stream - not connected");
		}
	}
	
	/**
	 * Sends a JSON message via the print stream
	 * @param msg
	 */
	public static void sendMessage(JSONArray msg) {
		ps.println(msg);
	}
	
	/**
	 * Returns the next message in the queue
	 * @return
	 */
	public static JSONObject getNextMessage() {
		if(reader.hasNextLine()) {
			try {
				return (JSONObject) parser.parse(reader.nextLine());
			} catch (ParseException e) {
				System.out.println("Invalid message!");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Determines weather a message is waiting to be read
	 * @return
	 */
	public static boolean hasNextMessage() {
		return reader.hasNext();
	}
	
	/**
	 * Gets the connection's target IP
	 * @return
	 */
	public static InetAddress getIP() {
		return TCPsendSocket.getInetAddress();
	}
}
