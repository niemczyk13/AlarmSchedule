package com.example.alarmschedule.view.alarm.schedule.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class CalendarDialogFragment extends DialogFragment {
    private final static long ONE_DAY = 86400000;
    private DatePickerDialog datePickerDialog;
    private Calendar alarmDate;
    private int year, month, day, hour, minute;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        getAllArguments();
        createAlarmCalendar();
        createAlarmPickerDialog();
        return datePickerDialog;
    }

    private void getAllArguments() {
        year = Integer.parseInt(getArguments().getString("year"));
        month = Integer.parseInt(getArguments().getString("month"));
        day = Integer.parseInt(getArguments().getString("day"));
        hour = Integer.parseInt(getArguments().getString("hour"));
        minute = Integer.parseInt(getArguments().getString("minute"));
    }

    private void createAlarmCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, 0);
        alarmDate = calendar;
    }

    private void createAlarmPickerDialog() {
        datePickerDialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month - 1, day);
        datePickerDialog.getDatePicker().setMinDate(getMinDate());
        datePickerDialog.getDatePicker().setFirstDayOfWeek(Calendar.MONDAY);
    }

    private long getMinDate() {
        long minDate = System.currentTimeMillis();
        if (alarmDateIsBeforeNow()) {
            minDate += ONE_DAY;
        }
        return minDate;
    }

    private boolean alarmDateIsBeforeNow() {
        return alarmDate.before(Calendar.getInstance());
    }
}
