package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoTextView {
    private final Context context;
    private TextView info;

    public InfoTextView(Context context, int weight) {
        this.context = context;
        createView(weight);
    }

    private void createView(int weight) {
        info = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = weight;
        params.topMargin = 40;
        params.bottomMargin = 2;
        info.setLayoutParams(params);
        info.setText("TUTAJ BĘDZIE INFO!");
    }

    public View getView() {
        return info;
    }
}
