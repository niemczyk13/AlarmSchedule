package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.alarmschedule.view.alarm.schedule.date.AlarmDateTimeLogic;

import java.util.Calendar;

public class AlarmSchedule extends LinearLayout {
    private ViewBuilder viewBuilder;
    private AlarmDateTimeLogic alarmDateTime;

    private DaysButtons daysButtons;
    private InfoTextView infoTextView;
    private CalendarImageButton calendarImageButton;


    public AlarmSchedule(Context context) {
        super(context);
        setProperties();
    }

    public AlarmSchedule(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setProperties();
    }

    public AlarmSchedule(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperties();
    }

    private void setProperties() {
        viewBuilder = new ViewBuilder(super.getContext());
        setPropertiesToMainLinearLayout();
        addViewsToMainLinearLayout();
        getViewsFromBuilder();
        createAlarmDateTime();
        addOnClickDayButtonListener();
        addSelectDateListener();
    }

    private void createAlarmDateTime() {
        //TODO w ramach testu data na sztywno
        alarmDateTime = new AlarmDateTimeLogic(Calendar.getInstance());
        calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());
    }

    private void addOnClickDayButtonListener() {
        daysButtons.addOnClickDayButtonListener(() -> {
            System.out.println("isSchedule: " + daysButtons.isSchedule());
        });
    }

    private void addSelectDateListener() {
        calendarImageButton.addSelectDateListener(date -> {
            System.out.println("Wybrano datę: " + date);
        });
    }

    private void getViewsFromBuilder() {
        infoTextView = viewBuilder.getInfoTextView();
        calendarImageButton = viewBuilder.getCalendarImageButton();
        daysButtons = viewBuilder.getDaysButtons();
    }

    private void addViewsToMainLinearLayout() {
        super.addView(viewBuilder.getFirstLineLayout());
        super.addView(viewBuilder.getSecondLineLayout());
    }

    private void setPropertiesToMainLinearLayout() {
        setOrientation(VERTICAL);
        LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        super.setLayoutParams(mainParams);
    }

    //TODO przy zmianie czasu
    public void setTime(int hour, int minute) {
        //dodanie do alarmdatetime
        //pobranie calendar i wysłanie do calednarImageButton
        alarmDateTime.setTime(hour, minute);
        calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());

    }

    //TODO - przy wczytywaniu do edycji
    public void setDateTime(Calendar calendar) {

    }

    public interface DayButtonClickListener {
        void onClick();
    }
}
