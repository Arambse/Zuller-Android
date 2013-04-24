package com.fragments.zuller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class ParsedListViewFragment extends SherlockFragment {
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
//		    View view = inflater.inflate(R.layout.fragment_rssitem_detail,
//		        container, false);	
		    return  new View(new Activity());
		  }
}
