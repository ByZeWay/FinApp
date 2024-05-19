package com.example.testdiplom.reminder;

import java.util.List;

public interface ReminderContract {

    interface View {
        void showReminderTypes(List<String> reminderTypes);
        void showDatePickerDialog();
        void showTimePickerDialog();
        void showError(String message);
    }

    interface Presenter {
        void loadReminderTypes();

        void onDateFieldClicked();

        void onTimeFieldClicked();

        void saveReminder(String name, String type, String date, String time, String comment);
    }
}

