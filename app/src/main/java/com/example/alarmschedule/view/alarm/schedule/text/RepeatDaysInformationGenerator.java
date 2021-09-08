package com.example.alarmschedule.view.alarm.schedule.text;

import com.example.alarmschedule.view.alarm.schedule.Week;

import java.util.Calendar;

public class RepeatDaysInformationGenerator {
    private static String[] article = new String[] {
            "Każdy", "Każda", "Codziennie"
    };

    private static String[] months = new String[] {
      "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec",
      "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"
    };

    private static String[] fullNamesOfDays = new String[] {
      "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"
    };

    private static String[] abbreviatedNamesOfDays = new String[] {
            "Pn", "Wt", "Śr", "Cz", "Pt", "So", "Nd"
    };


    private String information;

    public String getText(Calendar calendar) {

        return null;
    }

    public String getText(Week week) {

        return null;
    }
}
