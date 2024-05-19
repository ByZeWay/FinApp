package com.example.testdiplom.category;

import java.util.List;

public interface CategoryContract {
    interface View {
        void showCategories(List<Category> categories);
        void showError(String message);
    }

    interface Presenter {
        void loadCategories();
    }
}
