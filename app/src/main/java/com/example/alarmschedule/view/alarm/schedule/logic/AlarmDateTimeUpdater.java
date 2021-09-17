package com.example.alarmschedule.view.alarm.schedule.logic;

import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.DayOfWeek;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.Week;

import java.util.Calendar;
import java.util.List;

public class AlarmDateTimeUpdater {
    private static final int ONE_DAY = 1;
    private static AlarmDateTime alarmDateTime;

    public static AlarmDateTime update(AlarmDateTime adt) {
        alarmDateTime = adt;

        if (alarmDateTime.isSchedule()) {
            calculateDateForSchedule();
            System.out.println("Date for schedule: " + alarmDateTime.getDateTime().getTime());
        } else {
            calculateOrdinaryDate();
        }
        return alarmDateTime;
    }

    //TODO do dokończenia!!!!!!!!!!!!!!!!!!!!!!! do sprawdzenia!!!!!!!!!!!!!!!!!!!11
    private static void calculateDateForSchedule() {
        List<DayOfWeek> days = alarmDateTime.getWeekSchedule().getOnlySelectedDays();
        Calendar date = getCalendarInstance();
        for (DayOfWeek day : days) {
            date.set(Calendar.DAY_OF_WEEK, day.getValue());
            System.out.println("Date: " + date.getTime() + ", day.getValue(): " + day.getValue());
            alarmDateTime.getDateTime().set(Calendar.YEAR, date.get(Calendar.YEAR));
            alarmDateTime.getDateTime().set(Calendar.MONTH, date.get(Calendar.MONTH));
            alarmDateTime.getDateTime().set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
            if (alarmDateTime.getDateTime().after(getCalendarInstance())) {
                return;
            }
        }

        alarmDateTime.getDateTime().set(Calendar.DAY_OF_WEEK, days.get(0).getValue());
    }

    private static Calendar getCalendarInstance() {
        Calendar date = Calendar.getInstance();
        date.setFirstDayOfWeek(Calendar.MONDAY);
        return date;
    }

    private static void calculateOrdinaryDate() {
        System.out.println();
        if (alarmIsBeforeNow()) {
            int date = getCalendarInstance().get(Calendar.DATE);
            alarmDateTime.getDateTime().set(Calendar.DATE, date);
            if (alarmIsBeforeNow()) {
                alarmDateTime.getDateTime().add(Calendar.DATE, ONE_DAY);
            }
        }
    }

    private static boolean alarmIsBeforeNow() {
        return !alarmDateTime.getDateTime().after(getCalendarInstance());
    }

    public static AlarmDateTime updateTime(int hour, int minute) {
        alarmDateTime.getDateTime().set(Calendar.HOUR_OF_DAY, hour);
        alarmDateTime.getDateTime().set(Calendar.MINUTE, minute);
        alarmDateTime = update(alarmDateTime);
        return alarmDateTime;
    }

    public static AlarmDateTime setDate(int year, int month, int day) {
        alarmDateTime.getDateTime().set(Calendar.YEAR, year);
        alarmDateTime.getDateTime().set(Calendar.MONTH, month);
        alarmDateTime.getDateTime().set(Calendar.DAY_OF_MONTH, day);
        alarmDateTime.getWeekSchedule().clear();

        return alarmDateTime;
    }

    public static AlarmDateTime getAlarmDateTime() {
        return alarmDateTime;
    }

    public static AlarmDateTime setWeek(Week week) {
        alarmDateTime.setWeekSchedule(week);
        if (week.isSchedule()) {
            calculateDateForSchedule();
            System.out.println("Date for schedule: " + alarmDateTime.getDateTime().getTime());

        } else {
            allDaysUncheck();
        }
        return alarmDateTime;
    }

    public static AlarmDateTime allDaysUncheck() {
        alarmDateTime.getWeekSchedule().clear();
        Calendar date = getCalendarInstance();
        alarmDateTime.getDateTime().set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
        calculateOrdinaryDate();
        return alarmDateTime;
    }
}
