package Clients;
import java.io.IOException;

public class ClientGen{
   private static final String HOST = "localhost";
   private static final int PORT = 1234;
   private static String[] flightCodes = {"HZ205", "CX183", "VL001", "WD623"};
   private static int id = 0;
   
   public static void main(String[] args) throws IOException, ClassNotFoundException {
	   
	   int _READERS = 0;
	   int _WRITERS = 0;
	   
	   if(args.length != 2) {
           System.out.println("Usage: <amount of readers> <amount of writers>");
           System.exit(1);
       }
       try{
           _READERS = Integer.parseInt(args[0]);
           _WRITERS = Integer.parseInt(args[1]);
       }catch(NumberFormatException e){
           System.out.println("Invalid argument format.");
           System.exit(1);
       }
       
	   for(int i = 0; i < _READERS; i++)
		   new ClientReader().start();
	   
	   for(int j = 0; j < _WRITERS; j++)
		   new ClientWriter().start();

   }

}
