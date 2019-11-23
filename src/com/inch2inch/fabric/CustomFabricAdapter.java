package com.inch2inch.fabric;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inch2inch.R;
import com.inch2inch.customer.bean.CustomerBean;
import com.inch2inch.fabric.beans.FabricBean;
import com.inch2inch.fabric.beans.FabricResponseBean;
import com.inch2inch.genericService.AppContainer;
import com.inch2inch.genericService.GenericService;

public class CustomFabricAdapter extends ArrayAdapter<FabricBean> {

    private final Activity context;
    private List<FabricBean> fabricBeans;
    
    public CustomFabricAdapter(Activity context, List<FabricBean> objects) {
	super(context, R.layout.fabriccard, objects);
	this.context = context;
	this.fabricBeans = objects;
    }

    @SuppressWarnings("static-access")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

	LayoutInflater layoutInflater = context.getLayoutInflater();
	View view = layoutInflater.inflate(R.layout.fabriccard, null, true);

	TextView fabricName = (TextView) view.findViewById(R.id.fabricName);
	TextView fabricPrice = (TextView) view.findViewById(R.id.fabricPrice);

	ImageView imageView = (ImageView) view.findViewById(R.id.imgFabric);

		    try {
			imageView.setImageBitmap(new ImageAPI()
			    .execute(fabricBeans.get(position).getImage_path()).get());
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		    fabricName.setText("Name : "
			    + fabricBeans.get(position).getFabric_type());
		    fabricPrice.setText("Price : "
			    + fabricBeans.get(position).getPrice() + "RS");

	return view;
    }

}
