package com.networking.zuller;

import java.util.HashMap;

import com.networking.zuller.AsyncTaskNetworkParams.AsyncTaskPostNetworkParams;

import android.R.integer;
import android.os.AsyncTask;

public class JSONPostAsyncTask extends
		AsyncTask<AsyncTaskPostNetworkParams, integer, Long> {
	private NetworkManager networkManager;

	public NetworkManager getNetworkManager() {
		return networkManager;
	}

	public void setNetworkManager(NetworkManager networkManager) {
		this.networkManager = networkManager;
	}

	@Override
	protected Long doInBackground(AsyncTaskPostNetworkParams... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
