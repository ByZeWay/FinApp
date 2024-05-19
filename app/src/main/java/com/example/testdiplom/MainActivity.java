//package com.example.testdiplom;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.testdiplom.account.AccountActivity;
//import com.example.testdiplom.category.CategoryActivity;
//import com.example.testdiplom.reminder.ReminderActivity;
//import com.example.testdiplom.transaction.TransactionActivity;
//
//public class MainActivity extends AppCompatActivity {
//    private Button buttonAccounts; // Кнопка для перехода к счетам
//    private Button buttonCategories;
//    private Button buttonTransactions;
//    private Button buttonReminders;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Инициализация кнопки
//        buttonAccounts = findViewById(R.id.buttonAccounts);
//
//        // Установка обработчика нажатия на кнопку
//        buttonAccounts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openAccountsActivity(); // Вызов метода для открытия активности счетов
//            }
//        });
//
//        // Находим кнопку в макете
//        buttonCategories = findViewById(R.id.buttonCategories);
//
//        // Устанавливаем обработчик нажатия на кнопку
//        buttonCategories.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCategoriesActivity();
//            }
//        });
//
//        // Находим кнопку в макете
//        buttonTransactions = findViewById(R.id.buttonTransactions);
//
//        // Устанавливаем обработчик нажатия на кнопку
//        buttonTransactions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openTransactionsActivity();
//            }
//        });
//
//        // Находим кнопку в макете
//        buttonReminders = findViewById(R.id.buttonReminders);
//
//        // Устанавливаем обработчик нажатия на кнопку
//        buttonReminders.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openRemindersActivity();
//            }
//        });
//    }
//
//    public void openAccountsActivity() {
//        Intent intent = new Intent(this, AccountActivity.class);
//        startActivity(intent);
//    }
//
//    public void openCategoriesActivity() {
//        Intent intent = new Intent(this, CategoryActivity.class);
//        startActivity(intent);
//    }
//
//    public void openTransactionsActivity() {
//        Intent intent = new Intent(this, TransactionActivity.class);
//        startActivity(intent);
//    }
//
//    public void openRemindersActivity() {
//        Intent intent = new Intent(this, ReminderActivity.class);
//        startActivity(intent);
//    }
//
//}





package com.example.testdiplom;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.testdiplom.account.AccountActivity;
import com.example.testdiplom.category.CategoryActivity;
import com.example.testdiplom.reminder.ReminderActivity;
import com.example.testdiplom.transaction.TransactionActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonAccounts; // Кнопка для перехода к счетам
    private Button buttonCategories;
    private Button buttonTransactions;
    private Button buttonReminders;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createChan();
        checkNotificationPermission();
        sendNotification();

        // Инициализация кнопки
        buttonAccounts = findViewById(R.id.buttonAccounts);

        // Установка обработчика нажатия на кнопку
        buttonAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountsActivity(); // Вызов метода для открытия активности счетов
            }
        });

        // Находим кнопку в макете
        buttonCategories = findViewById(R.id.buttonCategories);

        // Устанавливаем обработчик нажатия на кнопку
        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategoriesActivity();
            }
        });

        // Находим кнопку в макете
        buttonTransactions = findViewById(R.id.buttonTransactions);

        // Устанавливаем обработчик нажатия на кнопку
        buttonTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionsActivity();
            }
        });

        // Находим кнопку в макете
        buttonReminders = findViewById(R.id.buttonReminders);

        // Устанавливаем обработчик нажатия на кнопку
        buttonReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRemindersActivity();
            }
        });
    }

    public void openAccountsActivity() {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void openCategoriesActivity() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void openTransactionsActivity() {
        Intent intent = new Intent(this, TransactionActivity.class);
        startActivity(intent);
    }

    public void openRemindersActivity() {
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }


    private void createChan() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Создаем канал уведомлений
            NotificationChannel channel = new NotificationChannel("default", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);

            // Получаем менеджер уведомлений и создаем канал уведомлений
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            if (!areNotificationsEnabled) {
                // Открыть настройки уведомлений для вашего приложения
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", getPackageName());
                intent.putExtra("app_uid", getApplicationInfo().uid);
                startActivity(intent);
            }
        }
    }

    private void sendNotification() {
        // Создаем Intent для открытия активности при нажатии на уведомление
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Создаем уведомление
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(R.drawable.icon_voskl) // Устанавливаем маленькую иконку уведомления
                .setContentTitle("Оплата подписки") // Устанавливаем заголовок уведомления
                .setContentText("Оплати подписку за музыку!") // Устанавливаем текст уведомления
                .setContentIntent(pendingIntent) // Устанавливаем Intent для открытия активности
                .setAutoCancel(true); // Устанавливаем автоматическое закрытие уведомления при нажатии

        // Получаем менеджер уведомлений и отправляем уведомление
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }

}