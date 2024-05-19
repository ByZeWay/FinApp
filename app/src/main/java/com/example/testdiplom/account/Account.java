package com.example.testdiplom.account;

import androidx.annotation.NonNull;

public class Account {
    private String name;
    private double amount;
    private boolean includeInBalance;
    private int iconResId;

    public Account(String name, double amount, boolean includeInBalance) {
        this.name = name;
        this.amount = amount;
        this.includeInBalance = includeInBalance;
    }

    public Account(String name, double amount, boolean includeInBalance, int iconResId) {
        this.name = name;
        this.amount = amount;
        this.includeInBalance = includeInBalance;
        this.iconResId = iconResId;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public boolean isIncludeInBalance() { return includeInBalance; }
    public void setIncludeInBalance(boolean includeInBalance) { this.includeInBalance = includeInBalance; }
    public int getIconResId() { return iconResId; }
    public void setIconResId(int iconResId) { this.iconResId = iconResId; }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

