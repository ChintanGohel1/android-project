package com.inch2inch.genericService;

import com.inch2inch.api.GetAPI;
import com.inch2inch.api.PostAPI;
import com.inch2inch.fabric.ImageAPI;

public class AppContainer {

    private static WidgetService widgetService = null;

    private static GetAPI getAPI = null;

    private static PostAPI postAPI = null;

    private static ImageAPI imageAPI = null;

    public static WidgetService getWidgetService() {
	if (widgetService == null) {
	    widgetService = new WidgetService();
	}
	return widgetService;
    }

    public static GetAPI getGetAPI() {
	if (getAPI == null) {
	    getAPI = new GetAPI();
	}
	return getAPI;
    }

    public static PostAPI getPostAPI() {
	if (postAPI == null) {
	    postAPI = new PostAPI();
	}
	return postAPI;
    }

    public static ImageAPI getImageAPI() {

	if (imageAPI == null) {
	    imageAPI = new ImageAPI();
	}
	return imageAPI;
    }

}
