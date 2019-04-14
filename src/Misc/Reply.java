package Misc;
import java.io.*;
import java.util.*;

public class Reply implements Serializable {

	private String code;
	private HashMap<String, String> row;
	   
	public Reply(){
		code = "";
		row = new HashMap<String, String>();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public HashMap<String, String> getRow() {
		return row;
	}
	
	public void setRow(HashMap<String, String> row) {
		this.row = row;
	}
   
   
}

