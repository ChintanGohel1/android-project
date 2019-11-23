package com.inch2inch.customer.viewCustomers;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inch2inch.R;
import com.inch2inch.customer.bean.CustomerBean;

public class CustomAdapter extends ArrayAdapter<CustomerBean> {

    private final Activity context;
    private List<CustomerBean> customerBeans;

    public CustomAdapter(Activity context, List<CustomerBean> objects) {
	super(context, R.layout.card, objects);
	this.context = context;
	this.customerBeans = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

	LayoutInflater layoutInflater = context.getLayoutInflater();
	View view = layoutInflater.inflate(R.layout.card, null, true);

	TextView customerName = (TextView) view.findViewById(R.id.customerName);
	TextView customerMobile = (TextView) view
		.findViewById(R.id.customerMobile);
	TextView customerEmail = (TextView) view
		.findViewById(R.id.customerEmail);
	TextView customerAddress = (TextView) view
		.findViewById(R.id.customerAddress);

	customerName.setText(" Name  :   " + customerBeans.get(position).getName());
	customerMobile.setText(" Mobile  :   " + customerBeans.get(position).getMobile());
	customerEmail.setText(" Email  :   " + customerBeans.get(position).getEmail());
	customerAddress.setText(" Address  :   " + customerBeans.get(position).getAddress());

	return view;
    }
     

}
