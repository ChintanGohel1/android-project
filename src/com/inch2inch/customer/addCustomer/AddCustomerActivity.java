package com.inch2inch.customer.addCustomer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.inch2inch.R;
import com.inch2inch.customer.bean.CustomerBean;
import com.inch2inch.customer.bean.CustomerResponseBean;
import com.inch2inch.genericService.AppContainer;
import com.inch2inch.genericService.GenericService;

public class AddCustomerActivity extends Activity {
    Button buttonAddCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_add_customer);
	buttonAddCustomer = (Button) findViewById(R.id.btnAdd);

	buttonAddCustomer.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// CustomerBean customerBean = new CustomerBean(
		// AppContainer.getWidgetService().getStringFromEditText(R.id.edtName),
		// AppContainer.getWidgetService().getStringFromEditText(R.id.edtEmail),
		// AppContainer.getWidgetService().getStringFromEditText(R.id.edtMobile),
		// AppContainer.getWidgetService().getStringFromEditText(R.id.edtAddress),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtChest)),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtNeck)),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtWaist)),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtPantLength)),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtSleaveLength)),
		// Double.parseDouble(AppContainer.getWidgetService().getStringFromEditText(R.id.edtShirtLength)));

		CustomerBean customerBean = new CustomerBean("Chintan",
			"gohel762@gmail.com", "7802801758", "gota", 22.22,
			22.22, 22.22, 22.22, 22.22, 22.22);

		String response = GenericService.save(customerBean,
			"addCustomer.php");
		Log.i("response", response);

	    }

	});

    }
}
