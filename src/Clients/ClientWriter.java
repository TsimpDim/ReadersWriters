package Clients;

import java.util.Random;

import Misc.Request;

public class ClientWriter extends Client{

	private String[] statuses = {"DEPARTING", "EN ROUTE", "BOARDING", "CANCELLED"};
	private String[] times = {"12:03", "12:31", "03:53", "13:26"};
	
	public ClientWriter() {
		super("W");
	}

	@Override
	protected Request getRequest() {
		int rnd = new Random().nextInt(flightCodes.length);
		return new Request(flightCodes[rnd], statuses[rnd], times[rnd]);
	} 

}

