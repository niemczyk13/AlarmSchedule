package com.example.alarmschedule.view.alarm.schedule.logic;

import com.example.alarmschedule.view.alarm.schedule.CalendarImageButton;
import com.example.alarmschedule.view.alarm.schedule.DaysButtons;
import com.example.alarmschedule.view.alarm.schedule.InfoTextView;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;

import java.util.Calendar;

public class AlarmDateTimeLogic {
    private DaysButtons daysButtons;
    private InfoTextView infoTextView;
    private CalendarImageButton calendarImageButton;

    private Calendar dateTime;


    public AlarmDateTimeLogic(DaysButtons daysButtons, InfoTextView infoTextView, CalendarImageButton calendarImageButton) {
        this.daysButtons = daysButtons;
        this.infoTextView = infoTextView;
        this.calendarImageButton = calendarImageButton;

        addOnClickDayButtonListener();
        addSelectDateListener();
    }

    private void addOnClickDayButtonListener() {
        daysButtons.addOnClickDayButtonListener(() -> {
            //TODO delegacja do logic
            System.out.println("isSchedule: " + daysButtons.isSchedule());
        });
    }

    private void addSelectDateListener() {
        calendarImageButton.addSelectDateListener(date -> {
            //TODO delegacja do logic
            System.out.println("Wybrano datę: " + date);
        });
    }
}
