package com.deserializers.zuller;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.models.zuller.Bar;
import com.models.zuller.Club;

public class ClubDeserializer implements JsonDeserializer<Club> {

	@Override
	public Club deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		// TODO Auto-generated method stub
		JsonObject jobject = (JsonObject) json;
		return new Club(jobject);	}

}
