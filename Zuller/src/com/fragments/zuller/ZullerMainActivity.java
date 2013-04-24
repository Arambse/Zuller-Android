package com.fragments.zuller;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.logics.zuller.R;

public class ZullerMainActivity extends SherlockActivity {

	private SherlockFragment mainFragment;
	private SherlockFragment expandedFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zuller_main);
		//
		// try {
		// DefaultHttpClient httpClient = new DefaultHttpClient();
		// HttpGet httpGet = new HttpGet(ZullerConstants.ZULLER_GETSEARCH_HTTP);
		// HttpResponse httpResponse = httpClient.execute(httpGet);
		// HttpEntity response = httpResponse.getEntity();
		// String jSONResposnseString = EntityUtils.toString(response);
		// Log.d("JSONDebug", jSONResposnseString);
		//
		// Gson gson = new Gson();
		// JsonParser parser = new JsonParser();
		// JsonArray Jarray = parser.parse(jSONResposnseString)
		// .getAsJsonArray();
		//
		// FactoryMaker factoryMaker = new FactoryMaker();
		// ParsingFactory factory = factoryMaker
		// .getFactory("AttractionFactory");
		//
		// for (JsonElement obj : Jarray) {
		// Log.d("JSONDebug", obj.toString());
		// IParsable t = factory.getParsedObject(obj, "JSON");
		// }
		//
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// } catch (ClientProtocolException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (Exception e) {
		// Log.d("JSONDebug", e.getMessage());
		// }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_zuller_main, menu);
		return true;
	}

}
