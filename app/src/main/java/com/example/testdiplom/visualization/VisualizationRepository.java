package com.example.testdiplom.visualization;

import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;
import com.example.testdiplom.category.CategoryType;
import com.example.testdiplom.transaction.Transaction;
import com.example.testdiplom.transaction.TransactionType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// VisualizationRepository.java
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// VisualizationRepository.java
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VisualizationRepository {
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);

        for (int i = 0; i < 4; i++) {
            Date date = calendar.getTime();

            // Adding income and expenses for each month
            if (calendar.get(Calendar.MONTH) == Calendar.APRIL) {
                transactions.add(new Transaction(TransactionType.INCOME, 1000, new Account("Account1", 1000, true), new Category("Salary", CategoryType.INCOME, 0), date, "Monthly income"));
                transactions.add(new Transaction(TransactionType.EXPENSE, 2000, new Account("Account1", 1000, true), new Category("Food", CategoryType.EXPENSE, 0), date, "Monthly expense"));
            } else {
                transactions.add(new Transaction(TransactionType.INCOME, 1000 * (i + 1), new Account("Account1", 1000, true), new Category("Salary", CategoryType.INCOME, 0), date, "Monthly income"));
                transactions.add(new Transaction(TransactionType.EXPENSE, 500 * (i + 1), new Account("Account1", 1000, true), new Category("Food", CategoryType.EXPENSE, 0), date, "Monthly expense"));
            }

            calendar.add(Calendar.MONTH, 1);
        }

        return transactions;
    }
}


