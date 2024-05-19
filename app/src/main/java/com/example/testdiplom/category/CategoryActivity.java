package com.example.testdiplom.category;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdiplom.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View {
    private CategoryContract.Presenter presenter;
    private Spinner spinnerCategoryType;
    private ImageButton selectedImageButton;
    private ImageButton imageButtonIcon1, imageButtonIcon2, imageButtonIcon3, imageButtonIcon4, imageButtonIcon5;
    private ImageButton imageButtonIcon6, imageButtonIcon7, imageButtonIcon8, imageButtonIcon9, imageButtonIcon10;
    private int selectedIconResId;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Инициализация Spinner
        spinnerCategoryType = findViewById(R.id.spinnerCategoryType);
        setupSpinner();

        // Инициализация ImageButton
        imageButtonIcon1 = findViewById(R.id.imageButtonIconCat1);
        imageButtonIcon2 = findViewById(R.id.imageButtonIconCat2);
        imageButtonIcon3 = findViewById(R.id.imageButtonIconCat3);
        imageButtonIcon4 = findViewById(R.id.imageButtonIconCat4);
        imageButtonIcon5 = findViewById(R.id.imageButtonIconCat5);
        imageButtonIcon6 = findViewById(R.id.imageButtonIconCat6);
        imageButtonIcon7 = findViewById(R.id.imageButtonIconCat7);
        imageButtonIcon8 = findViewById(R.id.imageButtonIconCat8);
        imageButtonIcon9 = findViewById(R.id.imageButtonIconCat9);
        imageButtonIcon10 = findViewById(R.id.imageButtonIconCat10);

        // Установка обработчиков нажатий на ImageButton
        imageButtonIcon1.setOnClickListener(iconClickListener);
        imageButtonIcon2.setOnClickListener(iconClickListener);
        imageButtonIcon3.setOnClickListener(iconClickListener);
        imageButtonIcon4.setOnClickListener(iconClickListener);
        imageButtonIcon5.setOnClickListener(iconClickListener);
        imageButtonIcon6.setOnClickListener(iconClickListener);
        imageButtonIcon7.setOnClickListener(iconClickListener);
        imageButtonIcon8.setOnClickListener(iconClickListener);
        imageButtonIcon9.setOnClickListener(iconClickListener);
        imageButtonIcon10.setOnClickListener(iconClickListener);

        presenter = new CategoryPresenter(this);
        presenter.loadCategories();
    }

    private void setupSpinner() {
        List<String> categoryTypes = new ArrayList<>();
        categoryTypes.add(getString(R.string.select_category_type));
        categoryTypes.add(getString(R.string.income));
        categoryTypes.add(getString(R.string.expense));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categoryTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoryType.setAdapter(adapter);

        // Установить элемент-заполнитель как выбранный по умолчанию
        spinnerCategoryType.setSelection(0);
    }

    // Обработчик нажатий для ImageButton
    private View.OnClickListener iconClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Снятие выделения с предыдущей выбранной иконки
            if (selectedImageButton != null) {
                selectedImageButton.setBackgroundColor(Color.TRANSPARENT);
            }

            // Получение ресурса иконки, на которую было нажато
            selectedImageButton = (ImageButton) v;
            selectedIconResId = selectedImageButton.getDrawable().getLevel();

            // Установка выделения на выбранную иконку
            selectedImageButton.setBackgroundColor(Color.LTGRAY);
        }
    };

    @Override
    public void showCategories(List<Category> categories) {
        // Отображение списка категорий
    }

    @Override
    public void showError(String message) {
        // Отображение сообщения об ошибке
    }
}
