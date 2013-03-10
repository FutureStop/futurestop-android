/**
 * 
 */
package com.github.futurestop.builder;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.github.futurestop.model.FSResult;
import com.github.futurestop.request.FSRequest;

/**
 * @author Chung-Yi Cho
 *
 */
public class RiderBuilder implements IBuilder {

	public static final String URL = "www";
	private String mId;
	
    public RiderBuilder(String id) {
    	mId = id;
    }
	
    @Override
	public <T> FSResult<T> execute(FSRequest reqeust) {
		String url = URL + mId;

		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost();
		postRequest.setURI(URI.create(url.trim()));
		try {
			client.execute(postRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
