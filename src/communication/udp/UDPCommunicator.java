package communication.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import communication.tcp.TCPCommunicator;

public class UDPCommunicator {
	private static DatagramSocket UDPSendSocket;
	private static DatagramSocket UDPRecSocket;
	
	private static InetAddress driverStationIP;
	private static int sendPort;
	private static int recPort;
	
	private static int msgLength = 1024;
	
	private static JSONParser parser = new JSONParser();
	
	public static void init() {
		sendPort = 4591;
		recPort = 4590;
		
		try {
			UDPSendSocket = new DatagramSocket();
			UDPRecSocket = new DatagramSocket(recPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		if(TCPCommunicator.getIP() != null) {
			driverStationIP = TCPCommunicator.getIP();
		} else {
			System.out.println("Error - No connection");
		}
	}
	
	public static void sendMessage(JSONArray msg) {
		byte[] buffer = msg.toString().getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, driverStationIP, sendPort);
		try {
			UDPSendSocket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONArray getMessage() {
		byte[] buffer = new byte[msgLength];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		try {
			UDPRecSocket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msg = new String(packet.getData());
		msg = msg.split("}]")[0] + "}]";
		JSONArray parsedMsg = null;
		try {
			parsedMsg = (JSONArray) parser.parse(msg);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedMsg;
	}
}
