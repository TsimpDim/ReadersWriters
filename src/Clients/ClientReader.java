package Clients;

import java.util.Random;

import Misc.Request;

public class ClientReader extends Client{
	
	public ClientReader() {
		super("R");
	}

	@Override
	protected Request getRequest() {
		return new Request(flightCodes[new Random().nextInt(flightCodes.length)]);
	} 
}

