package com.example.testdiplom.category;

import androidx.annotation.NonNull;

public class Category {
    private String name;
    private CategoryType type;
    private double monthlyAmount; // примерный доход или расход на месяц
    private int iconResId; // ресурс иконки

    public Category(String name, CategoryType type, double monthlyAmount, int iconResId) {
        this.name = name;
        this.type = type;
        this.monthlyAmount = monthlyAmount;
        this.iconResId = iconResId;
    }

    public Category(String name, CategoryType type, double monthlyAmount) {
        this.name = name;
        this.type = type;
        this.monthlyAmount = monthlyAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
