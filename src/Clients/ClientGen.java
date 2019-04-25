package Clients;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ClientGen{

   public static void main(String[] args){
	   
        int _READERS = 0;
        int _WRITERS = 0;
        Client[] clients;

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

        clients = new Client[_READERS + _WRITERS];
        for(int i = 0; i < _READERS; i++)
           clients[i] = new ClientReader();

        for(int j = _READERS; j < _WRITERS + _READERS; j++)
           clients[j] = new ClientWriter();

        shuffleArray(clients);

        for(Client c : clients)
            c.start();
   }

    // https://stackoverflow.com/a/1520212
    static void shuffleArray(Client[] ar){
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Client a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}

