package com.fragments.zuller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.w3c.dom.Attr;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.fragments.zuller.ZullerMainFragment.MainZullerFragmentInterface;
import com.google.gson.JsonObject;
import com.iparsables.zuller.Attraction;
import com.iparsables.zuller.IParsable;
import com.logics.zuller.R;

public class ParsedListViewFragment extends SherlockListFragment {

	private ArrayList<Attraction> mAttractions;
	private ListFragmentInterface mCallbackListFragmentInterface;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.parsable_list_fragment,
				container, false);

		if (mAttractions == null)
			mAttractions = new ArrayList<Attraction>();
		ArrayAdapter<Attraction> adapter = new ArrayAdapter<Attraction>(
				getSherlockActivity(), android.R.layout.simple_list_item_1,
				mAttractions);
		setListAdapter(adapter);

		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mCallbackListFragmentInterface.ListFragmentItemSelected(mAttractions
				.get(position));
	}

	public void setAttractionsArrayList(ArrayList<Attraction> attractions) {
		mAttractions = attractions;
	}

	public interface ListFragmentInterface {
		public void ListFragmentItemSelected(Attraction attraction);
	}
	public void setCallback(ListFragmentInterface callback){
		this.mCallbackListFragmentInterface = callback;
	}

}
