package com.example.testdiplom.transaction;

import com.example.testdiplom.R;
import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;
import com.example.testdiplom.category.CategoryType;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    // Предполагается, что здесь происходит взаимодействие с базой данных или другим источником данных

    // Метод для получения списка счетов
    public List<Account> getAccounts() {
        // В реальном приложении здесь будет код для получения списка счетов из базы данных или другого источника данных
        // В данном примере просто возвращается заглушка
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Выберите счет", 0, false, R.drawable.icon_voskl));
        accounts.add(new Account("Sber", 40000, true, R.drawable.icon_acc2));
        accounts.add(new Account("Наличка", 1700, true, R.drawable.icon_acc5));
        accounts.add(new Account("Копилка", 10050, false, R.drawable.icon_acc1));
        return accounts;
    }

    // Метод для получения списка категорий
    public List<Category> getCategories() {
        // В реальном приложении здесь будет код для получения списка категорий из базы данных или другого источника данных
        // В данном примере просто возвращается заглушка
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Выберите категорию", CategoryType.EXPENSE, 0, R.drawable.icon_voskl));
        categories.add(new Category("ЖКУ", CategoryType.EXPENSE, 5000, R.drawable.icon_cat3));
        categories.add(new Category("Транспорт", CategoryType.EXPENSE, 740, R.drawable.icon_cat8));
        categories.add(new Category("Стипендия", CategoryType.INCOME, 2600, R.drawable.icon_cat4));
        categories.add(new Category("Перевод", CategoryType.INCOME, 200, R.drawable.icon_cat5));
        return categories;
    }

    // Метод для сохранения транзакции
    public void saveTransaction(Transaction transaction) {
        // В реальном приложении здесь будет код для сохранения транзакции в базу данных или другое хранилище данных
        // В данном примере просто выводим информацию о транзакции в консоль
        System.out.println("Сохранение транзакции: " + transaction.toString());
    }
}

