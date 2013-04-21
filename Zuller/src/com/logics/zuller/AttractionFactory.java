package com.logics.zuller;

import android.R.string;

import com.deserializers.zuller.BarDeserializer;
import com.deserializers.zuller.ClubDeserializer;
import com.deserializers.zuller.LineDeserializer;
import com.deserializers.zuller.PartyDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iparsables.zuller.Attraction;
import com.iparsables.zuller.IParsable;
import com.models.zuller.*;

public class AttractionFactory implements ParsingFactory {

	private static final int ATTRACTION_TYPE_ERROR = -1;
	private static final int BAR = 0;
	private static final int CLUB = 1;
	private static final int LINE = 2;
	private static final int EVENT = 3;

	private Gson gsonParser;

	@Override
	public IParsable getParsedObject(Object object, String objectType) {
		if (objectType == "JSON")
			return ParseJSON((JsonElement) object);
		return null;
	}

	public IParsable ParseJSON(JsonElement jsonElement) {
		// TODO check if Object is really a good JSON object
		return createAttraction(jsonElement.getAsJsonObject());
	}

	private Attraction createAttraction(JsonObject jsonObject) {

		String type = jsonObject.get("type").toString();
		int attractionAsInt = gettAttractionTypeInInt(type);

		Attraction attraction;

		switch (attractionAsInt) {
		case BAR:
			attraction = gsonParser.fromJson(jsonObject, Bar.class);
			break;
		case CLUB:
			attraction = gsonParser.fromJson(jsonObject, Party.class);
			break;
		case LINE:
			attraction = gsonParser.fromJson(jsonObject, Line.class);
			break;
		case EVENT:
			attraction = gsonParser.fromJson(jsonObject, Event.class);
			break;
		case ATTRACTION_TYPE_ERROR:
			attraction = null;
		default:
			attraction = null;
			break;
		}

		return attraction;
	}

	private int gettAttractionTypeInInt(String type) {
		if (type == "Bar")
			return BAR;
		else if (type == "Club")
			return CLUB;
		else if (type == "Line")
			return LINE;
		else if (type == "Event")
			return EVENT;
		return -1;

	}

	public AttractionFactory() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		gsonBuilder
		        .registerTypeAdapter(Bar.class, new BarDeserializer())
				.registerTypeAdapter(Club.class, new ClubDeserializer())
				.registerTypeAdapter(Line.class, new LineDeserializer())
				.registerTypeAdapter(Party.class, new PartyDeserializer());

		gsonParser = gsonBuilder.create();
	}

}
