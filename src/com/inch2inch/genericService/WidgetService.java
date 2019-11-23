package com.inch2inch.genericService;

import android.app.Activity;
import android.widget.EditText;

public class WidgetService extends Activity  {

	public  String getStringFromEditText(int id) {
		EditText edtEditText = (EditText) findViewById(id);
		return edtEditText.getText().toString().trim();
	}
	
}
