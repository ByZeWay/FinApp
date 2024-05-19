package com.example.testdiplom.visualization;

import com.example.testdiplom.transaction.Transaction;

import java.util.List;

public interface VisualizationContract {
    interface View {
        void showTransactions(List<Transaction> transactions);
        void showError(String message);
    }

    interface Presenter {
        void loadTransactions();
    }
}


