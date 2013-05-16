package com.zuller.networking;

import java.util.HashMap;

import android.R.string;

class AsyncTaskNetworkParams {

    String url;

    public String getUrl() {
		return url;
	}

	AsyncTaskNetworkParams(String requestUrl){
    	this.url = requestUrl;
    }
    
    protected class AsyncTaskPostNetworkParams extends AsyncTaskNetworkParams {

    	HashMap<String,String> postDataHashMap;
    	

    	AsyncTaskPostNetworkParams(String requestUrl) {
    		super(requestUrl);
    		// TODO Auto-generated constructor stub
    	}
    	
    	public HashMap<String, String> getPostDataHashMap() {
    		return postDataHashMap;
    	}

    	public void setPostDataHashMap(HashMap<String, String> postDataHashMap) {
    		this.postDataHashMap = postDataHashMap;
    	}
    	
    }
}


		
