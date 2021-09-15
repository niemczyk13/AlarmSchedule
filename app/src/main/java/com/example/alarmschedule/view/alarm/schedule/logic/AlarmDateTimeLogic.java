package com.example.alarmschedule.view.alarm.schedule.logic;

import androidx.fragment.app.FragmentManager;

import com.example.alarmschedule.view.alarm.schedule.CalendarImageButton;
import com.example.alarmschedule.view.alarm.schedule.DaysButtons;
import com.example.alarmschedule.view.alarm.schedule.InfoTextView;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;

import java.util.Calendar;

public class AlarmDateTimeLogic {
    private AlarmDateTime alarmDateTime;
    private DaysButtons daysButtons;
    private InfoTextView infoTextView;
    private CalendarImageButton calendarImageButton;

    public AlarmDateTimeLogic(DaysButtons daysButtons, InfoTextView infoTextView, CalendarImageButton calendarImageButton) {
        this.daysButtons = daysButtons;
        this.infoTextView = infoTextView;
        this.calendarImageButton = calendarImageButton;

        addOnClickDayButtonListener();
    }

    //TODO
    public void initialize(AlarmDateTime adt, FragmentManager supportFragmentManager) {
        //TODO tutaj alarmDateTime musi być przerobione !
        //TODO godzina zawsze zostaje ta sama, zmieniamy tylko datę
        //TODO w zależności od harmonogramu czy jest czy nie ma
        //alarmDateTime = Static klasa przerabiajca
        alarmDateTime = AlarmDateTimeUpdater.update(adt);
        daysButtons.setWeek(alarmDateTime.getWeekSchedule());
        calendarImageButton.setAlarmDateTime(alarmDateTime.getDateTime());
        calendarImageButton.setFragmentManager(supportFragmentManager);
    }

    private void addOnClickDayButtonListener() {
        daysButtons.addOnClickDayButtonListener(() -> {
            //TODO
            System.out.println("isSchedule: " + daysButtons.isSchedule());
        });
    }

    //TODO
    public void setTime(int hour, int minute) {
        System.out.println("TIME: " + hour + ":" + minute);
    }

    //TODO
    public void setDate(int year, int month, int day) {
        System.out.println("DATE: " + year + "-" + month + "-" + day);
    }
}
