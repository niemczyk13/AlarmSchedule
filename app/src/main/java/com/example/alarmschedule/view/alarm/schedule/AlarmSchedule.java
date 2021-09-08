package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.alarmschedule.R;
import com.google.android.material.button.MaterialButton;

public class AlarmSchedule extends LinearLayout {
    private DaysButtons daysButtons;
    private LinearLayout firstLineLayout; //Napis i przycisk kalendarza
    private LinearLayout secondLineLayout; //Przyciski dni tygodnia
    private TextView info;
    private LinearLayout calendarButtonLinearLayout;
    private ImageButton calendarButton;

    public AlarmSchedule(Context context) {
        super(context);
        setProperties();
    }

    public AlarmSchedule(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setProperties();
    }

    public AlarmSchedule(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperties();
    }

    private void setProperties() {
        createFirstLinearLayout();
        createSecondLinearLayout();
        setPropertiesToMainLinearLayout();
        addViewsToMainLinearLayout();

    }

    private void addViewsToMainLinearLayout() {
        super.addView(firstLineLayout);
        super.addView(secondLineLayout);
    }

    private void setPropertiesToMainLinearLayout() {
        setOrientation(VERTICAL);
        LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        super.setLayoutParams(mainParams);
    }

    private void createSecondLinearLayout() {
        secondLineLayout = new LinearLayout(super.getContext());
        setPropertiesToSecondLinearLayout();
        createDaysButtons();
        setDaysButtonsToSecondLinearLayout();
    }

    private void createDaysButtons() {
        daysButtons = new DaysButtons(super.getContext());
    }

    private void setDaysButtonsToSecondLinearLayout() {
        for (MaterialButton button : daysButtons.getDaysButtons()) {
            secondLineLayout.addView(button);
        }
    }

    private void setPropertiesToSecondLinearLayout() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        secondLineLayout.setLayoutParams(params);
        secondLineLayout.setOrientation(HORIZONTAL);
    }

    private void createFirstLinearLayout() {
        firstLineLayout = new LinearLayout(super.getContext());
        createInfoTextView();
        createCalendarButton();
        setPropertiesToFirstLinearLayout();
    }

    private void setPropertiesToFirstLinearLayout() {
        firstLineLayout.setOrientation(HORIZONTAL);
        firstLineLayout.addView(info);
        firstLineLayout.addView(calendarButtonLinearLayout);
    }

    private void createCalendarButton() {
        calendarButtonLinearLayout = new LinearLayout(super.getContext());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.weight = 1;
        p.topMargin = 30;
        calendarButtonLinearLayout.setLayoutParams(p);

        calendarButton = new ImageButton(super.getContext());
        calendarButton.setImageResource(R.drawable.ic_baseline_calendar_today_24);

        calendarButtonLinearLayout.addView(calendarButton);
    }

    private void createInfoTextView() {
        info = new TextView(super.getContext());
        LinearLayout.LayoutParams par = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        par.weight = 12;
        par.topMargin = 50;
        info.setLayoutParams(par);
        info.setText("Tutaj będzie info!");
    }

    public interface DayButtonClickListener {
        void onClick();
    }
}
