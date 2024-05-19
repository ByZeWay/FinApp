package com.example.testdiplom.transaction;

import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;

import java.util.List;

public class TransactionPresenter implements TransactionContract.Presenter {
    private TransactionContract.View view;
    private TransactionRepository transactionRepository; // Предполагается, что есть репозиторий для работы с данными

    public TransactionPresenter(TransactionContract.View view) {
        this.view = view;
        this.transactionRepository = new TransactionRepository(); // Инициализируем репозиторий
    }

    @Override
    public void loadAccounts() {
        // Получение списка счетов из репозитория и передача их на отображение
        List<Account> accounts = transactionRepository.getAccounts();
        view.showAccounts(accounts);
    }

    @Override
    public void loadCategories() {
        // Получение списка категорий из репозитория и передача их на отображение
        List<Category> categories = transactionRepository.getCategories();
        view.showCategories(categories);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        // Сохранение транзакции в репозитории
        transactionRepository.saveTransaction(transaction);
        // Обновление интерфейса, например, чтобы отобразить сообщение об успешном сохранении
        // или обработать ошибки, если они возникли
    }
}

