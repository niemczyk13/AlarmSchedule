package com.example.alarmschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.example.alarmschedule.view.alarm.schedule.view.AlarmSchedule;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.DayOfWeek;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.AlarmDateTime;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.Week;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.WeekSchedule;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private AlarmSchedule alarmSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmSchedule = findViewById(R.id.alarm_schedule);
        alarmSchedule.initialize(createTestAlarmDateTime(), getSupportFragmentManager());
    }

    private AlarmDateTime createTestAlarmDateTime() {
        //TODO w ramach testu data na sztywno
        Week week = new Week();
        //week.activeDay(DayOfWeek.MONDAY);
        week.activeDay(DayOfWeek.FRIDAY);
        //week.activeDay(DayOfWeek.THURSDAY);
        WeekSchedule weekSchedule = new WeekSchedule(week);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 8, 10, 10,9, 0);
        return new AlarmDateTime(calendar, weekSchedule);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        alarmSchedule.setDate(year, month, day);
    }
}