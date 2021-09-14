package com.example.alarmschedule.view.alarm.schedule.adarm.datetime;

import com.example.alarmschedule.view.alarm.schedule.DayOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week {
    private Map<DayOfWeek, Boolean> days;

    public Week() {
        days = new HashMap<>();
        days.put(DayOfWeek.MONDAY, false);
        days.put(DayOfWeek.TUESDAY, false);
        days.put(DayOfWeek.WEDNESDAY, false);
        days.put(DayOfWeek.THURSDAY, false);
        days.put(DayOfWeek.FRIDAY, false);
        days.put(DayOfWeek.SATURDAY, false);
        days.put(DayOfWeek.SUNDAY, false);
    }

    public void activeDay(DayOfWeek day) {
        days.put(day, true);
    }

    public void deactivateDay(DayOfWeek day) {
        days.put(day, false);
    }

    public void setDay(DayOfWeek day, Boolean checked) {
        days.put(day, checked);
    }

    public boolean dayIsChecked(DayOfWeek day) {
        return days.get(day);
    }

    public List<Boolean> getDaysWhenMondayIsFirst() {
        List<Boolean> daysList = new ArrayList<>();
        daysList.add(days.get(DayOfWeek.MONDAY));
        daysList.add(days.get(DayOfWeek.TUESDAY));
        daysList.add(days.get(DayOfWeek.WEDNESDAY));
        daysList.add(days.get(DayOfWeek.THURSDAY));
        daysList.add(days.get(DayOfWeek.FRIDAY));
        daysList.add(days.get(DayOfWeek.SATURDAY));
        daysList.add(days.get(DayOfWeek.SUNDAY));
        return daysList;
    }
}
