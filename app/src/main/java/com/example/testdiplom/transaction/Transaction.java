package com.example.testdiplom.transaction;

import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;

import java.util.Date;

public class Transaction {
    private TransactionType type;
    private double amount;
    private Account account;
    private Category category;
    private Date date;
    private String comment;

    public Transaction(TransactionType type, double amount, Account account, Category category, Date date, String comment) {
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.category = category;
        this.date = date;
        this.comment = comment;
    }

    public Transaction(TransactionType type, double amount, Account account, Category category, Date date) {
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.category = category;
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}