package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.alarmschedule.R;
import com.example.alarmschedule.view.alarm.schedule.adarm.datetime.Week;
import com.google.android.material.button.MaterialButton;

public class DaysButtons {
    private Context context;
    private MaterialButton[] daysButtons;
    private ImageButton checkAllDaysButton;
    private String[] daysNames;
    private OnClickDayButtonListener onClickDayButtonListener;

    public DaysButtons(Context context) {
        this.context = context;
        createDaysNames();
        createButtons(context);
    }

    private void createButtons(Context context) {
        this.context = context;
        createDaysButtons(context);
        createCheckAllDaysButton(context);
    }

    private void createCheckAllDaysButton(Context context) {
        //TODO dodać metodę nasłuchującą
        final float scale = context.getResources().getDisplayMetrics().density;
        checkAllDaysButton = new ImageButton(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 3;
        params.leftMargin = 2;
        int dp = 55;
        params.height = (int) ((dp * scale) + 0.5f);
        int dp2 = 100;
        params.width = (int) ((dp2 * scale) + 0.5f);
        checkAllDaysButton.setLayoutParams(params);
        checkAllDaysButton.setId(View.generateViewId());
        checkAllDaysButton.setOnClickListener(this::onAllDaysButtonClick);
        checkAllDaysButton.setImageResource(R.drawable.ic_baseline_select_all_24);
        //checkAllDays.setBackground(ContextCompat.getDrawable(context, R.drawable.day_button));
    }

    public LinearLayout.LayoutParams getDefaultLayoutParams() {
        final float scale = context.getResources().getDisplayMetrics().density;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 2;
        params.leftMargin = 1;
        params.rightMargin = 1;
        int dp = 55;
        params.height = (int) ((dp * scale) + 0.5f);

        return params;
    }

    private void onAllDaysButtonClick(View view) {
        if (allDayButtonIsChecked()) {
            uncheckAllDays();
        } else {
            checkAllDaysButtons();
        }
        if (onClickDayButtonListener != null) {
            onClickDayButtonListener.onClick();
        }
    }

    private void checkAllDaysButtons() {
        for (MaterialButton button : daysButtons) {
            button.setChecked(true);
            setCheckColorButton(button);
        }
    }

    private boolean allDayButtonIsChecked() {
        int count = 0;
        for (MaterialButton button : daysButtons) {
            if (button.isChecked()) {
                count++;
            }
        }

        return count == daysButtons.length;
    }

    private void createDaysButtons(Context context) {
        //TODO podzielić na tworzenie i nasłuchiwanie
        daysButtons = new MaterialButton[7];

        final float scale = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < daysButtons.length; i++) {
            MaterialButton button = createDayButton(context, scale, daysNames[i]);
            button.setId(View.generateViewId());
            button.setOnClickListener(this::onDayButtonClick);
            daysButtons[i] = button;
        }
    }

    private void onDayButtonClick(View view) {
        for (MaterialButton button : daysButtons) {
            if (button.getId() == view.getId()) {
                button.setChecked(button.isChecked());
                changeButtonView(button);
            }
        }

        if (onClickDayButtonListener != null) {
            onClickDayButtonListener.onClick();
        }
    }

    private void changeButtonView(MaterialButton button) {
        if (button.isChecked()) {
            setCheckColorButton(button);
        } else {
            setUncheckColorButton(button);
        }
    }

    private void setCheckColorButton(MaterialButton button) {
        button.setBackgroundColor(Color.rgb(255, 255, 255));
        button.setTextColor(Color.rgb(0,0,0));
    }

    private MaterialButton createDayButton(Context context, float scale, String daysName) {
        MaterialButton button = new MaterialButton(context);
        button.setText(daysName);
        LinearLayout.LayoutParams params = getDefaultLayoutParams();
        button.setLayoutParams(params);
        button.setPadding(0, 0, 0, 0);
        button.setCheckable(true);
        setUncheckColorButton(button);
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

    public ImageButton getCheckAllDaysButton() {
        return checkAllDaysButton;
    }

    public boolean isSchedule() {
        for (MaterialButton button : daysButtons) {
            if (button.isChecked()) {
                return true;
            }
        }
        return false;
    }

    public Week getWeek() {
        Week week = new Week();
        week.setDay(DayOfWeek.MONDAY, daysButtons[0].isChecked());
        week.setDay(DayOfWeek.TUESDAY, daysButtons[1].isChecked());
        week.setDay(DayOfWeek.WEDNESDAY, daysButtons[2].isChecked());
        week.setDay(DayOfWeek.THURSDAY, daysButtons[3].isChecked());
        week.setDay(DayOfWeek.FRIDAY, daysButtons[4].isChecked());
        week.setDay(DayOfWeek.SATURDAY, daysButtons[5].isChecked());
        week.setDay(DayOfWeek.SUNDAY, daysButtons[6].isChecked());

        return week;
    }

    public void addOnClickDayButtonListener(OnClickDayButtonListener onClickDayButtonListener) {
        this.onClickDayButtonListener = onClickDayButtonListener;
    }

    public void uncheckAllDays() {
        for (MaterialButton button : daysButtons) {
            button.setChecked(false);
            setUncheckColorButton(button);
            }
    }

    private void setUncheckColorButton(MaterialButton button) {
        button.setBackgroundColor(Color.rgb(0, 0, 0));
        button.setTextColor(Color.rgb(255, 255, 255));
    }

    public void setWeek(Week weekSchedule) {
        daysButtons[0].setChecked(weekSchedule.dayIsChecked(DayOfWeek.MONDAY));
        daysButtons[1].setChecked(weekSchedule.dayIsChecked(DayOfWeek.TUESDAY));
        daysButtons[2].setChecked(weekSchedule.dayIsChecked(DayOfWeek.WEDNESDAY));
        daysButtons[3].setChecked(weekSchedule.dayIsChecked(DayOfWeek.THURSDAY));
        daysButtons[4].setChecked(weekSchedule.dayIsChecked(DayOfWeek.FRIDAY));
        daysButtons[5].setChecked(weekSchedule.dayIsChecked(DayOfWeek.SATURDAY));
        daysButtons[6].setChecked(weekSchedule.dayIsChecked(DayOfWeek.SUNDAY));

        for (MaterialButton button: daysButtons) {
            if (button.isChecked()) {
                setCheckColorButton(button);
            }
        }

    }

    //TODO metoda odznacz wszystkie - kiedy kliniemy na kalendarzu OKEJ
    //TODO tutaj zaznaczanie

    public interface OnClickDayButtonListener {
        void onClick();
    }
}
