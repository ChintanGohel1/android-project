package com.inch2inch.api;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class GetAPI extends AsyncTask<String, Object, String> {

	@Override
	protected String doInBackground(String... params) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(params[0]);

		try {
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
