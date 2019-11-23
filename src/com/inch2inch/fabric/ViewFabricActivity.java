package com.inch2inch.fabric;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.inch2inch.HomeActivity;
import com.example.inch2inch.R;
import com.example.inch2inch.R.layout;
import com.example.inch2inch.R.menu;
import com.inch2inch.customer.bean.CustomerBean;
import com.inch2inch.customer.bean.CustomerResponseBean;
import com.inch2inch.customer.viewCustomers.CustomAdapter;
import com.inch2inch.fabric.beans.FabricBean;
import com.inch2inch.fabric.beans.FabricResponseBean;
import com.inch2inch.generateBill.GenerateBillActivity;
import com.inch2inch.genericService.AppContainer;
import com.inch2inch.genericService.GenericService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ViewFabricActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_view_fabric);

	final FabricResponseBean fabricResponseBean = FabricUtility
		.getFabricResponseBean();

	ListView listView = (ListView) findViewById(R.id.lstViewFabricsView);

	if (!fabricResponseBean.getFabricBeans().isEmpty()) {
	    CustomFabricAdapter customFabricAdapter = new CustomFabricAdapter(
		    this, fabricResponseBean.getFabricBeans());
	    listView.setAdapter(customFabricAdapter);
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View view,
			int position, long id) {
		    Intent intent = getIntent();
		    int customerId = intent.getIntExtra("customerId", 0);
		    intent = new Intent(ViewFabricActivity.this,
			    GenerateBillActivity.class);
		    intent.putExtra("customerId",customerId);
		    intent.putExtra("fabricId", fabricResponseBean
			    .getFabricBeans().get(position).getId());
		    startActivity(intent);
		}

	    });
	}
    }
}
