package com.example.alarmschedule.view.alarm.schedule.adarm.datetime;

import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.schedule.ScheduleProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week {
    private Map<DayOfWeek, Boolean> days;
    private DayOfWeek[] orderOfDays;

    public Week() {
        days = new HashMap<>();
        days.put(DayOfWeek.MONDAY, false);
        days.put(DayOfWeek.TUESDAY, false);
        days.put(DayOfWeek.WEDNESDAY, false);
        days.put(DayOfWeek.THURSDAY, false);
        days.put(DayOfWeek.FRIDAY, false);
        days.put(DayOfWeek.SATURDAY, false);
        days.put(DayOfWeek.SUNDAY, false);

        orderOfDays = new DayOfWeek[] {
          DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY
        };
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

    public List<DayOfWeek> getDaysSortedFromSelectedDay(int dayOfWeekValue) {
        DayOfWeek dayOfWeek = getDayOfWeek(dayOfWeekValue);
        List<DayOfWeek> sortedDays;
        sortedDays = getOnlySelectedDays();
        sortedDays = sortedFromSelectedDay(sortedDays, dayOfWeek);

        return sortedDays;
    }

    private List<DayOfWeek> sortedFromSelectedDay(List<DayOfWeek> sortedDays, DayOfWeek dayOfWeek) {
        //TODO


        return null;// ScheduleProcessor.filterAndSortSelectionDays(dayOfWeek.getValue(),sortedDays);
    }

    private List<DayOfWeek> getOnlySelectedDays() {
        List<DayOfWeek> list = new ArrayList<>();
        for (int i = 0; i < orderOfDays.length; i++) {
            if (days.get(orderOfDays[i])) {
                list.add(orderOfDays[i]);
            }
        }
        return list;
    }

    private DayOfWeek getDayOfWeek(int dayOfWeekValue) {
        for (DayOfWeek d : orderOfDays) {
            if (d.getValue() == dayOfWeekValue) {
                return d;
            }
        }
        return null;
    }

    public boolean isSchedule() {
        for (Boolean value : days.values()) {
            if (value) return true;
        }
        return false;
    }
}
