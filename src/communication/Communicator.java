package communication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Communicator {
	
	public static Socket s;
	public static PrintStream ps;
	public static Scanner reader;
	
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
	 */
	private static void connectToDS(){
		try {
			ServerSocket ss = new ServerSocket(4590);
			s = ss.accept();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a scanner that reads messages
	 */
	private static void createScanner() {
		try {
			reader = new Scanner(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a print stream that sends messages
	 */
	private static void createPrintStream() {
		try {
			ps = new PrintStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a JSON message
	 * @param msg
	 */
	public static void sendMessage(JSONArray msg) {
		ps.println(msg);
	}
	
	/**
	 * Returns the next message in the queue
	 * @return
	 */
	public static JSONArray getNextMsg() {
		if(reader.hasNextLine()) {
			try {
				return (JSONArray) parser.parse(reader.nextLine());
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
}
