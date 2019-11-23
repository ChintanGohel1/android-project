package com.inch2inch.generateBill;

import java.util.concurrent.ExecutionException;

import org.json.JSONObject;

import com.example.inch2inch.R;
import com.example.inch2inch.R.layout;
import com.inch2inch.customer.bean.CustomerBean;
import com.inch2inch.fabric.ImageAPI;
import com.inch2inch.fabric.beans.FabricBean;
import com.inch2inch.genericService.GenericService;

import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GenerateBillActivity extends Activity {
    TextView textViewCustomerName,textViewCustomerMobile,textViewCustomerAddress,textViewCustomerEmail;
    TextView textViewShirtNeck,textViewShirtLength,textViewShirtSleaveLength,textViewShirtChest;
    TextView textViewPantLength,textViewPantWaist,textViewFabricName,textViewFabricPrice,textViewBillAmount;
    Button buttonGenerateBill;
    ImageView fabricImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_generate_bill);
	
	textViewCustomerName=(TextView)findViewById(R.id.customerName);
	textViewCustomerMobile=(TextView)findViewById(R.id.customerMobile);
	textViewCustomerAddress=(TextView)findViewById(R.id.customerAddress);
	textViewCustomerEmail=(TextView)findViewById(R.id.customerEmail);
	textViewShirtNeck=(TextView)findViewById(R.id.shirtNeck);
	textViewShirtLength=(TextView)findViewById(R.id.shirtLength);
	textViewShirtChest=(TextView)findViewById(R.id.shirtChest);
	textViewPantLength=(TextView)findViewById(R.id.pantLength);
	textViewPantWaist=(TextView)findViewById(R.id.pantWaist);
	textViewFabricName=(TextView)findViewById(R.id.imageName);
	textViewFabricPrice=(TextView)findViewById(R.id.imageAmount);
	textViewBillAmount = (TextView)findViewById(R.id.billAmount);
	buttonGenerateBill=(Button)findViewById(R.id.btnGenerate);
	fabricImage=(ImageView)findViewById(R.id.fabricImage);
	
	Intent intent = getIntent();
								
	JSONObject fabricJsonObject = GenericService.get("getFabric.php?fabricId="+intent.getIntExtra("fabricId", 0));
	JSONObject customerJsonObject = GenericService.get("getCustomer.php?customerId="+intent.getIntExtra("customerId", 0));
	
	
	FabricBean fabricBean = GenericService.convertJsonObjectTOJavaObject(FabricBean.class,fabricJsonObject);
	CustomerBean customerBean = GenericService.convertJsonObjectTOJavaObject(CustomerBean.class, customerJsonObject);

	textViewCustomerName.setText("Name : " + customerBean.getName());
	textViewCustomerMobile.setText("Mobile : " + customerBean.getMobile());
	textViewCustomerAddress.setText("Address : " + customerBean.getAddress());
	textViewCustomerEmail.setText("Email : " + customerBean.getEmail());
	textViewShirtNeck.setText("Neck : " + customerBean.getNeck());
	textViewShirtChest.setText("Chest : " + customerBean.getChest());
	textViewShirtLength.setText("Length : " + customerBean.getShirt_length());
	textViewPantWaist.setText("Waist : " + customerBean.getWaist());
	textViewPantLength.setText("Length : " + customerBean.getPant_length());
	textViewFabricName.setText("Type : " + fabricBean.getFabric_type());    
	
	textViewFabricPrice.setText("Price : " + fabricBean.getPrice());
	textViewBillAmount.setText(fabricBean.getPrice()+"");
	try {
	    fabricImage.setImageBitmap(new ImageAPI().execute(fabricBean.getImage_path()).get());
	} catch (InterruptedException e) {
	    e.printStackTrace();
	} catch (ExecutionException e) {
	    e.printStackTrace();
	}
	Toast.makeText(getApplicationContext(),"Welcome into Bill Generate Bill",Toast.LENGTH_LONG).show();
    }


}
