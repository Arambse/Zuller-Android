package com.zuller.logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import android.net.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.zuller.iparsables.Attraction;
import com.zuller.iparsables.IParsable;

public interface ParsingFactory {

	public ArrayList<Attraction> getParsedObjectsListFromJsonArray(JsonArray jsonArray);
	public Attraction getParsedObject(Entry<String, JsonElement> jsonEntry);
}
