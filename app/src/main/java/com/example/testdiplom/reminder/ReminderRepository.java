package com.example.testdiplom.reminder;

import androidx.recyclerview.widget.AsyncListUtil;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ReminderRepository {

    // Возвращаем список доступных типов напоминаний
    public List<String> getReminderTypes() {
        List<String> reminderTypes = new ArrayList<>();
        reminderTypes.add("Ежедневно");
        reminderTypes.add("Еженедельно");
        reminderTypes.add("Ежемесячно");
        reminderTypes.add("Ежегодно");
        return reminderTypes;
    }

    // Метод для сохранения напоминания
    public void saveReminder(String name, String type, String date, String time, String comment) {
        // Здесь может быть логика для сохранения напоминания в базу данных или другое хранилище данных
        // Например:
        // Reminder reminder = new Reminder(name, type, date, time, comment);
        // database.saveReminder(reminder);
    }
}


