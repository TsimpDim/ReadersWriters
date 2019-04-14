package Misc;
import java.io.*;

public class Request implements Serializable {

	private String reqType;
   private String flightCode;
   private String status;
   private String time;
   
   public Request(String flightCode) {
	   this.flightCode = flightCode;
	   this.reqType = "READ";
   }
   
   public Request(String flightCode, String status, String time){
	   this.flightCode = flightCode;
	   this.status = status;
	   this.time = time;
	   this.reqType = "WRITE";
   }

   public String getFlightCode() {
	   return this.flightCode;
   }
	
	public String getReqType() {
		return reqType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getTime() {
		return time;
	}
   
   
}

