package com.logics.zuller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import android.R.integer;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSONResponseParser {

	private Set<Map.Entry<String, JsonElement>> jsonEntriesSet;

	public boolean createEntriesSet(String jsonString) {
		JsonParser parser = new JsonParser();
		try {
			jsonEntriesSet = parser.parse(jsonString).getAsJsonObject()
					.entrySet();
			return true;
		} catch (Exception exc) {
			return false;
		}

	}

	public JsonElement getEntrySetValue(String key) {
		if (jsonEntriesSet == null)
			return null;
		for (Entry<String, JsonElement> entry : jsonEntriesSet) {
			if (entry.getKey().equals(key))
				return entry.getValue();
		}
		return null;

	}

}
