/**
 * 
 */
package com.github.futurestop.builder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

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
		String ETA = generateETA();
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost();
			postRequest.setURI(URI.create(url.trim()));
			StringEntity dataSentToServer;
			dataSentToServer = new StringEntity(ETA.trim(), HTTP.UTF_8);
			postRequest.setEntity(dataSentToServer);
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
    
    private String generateETA() {
    	//TODO: Use Gson. Randomize ETA. Maybe base it off a user selected location.
    	return "{ \"eta\" : \" 5000 \" }";
    }
}
