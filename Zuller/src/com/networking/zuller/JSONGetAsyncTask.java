package com.networking.zuller;

import android.R.integer;
import android.content.Context;
import android.os.AsyncTask;

public class JSONGetAsyncTask extends
		AsyncTask<AsyncTaskNetworkParams, Integer, ZullerHttpResponse> {
	private NetworkManager networkManager;
	private Context context;

	public NetworkManager getNetworkManager() {
		return networkManager;
	}

	public void setNetworkManager(NetworkManager networkManager) {
		this.networkManager = networkManager;
	}

	@Override
	protected ZullerHttpResponse doInBackground(
			AsyncTaskNetworkParams... params) {
		if (networkManager == null)
			networkManager = new NetworkManager();
		return networkManager.RequestGet(params[0].getUrl());

	}
	
    protected void onProgressUpdate(Integer... progress) {
        
    }

    protected void onPostExecute(Long result) {
      
    }

}
