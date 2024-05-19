package com.example.testdiplom.reminder;

import java.util.List;

public class ReminderPresenter implements ReminderContract.Presenter {
    private ReminderContract.View view;
    private ReminderRepository repository;

    public ReminderPresenter(ReminderContract.View view) {
        this.view = view;
        this.repository = new ReminderRepository();
    }

    @Override
    public void loadReminderTypes() {
        List<String> reminderTypes = repository.getReminderTypes();
        view.showReminderTypes(reminderTypes);
    }

    @Override
    public void onDateFieldClicked() {
        // Здесь представление уведомляется о том, что поле даты было нажато
        view.showDatePickerDialog();
    }

    @Override
    public void onTimeFieldClicked() {
        // Здесь представление уведомляется о том, что поле времени было нажато
        view.showTimePickerDialog();
    }

    @Override
    public void saveReminder(String name, String type, String date, String time, String comment) {
        // Здесь можно вызвать методы репозитория для сохранения напоминания
        // Например:
        // repository.saveReminder(name, type, date, time, comment);
        // После сохранения можно вызвать методы представления для обновления интерфейса
        // Например:
        // view.showReminderSaved();
    }
}


