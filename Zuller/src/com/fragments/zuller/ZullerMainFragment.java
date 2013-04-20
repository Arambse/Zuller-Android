package com.fragments.zuller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class ZullerMainFragment extends Fragment{
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
//		    View view = inflater.inflate(R.layout.fragment_rssitem_detail,
//		        container, false);	
		    return  new View(new Activity());
		  }
	
}
