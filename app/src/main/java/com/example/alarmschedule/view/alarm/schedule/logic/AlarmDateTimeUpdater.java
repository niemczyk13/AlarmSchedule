package com.example.alarmschedule.view.alarm.schedule.logic;

import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.DayOfWeek;

import java.util.Calendar;
import java.util.List;

public class AlarmDateTimeUpdater {
    private static final int ONE_DAY = 1;
    private static AlarmDateTime alarmDateTime;

    public static AlarmDateTime update(AlarmDateTime adt) {
        alarmDateTime = adt;
        if (alarmDateTime.isSchedule()) {
            calculateDateForSchedule();
        } else {
            calculateOrdinaryDate();
        }
        return alarmDateTime;
    }

    //TODO
    private static void calculateDateForSchedule() {
        //pobieramy week
        //pobieramy dzisiejszy dzień tygodnia
        //sortujemy dni w week wg dzisiejszego dnia
        //przypisujemy datę i porównujemy
        //jeżeli ok to okej
        //jeżeli data dzisiejsza z godziną wychodzi wcześniejsza to znów sortujemy od jednego dnia plus
        //
        //jeżeli dzień tygodnia jest dzisijeszy a z calendar wychodzi, że alarm będzie wcześniej to dodajemy 7 dni
        Calendar date = Calendar.getInstance();
        List<DayOfWeek> days = alarmDateTime.getWeekSchedule().getDaysSortedFromSelectedDay(date.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAYS: " + days);
    }


    private static void calculateOrdinaryDate() {
        System.out.println();
        if (alarmIsBeforeNow()) {
            int date = Calendar.getInstance().get(Calendar.DATE);
            alarmDateTime.getDateTime().set(Calendar.DATE, date);
            if (alarmIsBeforeNow()) {
                alarmDateTime.getDateTime().add(Calendar.DATE, ONE_DAY);
            }
        }
    }

    private static boolean alarmIsBeforeNow() {
        return !alarmDateTime.getDateTime().after(Calendar.getInstance());
    }
}
