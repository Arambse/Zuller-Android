package com.zuller.models;

import com.google.gson.JsonObject;
import com.zuller.iparsables.IParsable;

public class Bar extends Place {

	@Override
	public IParsable Fill(JsonObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Bar(JsonObject jsonObj){
		super();
		Fill(jsonObj);
	}

}
