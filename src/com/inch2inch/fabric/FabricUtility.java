package com.inch2inch.fabric;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.inch2inch.fabric.beans.FabricBean;
import com.inch2inch.fabric.beans.FabricResponseBean;
import com.inch2inch.genericService.GenericService;

public class FabricUtility {

    public static synchronized FabricResponseBean getFabricResponseBean() {
	FabricResponseBean fabricResponseBean = new FabricResponseBean();
	List<FabricBean> fabricBeans = new ArrayList<FabricBean>();

	JSONObject jsonObject = GenericService.get("getAllFebrics.php");
	JSONArray jsonArray = null;
	try {
	    jsonArray = jsonObject.getJSONArray("fabrics");

	    for (int i = 0; i < jsonArray.length(); i++) {
		FabricBean fabricBean = GenericService
			.convertJsonObjectTOJavaObject(FabricBean.class,
				jsonArray.getJSONObject(i));
		fabricBeans.add(fabricBean);
	    }
	    fabricResponseBean.setFabricBeans(fabricBeans);

	    Log.i("fabricResponseBean", fabricResponseBean.toString());

	} catch (JSONException e) {
	    e.printStackTrace();
	}
	return fabricResponseBean;

    }

}
