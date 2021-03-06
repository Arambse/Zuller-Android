package com.zuller.deserializers;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zuller.models.Party;

public class PartyDeserializer implements JsonDeserializer<Party>{

	@Override
	public Party deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		// TODO Auto-generated method stub
		JsonObject jobject = (JsonObject) json;
		return new Party(jobject);
	}

}
