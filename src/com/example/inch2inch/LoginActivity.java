package com.example.inch2inch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inch2inch.customer.addCustomer.AddCustomerActivity;
import com.inch2inch.customer.viewCustomers.ViewCustomerActivity;
import com.inch2inch.fabric.ViewFabricActivity;
import com.inch2inch.genericService.AppContainer;
import com.inch2inch.genericService.GenericService;

public class LoginActivity extends Activity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);

	btnLogin = (Button) findViewById(R.id.btnLogin);

	btnLogin.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {

		EditText us= (EditText) findViewById(R.id.edtUserName);
		String userName = us.getText().toString().trim();
//		String userName = AppContainer.getWidgetService()
//			.getStringFromEditText(R.id.edtUserName);
		EditText ps= (EditText) findViewById(R.id.edtPassword);
		String password = ps.getText().toString().trim();
		LoginRequestBean loginRequestBean = new LoginRequestBean();
		loginRequestBean.setUserName(userName);
		loginRequestBean.setPassword(password);

		if (userName.contains("@")) {
		    String response = GenericService.save(loginRequestBean,
			    "loginEmail.php");
		    Log.i("response", response);
		} else if (userName.length() == 10
			&& !(userName.matches("[a-zA-Z]"))) {
		    String response = GenericService.save(loginRequestBean,
			    "loginMobile.php");
		    Log.i("response", response);
		} else {
		    Toast.makeText(getApplicationContext(),
			    "Invalid UserName OR PassWord", Toast.LENGTH_LONG);
		}

	    }

	});

    }
    
    public void redirecrPage(){
	 Toast.makeText(getApplicationContext(),
		    "Login Successfull", Toast.LENGTH_LONG);
	Intent intent = new Intent(LoginActivity.this,
		AddCustomerActivity.class);
	startActivity(intent);
    }
    
}
