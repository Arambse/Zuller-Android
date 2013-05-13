package com.logics.zuller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.R.integer;
import android.R.string;
import android.util.Log;

import com.deserializers.zuller.BarDeserializer;
import com.deserializers.zuller.ClubDeserializer;
import com.deserializers.zuller.LineDeserializer;
import com.deserializers.zuller.PartyDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

	
	public AttractionFactory() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		gsonBuilder.registerTypeAdapter(Bar.class, new BarDeserializer())
				.registerTypeAdapter(Club.class, new ClubDeserializer())
				.registerTypeAdapter(Line.class, new LineDeserializer())
				.registerTypeAdapter(Party.class, new PartyDeserializer());

		gsonParser = gsonBuilder.create();
	}
	
	
	// ----------------------------------------*****-------------------------------------------------//
	// Abstract Implementaion
	// ----------------------------------------*****-------------------------------------------------//

	
	@Override
	public IParsable getParsedObject(Entry<String, JsonElement> attractionEntry) {
		return ParseJSON((Entry<String, JsonElement>) attractionEntry);
	}

	@Override
	public ArrayList<IParsable> getParsedObjectsListFromJsonArray(
			JsonArray jsonArray) {

		ArrayList<IParsable> parsablesList = new ArrayList<IParsable>();
		for (JsonElement jsonElement : jsonArray)
		{
			Set<Entry<String, JsonElement>> jsonEntries = jsonElement.getAsJsonObject().entrySet();
			for(Entry<String, JsonElement> jsonEntry : jsonEntries)
			{
				Log.d("JSONDebug",String.format("Proccessing %s", jsonEntry.getKey()));
				parsablesList.add(getParsedObject(jsonEntry));
			}
		}


		return parsablesList;

	}

	// ----------------------------------------*****-------------------------------------------------//
	// End of Abstract Implementaion
	// ----------------------------------------*****-------------------------------------------------//

	public IParsable ParseJSON(Entry<String, JsonElement> attractionEntry) {
		// TODO check if Object is really a good JSON object
		IParsable iParsable = createAttraction(attractionEntry);
		return iParsable;
	}

	private Attraction createAttraction(
			Entry<String, JsonElement> attractionEntry) {

		String type = attractionEntry.getKey();
		JsonElement entryValue = attractionEntry.getValue();
		int attractionAsInt = getAttractionTypeInInt(type);

		Attraction attraction;

		switch (attractionAsInt) {
		case BAR:
			attraction = gsonParser.fromJson(entryValue, Bar.class);
			break;
		case CLUB:
			attraction = gsonParser.fromJson(entryValue, Party.class);
			break;
		case LINE:
			attraction = gsonParser.fromJson(entryValue, Line.class);
			break;
		case EVENT:
			attraction = gsonParser.fromJson(entryValue, Event.class);
			break;
		case ATTRACTION_TYPE_ERROR:
			attraction = null;
		default:
			attraction = null;
			break;
		}

		return attraction;
	}

	private int getAttractionTypeInInt(String type) {
		if (type.equals("Bar"))
			return BAR;
		else if (type.equals("Club"))
			return CLUB;
		else if (type.equals("Line"))
			return LINE;
		else if (type.equals("Event"))
			return EVENT;
		return -1;

	}




}
