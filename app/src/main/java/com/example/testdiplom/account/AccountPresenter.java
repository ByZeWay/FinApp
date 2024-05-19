package com.example.testdiplom.account;

import com.example.testdiplom.DatabaseHelper;

public class AccountPresenter {
    private AccountView view;
    private DatabaseHelper databaseHelper;

    public AccountPresenter(AccountView view, DatabaseHelper databaseHelper) {
        this.view = view;
        this.databaseHelper = databaseHelper;
    }

    public void saveAccount(String name, double amount, boolean includeInBalance, int iconResId) {
        if (name.isEmpty() || amount < 0) {
            view.showErrorMessage("Некорректные данные счета");
            return;
        }

        Account account = new Account(name, amount, includeInBalance, iconResId);
        databaseHelper.addAccount(account);
        view.showSuccessMessage();
    }
}
