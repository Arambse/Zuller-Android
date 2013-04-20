package com.networking.zuller;

import android.R.bool;

public class ZullerHttpResponse {
	
	public boolean succeeded;
	public String response;
	
    
     public ZullerHttpResponse(boolean succeeded, String response){
    	 this.succeeded = succeeded;
    	 this.response = response;
     }
	
	public boolean isSucceeded() {
		return succeeded;
	}
	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
