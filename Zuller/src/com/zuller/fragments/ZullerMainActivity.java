package com.zuller.fragments;

import java.util.ArrayList;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zuller.R;
import com.zuller.fragments.ParsedListViewFragment.ListFragmentInterface;
import com.zuller.fragments.ZullerMainFragment.MainZullerFragmentInterface;
import com.zuller.iparsables.Attraction;
import com.zuller.iparsables.IParsable;
import com.zuller.logics.FactoryMaker;
import com.zuller.logics.JSONResponseParser;
import com.zuller.logics.ParsingFactory;
import com.zuller.networking.NetworkManager;
import com.zuller.networking.ZullerHttpResponse;
import com.zuller.variables.ZullerConstants;

public class ZullerMainActivity extends SherlockFragmentActivity implements
		ListFragmentInterface, MainZullerFragmentInterface {

	// ----------------------------------------*****-------------------------------------------------//
	// Members
	// ----------------------------------------*****-------------------------------------------------//

	private SherlockFragment mainFragment;
	private SherlockFragment expandedFragment;
	private SherlockFragment facebookFragment;

	private NetworkManager activityNetworkManager;
	
	

	// ----------------------------------------*****-------------------------------------------------//
	// Buttons
	// ----------------------------------------*****-------------------------------------------------//

	// ----------------------------------------*****-------------------------------------------------//
	// Override Methods
	// ----------------------------------------*****-------------------------------------------------//

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		initializeMembers();
		setContentView(R.layout.activity_zuller_main);

		ZullerMainFragment zullerMainFragment = new ZullerMainFragment();
		zullerMainFragment.setCallback(this);
		

		// Create the initial list fragment
		getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, zullerMainFragment, "MainZuller").commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_zuller_main, menu);
		return (true);
	}


	// ----------------------------------------*****-------------------------------------------------//
	// private initialization Functions
	// ----------------------------------------*****-------------------------------------------------//

	private void initializeMembers() {
		activityNetworkManager = NetworkManager.getInstance();

	}

	// ----------------------------------------*****-------------------------------------------------//
	// private Button functions
	// ----------------------------------------*****-------------------------------------------------//

	// ----------------------------------------*****-------------------------------------------------//
	// ListFragment Interface Implementation
	// ----------------------------------------*****-------------------------------------------------//

	@Override
	public void ListFragmentItemSelected(Attraction attraction) {
		moveToExpandedView(attraction);

	}

	// ----------------------------------------*****-------------------------------------------------//
	// ZullerMainFragment Interface Implementation
	// ----------------------------------------*****-------------------------------------------------//
	@Override
	public void ZullerMyNightOnClick(ArrayList<Attraction> userAttractions) {
		moveToListFragment(userAttractions);

	}

	// ----------------------------------------*****-------------------------------------------------//
	// Fragment Transaction Managment
	// ----------------------------------------*****-------------------------------------------------//

	private void moveToExpandedView(Attraction attraction) {

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		ExpandedFragment expandedFragment = new ExpandedFragment();
		expandedFragment.setAttraction(attraction);
		fragmentTransaction.replace(R.id.fragment_container, expandedFragment,
				"My_ExpandedView");
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	public void moveToListFragment(ArrayList<Attraction> userAttractions) {

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		ParsedListViewFragment parsedListViewFragment = new ParsedListViewFragment();
		parsedListViewFragment.setAttractionsArrayList(userAttractions);
		parsedListViewFragment.setCallback(this);
		fragmentTransaction.replace(R.id.fragment_container,
				parsedListViewFragment, "My_ListView");
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	

}
