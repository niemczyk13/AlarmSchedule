package com.example.alarmschedule.view.alarm.schedule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

public class DaysButtons {
    private MaterialButton[] daysButtons;
    private Week days;
    private String[] daysNames;

    public DaysButtons(Context context) {
        createaDaysNames();
        createButtons(context);
        createOnClickListener();
    }

    private void createOnClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO tutaj zaznaczanie przycisków i wyświetlanie komunikatu
                //TODO musimy dać do tamtego widoku listener, który nasłuchuje zmianę informacji
            }
        };
        setOnClickListener(onClickListener);
    }

    private void createButtons(Context context) {
        daysButtons = new MaterialButton[7];

        final float scale = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < daysButtons.length; i++) {
            MaterialButton button = new MaterialButton(context);
            button.setText(daysNames[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            params.leftMargin = 1;
            params.rightMargin = 1;
            int dp = 55;
            params.height = (int) ((dp * scale) + 0.5f);
            button.setLayoutParams(params);
            daysButtons[i] = button;
        }
    }

    private void createaDaysNames() {
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



    private void setOnClickListener(View.OnClickListener onClickListener) {
        for (MaterialButton button : daysButtons) {
            button.setOnClickListener(onClickListener);
        }
    }

    //TODO metoda odznacz wszystkie - kiedy kliniemy na kalendarzu OKEJ
    //TODO tutaj zaznaczanie
}
