package com.example.alarmschedule.view.alarm.schedule.adarm.datetime.schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleProcessor {
    private static int dayOfW;
    private static List<Boolean> selectionD;
    private static List<Integer> filterAndSortedList;

    private static int indexFirstDay;
    private static int shift;

    //TODO dodać opcję Calendar w której dodany jest czas budzika i na tej podstawie określimy jaki dzień
    public static List<Integer> filterAndSortSelectionDays(int dayOfWeek, List<Boolean> selectionDays) {
        setValues(dayOfWeek, selectionDays);
        filterSelectionDays();
        sortedSelectionDays();
        return filterAndSortedList;
    }

    private static void setValues(int dayOfWeek, List<Boolean> selectionDays) {
        dayOfW = dayOfWeek;
        selectionD = selectionDays;
        filterAndSortedList = new ArrayList<>();
        indexFirstDay = 0;
        shift = 1;
    }

    private static void filterSelectionDays() {
        for (int i = 0; i < selectionD.size(); i++) {
            if (selectionD.get(i)) {
                filterAndSortedList.add(i + 1);
            }
        }
    }

    private static void sortedSelectionDays() {
        findIndexFirstDaysAndShift();
        splitTheDays();
    }

    private static void findIndexFirstDaysAndShift() {
        for (int i = 0; i < filterAndSortedList.size(); i++) {
            int day = filterAndSortedList.get(i);
            if (day < dayOfW) {
                indexFirstDay++;
            }
        }
        shift = filterAndSortedList.size() - indexFirstDay;
    }

    private static void splitTheDays() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < filterAndSortedList.size(); i++) {
            if (i < shift) {
                list.add(filterAndSortedList.get(i + indexFirstDay));
            } else {
                list.add(filterAndSortedList.get(i - shift));
            }
        }

        filterAndSortedList = list;
    }
}
