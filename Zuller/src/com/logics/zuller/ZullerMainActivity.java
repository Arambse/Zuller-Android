package com.logics.zuller;

import com.iparsables.zuller.Attraction;
import com.iparsables.zuller.IParsable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class ZullerMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zuller_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_zuller_main, menu);
		FactoryMaker factoryMaker = new FactoryMaker();
		ParsingFactory factory = factoryMaker.getFactory("AttractionFactory");
		IParsable t = factory.Parse(new Object());
		return true;
	}

}
