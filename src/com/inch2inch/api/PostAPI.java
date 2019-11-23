package com.inch2inch.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class PostAPI extends AsyncTask<String, Object, String> {

	@Override
	protected String doInBackground(String... params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(params[0]);

		try {
			List<NameValuePair> param = new ArrayList<NameValuePair>(2);
			param.add(new BasicNameValuePair("data", params[1]));
			request.setEntity(new UrlEncodedFormEntity(param, "UTF-8"));

			HttpResponse response = client.execute(request);
			Scanner s = new Scanner(response.getEntity().getContent())
					.useDelimiter("\\A");
			return s.hasNext() ? s.next() : "";
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e("ERROR", "Something went wrong!", e);
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("ERROR", "Something went wrong!", e);
		}

		return "";
	}

}
