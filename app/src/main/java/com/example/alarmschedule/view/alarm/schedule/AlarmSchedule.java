package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.Week;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.WeekSchedule;
import com.example.alarmschedule.view.alarm.schedule.logic.AlarmDateTimeLogic;

import java.util.Calendar;

public class AlarmSchedule extends LinearLayout {
    private AlarmDateTimeLogic logic;

    private ViewBuilder viewBuilder;
    private AlarmDateTime alarmDateTime;

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
        createAlarmDateTimeLogic();
        createAlarmDateTime();
    }

    private void createAlarmDateTimeLogic() {
        logic = new AlarmDateTimeLogic(daysButtons, infoTextView, calendarImageButton);
    }

    private void createAlarmDateTime() {
        //TODO w ramach testu data na sztywno
        //alarmDateTime = new AlarmDateTimeLogic(Calendar.getInstance());
        //calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());
        Week week = new Week();
        week.activeDay(DayOfWeek.MONDAY);
        week.activeDay(DayOfWeek.FRIDAY);
        WeekSchedule weekSchedule = new WeekSchedule(true, week);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 9, 13, 12,0);
        alarmDateTime = new AlarmDateTime(calendar, weekSchedule);
        //calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());
        //week.setDay(DayOfWeek.MONDAY);

        //TODO delegacja do logic - żeby dać dobrą datę w alarmDateTime

        daysButtons.setWeek(alarmDateTime.getWeekSchedule());
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
        //alarmDateTime.setTime(hour, minute);
        //TODO delegacja do logic
        calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());

    }

    //TODO - przy wczytywaniu do edycji
    public void setDateTime(Calendar calendar) {

    }

    public interface DayButtonClickListener {
        void onClick();
    }
}
