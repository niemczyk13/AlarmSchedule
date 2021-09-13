package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.alarmschedule.R;

import java.util.Calendar;

public class CalendarImageButton {
    private final Context context;
    private Calendar alarmDateTime;
    private LinearLayout calendarButtonLinearLayout;
    private ImageButton calendarButton;
    private SelectDateListener selectDateListener;

    public CalendarImageButton(Context context, int weight) {
        this.context = context;
        createView(weight);
    }

    private void createView(int weight) {
        createLinerLayout(weight);
        createImageButton();
        addImageButtonToLinearLayout();

        calendarButton.setOnClickListener(this::onClick);
    }

    //TODO uruchomienie okna z datą
    private void onClick(View view) {
        System.out.println("ImageButton!");
        //jeżeli wybrano datę to metoda select() z interfejsu
    }

    private void createLinerLayout(int weight) {
        calendarButtonLinearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = weight;
        params.topMargin = 0;
        params.bottomMargin = 0;
        calendarButtonLinearLayout.setLayoutParams(params);
    }

    private void createImageButton() {
        calendarButton = new ImageButton(context);
        calendarButton.setImageResource(R.drawable.ic_baseline_calendar_today_24);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = 0;
        params.bottomMargin = 0;
        calendarButton.setLayoutParams(params);
    }

    private void addImageButtonToLinearLayout() {
        calendarButtonLinearLayout.addView(calendarButton);
    }

    public View getView() {
        return calendarButtonLinearLayout;
    }

    public void addSelectDateListener(SelectDateListener selectDateListener) {
        this.selectDateListener = selectDateListener;
    }

    public void setAlarmDateTime(Calendar alarmDate) {
        this.alarmDateTime = alarmDate;
    }

    public interface SelectDateListener {
        void select(Calendar date);
    }
}
