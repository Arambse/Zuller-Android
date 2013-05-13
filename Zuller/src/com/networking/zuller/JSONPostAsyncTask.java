package com.networking.zuller;

import java.util.HashMap;

import com.networking.zuller.AsyncTaskNetworkParams.AsyncTaskPostNetworkParams;

import android.R.integer;
import android.content.Context;
import android.os.AsyncTask;

public class JSONPostAsyncTask extends
		AsyncTask<AsyncTaskPostNetworkParams, integer, ZullerHttpResponse> {
	private NetworkManager networkManager;
    private Context context;
	
	
//	public NetworkManager getNetworkManager() {
//		return networkManager;
//	}
//
//	public void setNetworkManager(NetworkManager networkManager) {
//		this.networkManager = networkManager;
//	}
    
    public JSONPostAsyncTask(NetworkManager networkManagerArg)
    {
    	networkManager = networkManagerArg;
    }

	@Override
	protected ZullerHttpResponse doInBackground(
			AsyncTaskPostNetworkParams... params) {
		// TODO Auto-generated method stub
		String urlOfRequest = params[0].getUrl();
		HashMap<String, String> postDataOfRequest = params[0]
				.getPostDataHashMap();
		return networkManager.RequestPost(urlOfRequest, postDataOfRequest);

	}
    protected void onProgressUpdate(Integer... progress) {
     
    }

    protected void onPostExecute(ZullerHttpResponse result) {
       
    }

}
