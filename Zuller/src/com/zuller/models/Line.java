package com.zuller.models;

import com.google.gson.JsonObject;
import com.zuller.iparsables.IParsable;

public class Line extends Event{

	@Override
	public IParsable Fill(JsonObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}
	public Line(JsonObject jsonObj){
		super();
		Fill(jsonObj);
	}


}
