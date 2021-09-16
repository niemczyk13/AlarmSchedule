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
        System.out.println("AlarmDateTime1: " + alarmDateTime.getDateTime().getTime());

        if (alarmDateTime.isSchedule()) {
            //TODO to do zmiany
            calculateDateForSchedule();
        } else {
            calculateOrdinaryDate();
        }
        return alarmDateTime;
    }

    //TODO tylko przy przycisku zapisz
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
        List<DayOfWeek> days = alarmDateTime.getWeekSchedule().getOnlySelectedDays();
        for (DayOfWeek day : days) {
            //alarmDateTime.getDateTime().set(Calendar.DAY_OF_WEEK, day.getValue());
            date.set(Calendar.DAY_OF_WEEK, day.getValue());
            alarmDateTime.getDateTime().set(Calendar.YEAR, date.get(Calendar.YEAR));
            alarmDateTime.getDateTime().set(Calendar.MONTH, date.get(Calendar.MONTH));
            alarmDateTime.getDateTime().set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
           // System.out.println("W for: " + alarmDateTime.getDateTime().getTime());
           // System.out.println("Now : " + Calendar.getInstance().getTime());
            if (alarmDateTime.getDateTime().after(Calendar.getInstance())) {
                return;
            }
        }

        if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != days.get(0).getValue())
            alarmDateTime.getDateTime().set(Calendar.DAY_OF_WEEK, days.get(0).getValue());
        alarmDateTime.getDateTime().add(Calendar.DATE, 7);
        System.out.println("DAYS: " + days);
        System.out.println("AlarmDateTime: " + alarmDateTime.getDateTime().getTime());


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
