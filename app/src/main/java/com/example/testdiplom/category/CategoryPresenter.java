package com.example.testdiplom.category;

import java.util.List;

public class CategoryPresenter implements CategoryContract.Presenter {
    private CategoryContract.View view;
    private List<Category> categories; // Здесь может быть ваш источник данных для категорий

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void loadCategories() {
        // Загрузка категорий из источника данных
        // Например, из базы данных или репозитория
        // После загрузки вызываем методы представления для отображения категорий или ошибки
        if (categories != null && !categories.isEmpty()) {
            view.showCategories(categories);
        } else {
            view.showError("Категории не найдены");
        }
    }
}

