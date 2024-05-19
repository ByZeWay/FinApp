package com.example.testdiplom.visualization;

import com.example.testdiplom.transaction.Transaction;

import java.util.List;

// VisualizationPresenter.java
public class VisualizationPresenter implements VisualizationContract.Presenter {
    private VisualizationContract.View view;
    private VisualizationRepository repository;

    public VisualizationPresenter(VisualizationContract.View view) {
        this.view = view;
        this.repository = new VisualizationRepository();
    }

    @Override
    public void loadTransactions() {
        List<Transaction> transactions = repository.getTransactions();
        if (transactions != null && !transactions.isEmpty()) {
            view.showTransactions(transactions);
        } else {
            view.showError("No transactions found");
        }
    }
}


