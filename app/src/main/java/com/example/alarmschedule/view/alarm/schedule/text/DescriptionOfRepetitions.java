package com.example.alarmschedule.view.alarm.schedule.text;

import java.util.ArrayList;
import java.util.List;

public class DescriptionOfRepetitions {
    private static String[] article = new String[] {
            "Każdy", "Każda", "Codziennie"
    };

    private static String[] fullNamesOfDays = new String[] {
            "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"
    };
    private static String[] abbreviatedNamesOfDays = new String[] {
            "Pn", "Wt", "Śr", "Cz", "Pt", "So", "Nd"
    };

    public static String getTextOfTheDaysOfRepetitions(List<Boolean> days) {
        List<String> checkedDaysNames = getCheckedDaysNames(days);
        if (checkedDaysNames.size() == 0) {
            //TODO wyświetlamy datę, tworzymy funkcję w view
            return null;
        }
        if (checkedDaysNames.size() == 7) {
            return article[2];
        }
        String d = checkedDaysNames.get(0);
        char a = d.charAt(d.length() - 1);
        String text = "";

        if (a == 'a' || a == 'r' || a == 'd') {
            text = article[1];
            for (int i = 0; i < checkedDaysNames.size(); i++) {
                if (i == 0) {
                    text += " " + checkedDaysNames.get(i);
                } else if (i > 0 && i < (checkedDaysNames.size() - 1)) {
                    text += ", " + checkedDaysNames.get(i);
                } else {
                    text += " i " + checkedDaysNames.get(i);
                }
            }
        } else {
            text = article[0];
            for (int i = 0; i < checkedDaysNames.size(); i++) {
                if (i == 0)
                    text += " " + checkedDaysNames.get(i);
                else if (i > 0 && i < checkedDaysNames.size() - 1) {
                    text += ", " + checkedDaysNames.get(i);
                } else {
                    text += " i " + checkedDaysNames.get(i);
                }
            }
        }

        return text;
        //String a = checkedDaysNames.get(0)[checkedDaysNames.get(0).length()];
        //pobiera pierwszy element
        //jeżeli kończy się na ek to każdy
        //jeżeli kończy się na a to każda
        // return "Lalal";
    }

    private static List<String> getCheckedDaysNames(List<Boolean> days) {
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i)) {
                d.add(i);
            }
        }

        List<String> dd = new ArrayList<>();


        int countCheckedDays = d.size();

        if (countCheckedDays == 1) {
            for (int i = 0; i < d.size(); i++) {
                dd.add(fullNamesOfDays[d.get(i)]);
            }
        } else if (countCheckedDays == 2) {
            for (int i = 0; i < d.size(); i++) {
                dd.add(fullNamesOfDays[d.get(i)]);
            }

        } else if (countCheckedDays >= 3 && countCheckedDays <= 6) {
            for (int i = 0; i < d.size(); i++) {
                dd.add(abbreviatedNamesOfDays[d.get(i)]);
            }
        } else {
            for (int i = 0; i < d.size(); i++) {
                dd.add(abbreviatedNamesOfDays[d.get(i)]);
            }
        }

        return dd;
    }
}
