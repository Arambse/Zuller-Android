package com.fragments.zuller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.iparsables.zuller.Attraction;
import com.logics.zuller.R;

public class ParsedListViewFragment extends SherlockListFragment {
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		return inflater.inflate(R.layout.parsable_list_fragment, container, false);
		  }
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        ArrayList<Attraction> attArray = new ArrayList<Attraction>();
		ArrayAdapter<Attraction> attractionAdapter = new ArrayAdapter<Attraction>(getSherlockActivity(), R.layout.zuller_item_cell,attArray);
		setListAdapter(attractionAdapter);
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    }
}
