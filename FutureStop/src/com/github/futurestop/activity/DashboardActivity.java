/**
 * 
 */
package com.github.futurestop.activity;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import com.github.futurestop.builder.RiderBuilder;
import com.github.futurestop.loader.FSLoader;
import com.github.futurestop.model.FSResult;
import com.github.futurestop.request.FSRequest;

/**
 * @author Chung-Yi Cho
 * 
 */
public class DashboardActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<FSResult<String>> {
	@SuppressWarnings("unchecked")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Hello Home Activity, hi.");
		setContentView(tv);
		getLoaderManager().initLoader(0, null, (LoaderCallbacks<FSResult<String>>) this);
	}

	@Override
	public Loader<FSResult<String>> onCreateLoader(int arg0, Bundle arg1) {
		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String id = telephonyManager.getDeviceId();

		FSRequest request = new FSRequest();
		request.builder = new RiderBuilder(id);
		FSLoader loader = new FSLoader(this);
		loader.mRequest = request;
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<FSResult<String>> arg0,
			FSResult<String> arg1) {
		pollForUpdates();
	}

	@Override
	public void onLoaderReset(Loader<FSResult<String>> arg0) {
		// TODO Auto-generated method stub
	}
	
	private void pollForUpdates() {
		
	}
	
}
