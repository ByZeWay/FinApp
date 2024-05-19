package com.example.testdiplom.transaction;

import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;

import java.util.List;

public interface TransactionContract {
    interface View {
        void showAccounts(List<Account> accounts);
        void showCategories(List<Category> categories);
        void showError(String message);
    }

    interface Presenter {
        void loadAccounts();
        void loadCategories();
        void saveTransaction(Transaction transaction);
    }
}
