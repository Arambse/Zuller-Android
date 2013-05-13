package com.fragments.zuller;

import java.util.ArrayList;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.google.gson.JsonElement;
import com.iparsables.zuller.IParsable;
import com.logics.zuller.FactoryMaker;
import com.logics.zuller.JSONResponseParser;
import com.logics.zuller.ParsingFactory;
import com.logics.zuller.R;
import com.networking.zuller.NetworkManager;
import com.networking.zuller.ZullerHttpResponse;
import com.variables.zuller.ZullerConstants;

public class ZullerMainActivity extends SherlockActivity {

	// ----------------------------------------*****-------------------------------------------------//
	//Members
	// ----------------------------------------*****-------------------------------------------------//
	
	private SherlockFragment mainFragment;
	private SherlockFragment expandedFragment;
	private NetworkManager activityNetworkManager;

	// ----------------------------------------*****-------------------------------------------------//
	//Buttons
	// ----------------------------------------*****-------------------------------------------------//
	private Button zullerMyNightButton;
	private Button advancedSearchButton;
	private Button quickyButton;
	private Button button4;

	private OnClickListener zullerMyNightButtonClickListener;
	private OnClickListener advancedSearchButtonClickListener;
	private OnClickListener quickyButtonClickListener;
	private OnClickListener button4ClickListener;

	
	// ----------------------------------------*****-------------------------------------------------//
	//Override Methods
	// ----------------------------------------*****-------------------------------------------------//
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zuller_main);
		initializeMembers();
		initializeButtons();

		ZullerHttpResponse httpResponse = activityNetworkManager.RequestPost(
				ZullerConstants.ZULLER_POST_SEARCH_HTTP, null);
		String responseString;
		if (httpResponse.succeeded)
			responseString = httpResponse.getResponse();
		else
			responseString = "";
		JSONResponseParser responseParser = new JSONResponseParser();
		boolean couldParse = responseParser.createEntriesSet(responseString);
		if (couldParse) {
			JsonElement attractionEntry = responseParser
					.getEntrySetValue(ZullerConstants.ATTRACTION_ENTRY_NAME);
			if (!attractionEntry.isJsonArray())
				return;
			ParsingFactory attractionParserFactory = FactoryMaker
					.getFactory("AttractionFactory");
			ArrayList<IParsable> parsedObjectsList = attractionParserFactory
					.getParsedObjectsListFromJsonArray(attractionEntry
							.getAsJsonArray());
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_zuller_main, menu);
		return (true);
	}
	

	// ----------------------------------------*****-------------------------------------------------//
	//private initialization Functions
	// ----------------------------------------*****-------------------------------------------------//
	
	private void initializeMembers() {
		activityNetworkManager = new NetworkManager();
	}
	private void initializeButtons() {
		initializeClickListeners();
		zullerMyNightButton = (Button) findViewById(R.id.button_zullerMyNight);
		advancedSearchButton = (Button) findViewById(R.id.button_advancedSearch);
		quickyButton = (Button) findViewById(R.id.button_quicky);
		button4 = (Button) findViewById(R.id.button_button4);
	}
	private void initializeClickListeners() {
		zullerMyNightButtonClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		};
		advancedSearchButtonClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		};
		quickyButtonClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		};
		button4ClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		};
	}

	// ----------------------------------------*****-------------------------------------------------//
	//private Button functions
	// ----------------------------------------*****-------------------------------------------------//
		
	
	
}
