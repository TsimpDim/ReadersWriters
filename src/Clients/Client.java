package Clients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import Misc.Reply;
import Misc.Request;

public abstract class Client extends Thread{
   private static final String HOST = "localhost";
   private static final int PORT = 1234;
   protected static String[] flightCodes = {"HZ205", "CX183", "VL001", "WD623"};
   private static int id = 0;
   private String name;
   
   public Client(String type){
	   name = "C"+(++id)+"["+type+"]";
   }
   
   @Override
   public void run(){
	   try{
		    Socket socketConnection = new Socket(HOST, PORT);
	
	
		 	ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
			ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
	
			System.out.println(this.name + " sending request");
			Request req = getRequest();
	
			clientOutputStream.writeObject(req);
			Reply rep = (Reply)clientInputStream.readObject();
			
			// Single printf so the messages are not spread out
			System.out.printf("%s received a reply:\n\tReply opcode = %s | Reply value = %s\n", this.name, rep.getCode(), rep.getRow());
			 
			clientOutputStream.close();
			clientInputStream.close();
			socketConnection.close();   
			
		// :(
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
   
   protected abstract Request getRequest();
}
