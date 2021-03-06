package com.silver.dan.castdemo.widgets;

import android.content.Context;

import com.silver.dan.castdemo.R;
import com.silver.dan.castdemo.Widget;
import com.silver.dan.castdemo.settingsFragments.RSSSettings;
import com.silver.dan.castdemo.settingsFragments.WidgetSettingsFragment;

import org.json.JSONException;
import org.json.JSONObject;


public class RSSWidget extends UIWidget {

    public RSSWidget(Context context, Widget widget) {
        super(context, widget);
    }



    @Override
    public void init() {
        widget.initOption(RSSSettings.FEED_URL, "http://www.cbsnews.com/latest/rss/main");
        widget.initOption(RSSSettings.SHOW_DATES, true);
    }


    @Override
    public JSONObject getContent() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(RSSSettings.FEED_URL, widget.loadOrInitOption(RSSSettings.FEED_URL, context).value);
        json.put(RSSSettings.SHOW_DATES, widget.loadOrInitOption(RSSSettings.SHOW_DATES, context).getBooleanValue());
        return json;
    }

    @Override
    public WidgetSettingsFragment createSettingsFragment() {
        return new RSSSettings();
    }

    @Override
    public String getWidgetPreviewSecondaryHeader() {
        String URL = widget.loadOrInitOption(RSSSettings.FEED_URL, context).value;
        if (URL.length() == 0) {
            return context.getString(R.string.no_rss_feed_url_set);
        }
        return URL;
    }
}
