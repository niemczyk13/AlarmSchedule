package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.alarmschedule.R;
import com.google.android.material.button.MaterialButton;

public class DaysButtons {
    private MaterialButton[] daysButtons;
    private MaterialButton checkAllDays;
    private Week days;
    private String[] daysNames;

    public DaysButtons(Context context) {
        createDaysNames();
        createButtons(context);
        createOnClickListener();
    }

    private void createOnClickListener() {
        View.OnClickListener onClickListener = view -> {
            //TODO tutaj zaznaczanie przycisków i wyświetlanie komunikatu
            //TODO musimy dać do tamtego widoku listener, który nasłuchuje zmianę informacji
        };
        setOnClickListener(onClickListener);
    }

    private void createButtons(Context context) {
        createDaysButtons(context);
        createCheckAllDaysButton(context);

    }

    private void createCheckAllDaysButton(Context context) {
        //TODO dodać metodę nasłuchującą
        final float scale = context.getResources().getDisplayMetrics().density;
        checkAllDays = new MaterialButton(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 3;
        params.leftMargin = 2;
        int dp = 55;
        params.height = (int) ((dp * scale) + 0.5f);
        checkAllDays.setLayoutParams(params);
        //checkAllDays.setClickable(true);
        checkAllDays.setId(View.generateViewId());
        //checkAllDays.setOnTouchListener(this::onTouch);
        checkAllDays.setBackground(ContextCompat.getDrawable(context, R.drawable.day_button));
    }

    private void createDaysButtons(Context context) {
        //TODO podzielić na tworzenie i nasłuchiwanie
        daysButtons = new MaterialButton[7];

        final float scale = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < daysButtons.length; i++) {
            MaterialButton button = createDayButton(context, scale, daysNames[i]);
            button.setId(View.generateViewId());
            button.setOnClickListener(this::onClick);
            button.callOnClick();
            //button.setOnTouchListener(this::onTouch);
            daysButtons[i] = button;
        }
    }

    private void onClick(View view) {
        System.out.println("OnClick: " + view.getId());
    }

    private boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            for (MaterialButton day : daysButtons) {
                System.out.println(day.getId() + " == " + view.getId());
                if (day.getId() == view.getId()) {
                    if (day.isChecked()) {
                        day.setChecked(false);
                    } else {
                        System.out.println("!!!!");

                        day.setChecked(true);
                    }
                }
            }

            for (MaterialButton day : daysButtons) {
                System.out.println(day.getText() + ", " + day.isChecked());
            }
        }

        return false;
    }

    private MaterialButton createDayButton(Context context, float scale, String daysName) {
        MaterialButton button = new MaterialButton(context);
        button.setText(daysName);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 2;
        params.leftMargin = 1;
        params.rightMargin = 1;
        int dp = 55;
        params.height = (int) ((dp * scale) + 0.5f);
        button.setLayoutParams(params);
        button.setPadding(0, 0, 0, 0);
        button.setBackground(ContextCompat.getDrawable(context, R.drawable.day_button));
        //button.setCheckable(true);
        System.out.println(button.isCheckable());
        return button;
    }

    private void createDaysNames() {
        daysNames = new String[7];
        daysNames[0] = "Pn";
        daysNames[1] = "Wt";
        daysNames[2] = "Sr";
        daysNames[3] = "Cz";
        daysNames[4] = "Pt";
        daysNames[5] = "So";
        daysNames[6] = "N";
    }

    public MaterialButton[] getDaysButtons() {
        return daysButtons;
    }

    public MaterialButton getCheckAllDays() {
        return checkAllDays;
    }

    private void setOnClickListener(View.OnClickListener onClickListener) {
        for (MaterialButton button : daysButtons) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void addOnClickDayButtonListener(AlarmSchedule.DayButtonClickListener dayButtonClickListener) {
    }

    //TODO metoda odznacz wszystkie - kiedy kliniemy na kalendarzu OKEJ
    //TODO tutaj zaznaczanie

    public interface onClickDayButtonListener {
        void onClick();
    }
}
