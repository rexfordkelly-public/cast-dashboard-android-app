package com.silver.dan.castdemo.widgets;

import android.content.Context;

import com.silver.dan.castdemo.Widget;

import org.json.JSONException;
import org.json.JSONObject;


public class PlaceholderWidget extends UIWidget {

    public PlaceholderWidget(Context context, Widget widget) {
        super(context, widget);
    }

    @Override
    public void init() {

    }


    @Override
    public JSONObject getContent() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("testkey0", "testvalue0");
        json.put("testkey1", "testvalue1");
        return json;
    }

    @Override
    public String getWidgetPreviewSecondaryHeader() {
        return "Just a placeholder";
    }
}