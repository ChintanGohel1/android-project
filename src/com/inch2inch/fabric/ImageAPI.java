package com.inch2inch.fabric;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ImageAPI extends AsyncTask<String, String, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... params) {

	try {
	    URL url = new URL("http://10.0.2.2/inch2inch/image/" + params[0]);
	    BufferedInputStream bufferedInputStream = new BufferedInputStream(
		    url.openStream());
	    return BitmapFactory
		    .decodeStream((InputStream) bufferedInputStream);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

}
