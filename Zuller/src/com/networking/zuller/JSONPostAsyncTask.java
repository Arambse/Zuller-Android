package com.networking.zuller;

import java.util.HashMap;

import com.networking.zuller.AsyncTaskNetworkParams.AsyncTaskPostNetworkParams;

import android.R.integer;
import android.content.Context;
import android.os.AsyncTask;

public class JSONPostAsyncTask extends
		AsyncTask<AsyncTaskPostNetworkParams, integer, ZullerHttpResponse> {
	private NetworkManager networkManager;
    private Context cosntext;
	
	
	public NetworkManager getNetworkManager() {
		return networkManager;
	}

	public void setNetworkManager(NetworkManager networkManager) {
		this.networkManager = networkManager;
	}

	@Override
	protected ZullerHttpResponse doInBackground(
			AsyncTaskPostNetworkParams... params) {
		// TODO Auto-generated method stub
		if (networkManager == null)
			networkManager = new NetworkManager();
		String urlOfRequest = params[0].getUrl();
		HashMap<String, String> postDataOfRequest = params[0]
				.getPostDataHashMap();
		return networkManager.RequestPost(urlOfRequest, postDataOfRequest);

	}
    protected void onProgressUpdate(Integer... progress) {
     
    }

    protected void onPostExecute(Long result) {
       
    }

}
