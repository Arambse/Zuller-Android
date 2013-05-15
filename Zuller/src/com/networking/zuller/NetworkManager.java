package com.networking.zuller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class NetworkManager {

	private static NetworkManager instance = null;

	protected NetworkManager() {
		// Exists only to defeat instantiation.
	}

	public static NetworkManager getInstance() {
		if (instance == null) {
			instance = new NetworkManager();
		}
		return instance;
	}

	public ZullerHttpResponse RequestGet(String url) {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGetRequest = new HttpGet(url);
		HttpResponse httpResponse;
		boolean success = true;
		String responseAsString;
		try {
			httpResponse = httpClient.execute(httpGetRequest);
			HttpEntity response = httpResponse.getEntity();
			responseAsString = EntityUtils.toString(response);
		} catch (ClientProtocolException clientProtocolException) {
			success = false;
			responseAsString = clientProtocolException.getMessage();
		} catch (IOException ioException) {
			success = false;
			responseAsString = ioException.getMessage();
		} catch (ParseException parseException) {
			success = false;
			responseAsString = parseException.getMessage();
		}

		return new ZullerHttpResponse(success, responseAsString);

	}

	public ZullerHttpResponse RequestPost(String url,
			HashMap<String, String> postDataHashMap) {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPostRequest = new HttpPost(url);

		HttpResponse httpResponse;
		boolean success = true;
		String responseAsString;

		ArrayList<NameValuePair> postDataArrayList = createPostArray(postDataHashMap);
		try {
			httpPostRequest.setEntity(new UrlEncodedFormEntity(
					postDataArrayList));
			httpResponse = httpClient.execute(httpPostRequest);
			HttpEntity response = httpResponse.getEntity();
			responseAsString = EntityUtils.toString(response);

		} catch (ClientProtocolException clientProtocolException) {
			success = false;
			responseAsString = clientProtocolException.getMessage();
		} catch (IOException ioException) {
			success = false;
			responseAsString = ioException.getMessage();
		}

		return new ZullerHttpResponse(success, responseAsString);

	}

	private ArrayList<NameValuePair> createPostArray(
			HashMap<String, String> hashMap) {

		if (hashMap == null)
			return new ArrayList<NameValuePair>();

		ArrayList<NameValuePair> postPairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> postDataEntry : hashMap.entrySet()) {
			postPairs.add(new BasicNameValuePair(postDataEntry.getKey(),
					postDataEntry.getValue()));
		}
		return postPairs;
	}

}
