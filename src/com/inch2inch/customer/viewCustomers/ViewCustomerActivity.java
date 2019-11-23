package com.inch2inch.customer.viewCustomers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inch2inch.R;
import com.inch2inch.api.GetAPI;
import com.inch2inch.customer.bean.CustomerBean;
import com.inch2inch.customer.bean.CustomerResponseBean;
import com.inch2inch.fabric.ViewFabricActivity;
import com.inch2inch.genericService.GenericService;

public class ViewCustomerActivity extends Activity {

    // ArrayAdapter<CustomerBean> customerAdapter = new
    // ArrayAdapter<CustomerBean>(getApplicationContext(),
    // android.R.layout.simple_list_item_1,)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_view_customer);

	CustomerResponseBean customerResponseBean = new CustomerResponseBean();
	final List<CustomerBean> customerBeans = new ArrayList<CustomerBean>();

	JSONObject jsonObject = GenericService.get("getAllCustomers.php");
	JSONArray jsonArray = null;
	try {
	    jsonArray = jsonObject.getJSONArray("customers");

	    for (int i = 0; i < jsonArray.length(); i++) {
		CustomerBean customerBean2 = GenericService
			.convertJsonObjectTOJavaObject(CustomerBean.class,
				jsonArray.getJSONObject(i));
		customerBeans.add(customerBean2);
	    }
	    customerResponseBean.setCustomerBeans(customerBeans);

	} catch (JSONException e) {
	    e.printStackTrace();
	}

	Log.i("customerResponseBean", customerResponseBean.toString());

	ListView listView = (ListView) findViewById(R.id.lstViewCustomerView);

	CustomAdapter customAdapter = new CustomAdapter(this,
		customerResponseBean.getCustomerBeans());
	listView.setAdapter(customAdapter);

	listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	    @Override
	    public void onItemClick(AdapterView<?> arg0, View view,
		    int position, long id) {

		Intent intent = new Intent(ViewCustomerActivity.this,
			ViewFabricActivity.class);
		intent.putExtra("customerId", customerBeans.get(position).retriveCustomerId());
		startActivity(intent);
		// customerBeans.get(position);
	    }

	});

    }
}
