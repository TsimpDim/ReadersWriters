package Server;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Misc.Reply;
import Misc.Request;

import java.io.*;

public class ServerProtocol implements Serializable{
	
	private ConcurrentHashMap<String, HashMap<String, String>> flightBoard = new ConcurrentHashMap<String, HashMap<String, String>>();

	private Reply res = new Reply();
	
	public ServerProtocol(){
		// Values for initialization
		HashMap<String, String> flightCX183 = new HashMap<String, String>(){{
			put("status", "EN ROUTE");
			put("time", "07:07");
		}};
		
		HashMap<String, String> flightHZ205 = new HashMap<String, String>(){{
			put("status", "EN ROUTE");
			put("time", "17:02");
		}};

		HashMap<String, String> flightVL001 = new HashMap<String, String>(){{
			put("status", "BOARDING");
			put("time", "17:02");
		}};
		
		HashMap<String, String> flightWD623 = new HashMap<String, String>(){{
			put("status", "DEPARTING");
			put("time", "22:22");
		}};
		
		flightBoard.put("CX183", flightCX183);
		flightBoard.put("HZ205", flightHZ205);
		flightBoard.put("VL001", flightVL001);
		flightBoard.put("WD623", flightWD623);
		
		System.out.println("->INIT STATE<-");
		printBoard();
	}
	
	public Reply processRequest(Request req) {
		
		// If READ request
		if(req.getReqType().equals("READ")) {
			// And request is valid (flight code exists)
			if(flightBoard.containsKey(req.getFlightCode())) {
				res.setRow(flightBoard.get(req.getFlightCode()));
				res.setCode("ROK");
			}else {
				res.setRow(null);
				res.setCode("RERROR");
			}
		// If WRITE request
		}else {
			// And request is valid (flight code exists)
			if(flightBoard.containsKey(req.getFlightCode())) {
				String flightCode = req.getFlightCode();
				
				String status = req.getStatus();
				String time = req.getTime();
				
				HashMap<String, String> newValues = new HashMap<String, String>() {{
			        put("status", status);
			        put("time", time);
			    }};
			    
			    flightBoard.put(flightCode, newValues);
			    
			    res.setRow(null);
			    res.setCode("WOK");
			}else {
				res.setRow(null);
				res.setCode("WERROR");
			}
			printBoard();
		}
		return res;
	}
	
	private void printBoard(){
		System.out.printf("%-10s|%-10s|%-10s\n", "Flight", "Status", "Time");
		System.out.println("----------|----------|--------");
		for (Map.Entry<String, HashMap<String, String>> entry : flightBoard.entrySet()) {
			String flightCode = entry.getKey();
			String status = entry.getValue().get("status");
			String time = entry.getValue().get("time");
			
			System.out.printf("%-10s|%-10s|%-10s\n", flightCode, status, time);
			System.out.println("          |          |          ");
		}
		System.out.println("\n");
	}
}