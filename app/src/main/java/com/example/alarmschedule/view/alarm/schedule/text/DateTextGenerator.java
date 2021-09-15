package com.example.alarmschedule.view.alarm.schedule.text;

import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.Week;
import com.example.alarmschedule.view.alarm.schedule.text.DescriptionOfRepetitions;

import java.util.Calendar;

public class DateTextGenerator {
    public static String generate(Week weekSchedule) {
        return DescriptionOfRepetitions.getTextOfTheDaysOfRepetitions(weekSchedule.getDaysWhenMondayIsFirst());
    }

    public static String generate(Calendar date) {
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        String m = "";
        switch (month) {
            case 1: m = "Styczeń"; break;
            case 2: m = "Luty"; break;
            case 3: m = "Marzec"; break;
            case 4: m = "Kwiecień"; break;
            case 5: m = "Maj"; break;
            case 6: m = "Czerwiec"; break;
            case 7: m = "Lipiec"; break;
            case 8: m = "Sierpień"; break;
            case 9: m = "Wrzesień"; break;
            case 10: m = "Październik"; break;
            case 11: m = "Listopad"; break;
            case 12: m = "Grudzień"; break;
        }

        String d = "";
        switch (dayOfWeek) {
            case 1: d = "Niedziela"; break;
            case 2: d = "Poniedziałek"; break;
            case 3: d = "Wtorek"; break;
            case 4: d = "Środa"; break;
            case 5: d = "Czwartek"; break;
            case 6: d = "Piątek"; break;
            case 7: d = "Sobota"; break;
        }
        return "Tylko " + d + "., " + day + " " + m;
    }
}
