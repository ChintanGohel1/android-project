package com.example.inch2inch;

import com.inch2inch.customer.addCustomer.AddCustomerActivity;
import com.inch2inch.customer.viewCustomers.ViewCustomerActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_home);

	Button addCustomer = (Button) findViewById(R.id.btnAddCustomer);
	Button viewCustomer = (Button) findViewById(R.id.btnViewCustomer);
	Button viewBill = (Button) findViewById(R.id.btnViewBill);

	addCustomer.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {

		Intent intent = new Intent(HomeActivity.this,
			AddCustomerActivity.class);
		startActivity(intent);
	    }
	});

	viewCustomer.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {

		Intent intent = new Intent(HomeActivity.this,
			ViewCustomerActivity.class);
		startActivity(intent);
	    }
	});

	viewBill.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {

		Intent intent = new Intent(HomeActivity.this,
			AddCustomerActivity.class);
		startActivity(intent);
	    }
	});

    }

}
