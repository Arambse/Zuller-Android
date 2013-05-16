/**
 * Copyright 2010-present Facebook.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zuller.fragments;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.zuller.R;
import com.zuller.fragments.ZullerMainFragment.MainZullerFragmentInterface;

public class FacebookLoginFragmentActivity extends SherlockFragmentActivity {

	private boolean isResumed = false;
	private UiLifecycleHelper uiHelper;
	private Session.StatusCallback callback = new Session.StatusCallback() {

		 @Override
		 public void call(Session session, SessionState state, Exception exception) {
			  if (session.isOpened()) {
						Intent myIntent = new Intent(FacebookLoginFragmentActivity.this,ZullerMainActivity.class);
						myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
						myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(myIntent);
						finish();
//		            Request.executeMeRequestAsync(session,
//		                    new Request.GraphUserCallback() {
//		                        @Override
//		                        public void onCompleted(GraphUser user,Response response) {
//		                            if (user != null) {
//		                             Log.i("Facebook","User ID "+ user.getId());
//		                             Log.i("Facebook","Email "+ user.asMap().get("email"));
//		                            }
//		                        }
//		                    });
		        }
		 }
};
		 


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);
		setContentView(R.layout.facebook_login_fragment);
		LoginButton authButton = (LoginButton) findViewById(R.id.login_button);
		authButton.setReadPermissions(Arrays.asList("user_likes",
				"user_status", "read_requests"));

	}

	@Override
	public void onResume() {
		super.onResume();
		uiHelper.onResume();
		isResumed = true;
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
		isResumed = false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession()
        .onActivityResult(this, requestCode, resultCode, data);
		Session session = Session.getActiveSession();

		if (session != null && session.isOpened()) {
			Intent myIntent = new Intent(FacebookLoginFragmentActivity.this,
					ZullerMainActivity.class);
			startActivity(myIntent);
			// if the session is already open, try to show the selection
			// fragment
		} else {
			// otherwise present the splash screen and ask the user to login.
		}
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

}
