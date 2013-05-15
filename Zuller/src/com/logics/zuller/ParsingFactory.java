package com.logics.zuller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import android.net.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.iparsables.zuller.Attraction;
import com.iparsables.zuller.IParsable;

public interface ParsingFactory {

	public ArrayList<Attraction> getParsedObjectsListFromJsonArray(JsonArray jsonArray);
	public Attraction getParsedObject(Entry<String, JsonElement> jsonEntry);
}
