package com.zuller.models;

import com.google.gson.JsonObject;
import com.zuller.iparsables.IParsable;

public class Club extends Place {

	@Override
	public IParsable Fill(JsonObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}
	public Club(JsonObject jsonObj){
		super();
		Fill(jsonObj);
	}

}
