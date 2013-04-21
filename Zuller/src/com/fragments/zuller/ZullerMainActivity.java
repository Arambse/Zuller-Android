package com.fragments.zuller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.iparsables.zuller.IParsable;
import com.logics.zuller.FactoryMaker;
import com.logics.zuller.ParsingFactory;
import com.logics.zuller.R;
import com.variables.zuller.ZullerConstants;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;


public class ZullerMainActivity extends SherlockActivity {

	private SherlockFragment mainFragment;
	private SherlockFragment expandedFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_zuller_main);

		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(ZullerConstants.ZULLER_GETSEARCH_HTTP);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity response = httpResponse.getEntity();
			String jSONResposnseString = EntityUtils.toString(response);
			Log.d("JSONDebug", jSONResposnseString);

			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray Jarray = parser.parse(jSONResposnseString)
					.getAsJsonArray();

			FactoryMaker factoryMaker = new FactoryMaker();
			ParsingFactory factory = factoryMaker
					.getFactory("AttractionFactory");

			for (JsonElement obj : Jarray) {
				Log.d("JSONDebug", obj.toString());
				IParsable t = factory.getParsedObject(obj, "JSON");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			Log.d("JSONDebug", e.getMessage());
		}

	}


}
