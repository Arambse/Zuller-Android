package com.zuller.fragments;

import java.util.ArrayList;

import org.w3c.dom.Attr;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.facebook.Session;
import com.google.gson.JsonElement;
import com.zuller.R;
import com.zuller.iparsables.Attraction;
import com.zuller.iparsables.IParsable;
import com.zuller.logics.FactoryMaker;
import com.zuller.logics.JSONResponseParser;
import com.zuller.logics.ParsingFactory;
import com.zuller.networking.NetworkManager;
import com.zuller.networking.ZullerHttpResponse;
import com.zuller.variables.ZullerConstants;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ZullerMainFragment extends SherlockFragment {

	private NetworkManager networkManager;
	private MainZullerFragmentInterface mCallbMainZullerFragmentInterface;

	private Button zullerMyNightButton;
	private Button advancedSearchButton;
	private Button quickyButton;
	private Button button4;

	private OnClickListener zullerMyNightButtonClickListener;
	private OnClickListener advancedSearchButtonClickListener;
	private OnClickListener quickyButtonClickListener;
	private OnClickListener button4ClickListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		initializeMembers();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.zuller_main_fragment, container,
				false);
		initializeButtons(view);
		return view;
	}

	// ----------------------------------------*****-------------------------------------------------//
	// private initialization Functions
	// ----------------------------------------*****-------------------------------------------------//

	private void initializeMembers() {
		networkManager = NetworkManager.getInstance();
	}

	private void initializeButtons(View view) {
		initializeClickListeners();

		zullerMyNightButton = (Button) view
				.findViewById(R.id.button_zullerMyNight);
		zullerMyNightButton
				.setOnClickListener(zullerMyNightButtonClickListener);

		advancedSearchButton = (Button) view
				.findViewById(R.id.button_advancedSearch);
		advancedSearchButton
				.setOnClickListener(advancedSearchButtonClickListener);

		quickyButton = (Button) view.findViewById(R.id.button_quicky);
		quickyButton.setOnClickListener(quickyButtonClickListener);

		button4 = (Button) view.findViewById(R.id.button_button4);
		button4.setOnClickListener(button4ClickListener);
	}

	private void initializeClickListeners() {
		zullerMyNightButtonClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				ArrayList<Attraction> attractionsForUser = getAttractionsFromServer();
				mCallbMainZullerFragmentInterface.ZullerMyNightOnClick(attractionsForUser);

			}
		};
		advancedSearchButtonClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getSherlockActivity(), String.format("AcessToken is %s", Session.getActiveSession().getAccessToken()), Toast.LENGTH_LONG).show();

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
	// private Button functions
	// ----------------------------------------*****-------------------------------------------------//

	private ArrayList<Attraction> getAttractionsFromServer() {
		
		ZullerHttpResponse httpResponse = networkManager.RequestPost(
				ZullerConstants.ZULLER_POST_SEARCH_HTTP, null);
		String responseString;
		ArrayList<Attraction> parsedListToReturn = null;
		
		if (httpResponse.succeeded)
			responseString = httpResponse.getResponse();
		else
			responseString = "";
		JSONResponseParser responseParser = new JSONResponseParser();
		boolean couldParse = responseParser.createEntriesSet(responseString);
		if (couldParse) {
			JsonElement attractionEntry = responseParser
					.getEntrySetValue(ZullerConstants.ATTRACTION_ENTRY_NAME);
			if (!attractionEntry.isJsonArray()){
				parsedListToReturn =  null;
				return parsedListToReturn;
				}
			ParsingFactory attractionParserFactory = FactoryMaker
					.getFactory("AttractionFactory");
			parsedListToReturn = attractionParserFactory
					.getParsedObjectsListFromJsonArray(attractionEntry
							.getAsJsonArray());
		}
		return parsedListToReturn;
		
	}
	
	public interface MainZullerFragmentInterface {
		public void ZullerMyNightOnClick(ArrayList<Attraction> attractions);
	}
	
	public void setCallback(MainZullerFragmentInterface callback){
		this.mCallbMainZullerFragmentInterface = callback;
	}

}
