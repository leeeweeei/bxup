package com.wang.utility;

public enum Imgtype {
	
	STRING_EVENT("1"),
	STRING_BANNER("2"),
	STRING_ICON("3"),
	
	INT_EVENT(1),
	INT_BANNER(2),
	INT_ICON(3);
	
	String stringValue = new String();  
	private int intVlue;
	
	private Imgtype(String stringValue){  
		         this.stringValue = stringValue;  
		     }  
	 private Imgtype(int intVlue){  
		          this.intVlue = intVlue;  
		      }  	 
	    public String getStringValue() {  
	    	        return stringValue;  
	    	    }  	    	  
	    	    public int getIntVlue() {  
	    	        return intVlue;  
	    	    }  
}
