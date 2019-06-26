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
	
	public static void init() {
		connectToDS();
		createPrintStream();
		createScanner();
	}
	
	public static void connectToDS(){
		try {
			ServerSocket ss = new ServerSocket(4590);
			s = ss.accept();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createScanner() {
		try {
			reader = new Scanner(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createPrintStream() {
		try {
			ps = new PrintStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendMessage(JSONArray msg) {
		ps.println(msg);
	}
	
	public static JSONArray getNextMsg() {
		try {
			return (JSONArray) parser.parse(reader.nextLine());
		} catch (ParseException e) {
			System.out.println("Invalid message!");
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean hasNextMessage() {
		return reader.hasNext();
	}
}
