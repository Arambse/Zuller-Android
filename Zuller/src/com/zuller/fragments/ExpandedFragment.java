package com.zuller.fragments;

import com.actionbarsherlock.app.SherlockFragment;
import com.zuller.R;
import com.zuller.iparsables.Attraction;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExpandedFragment extends SherlockFragment {

	private Attraction mAttraction;
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.parsable_detailed_view_fragment, container, false);           
        return view;  
		  }
	
	public void setAttraction(Attraction attraction){
		mAttraction = attraction;
	}
}
