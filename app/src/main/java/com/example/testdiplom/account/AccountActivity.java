package com.example.testdiplom.account;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdiplom.R;

public class AccountActivity extends AppCompatActivity implements AccountView {
    private EditText editTextAccountName;
    private EditText editTextAmount;
    private Switch switchIncludeInBalance;
    private ImageButton selectedImageButton;
    private ImageButton imageButtonIcon1, imageButtonIcon2, imageButtonIcon3, imageButtonIcon4, imageButtonIcon5;
    private int selectedIconResId;
    private AccountPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        editTextAccountName = findViewById(R.id.editTextAccountName);
        editTextAmount = findViewById(R.id.editTextAmount);
        switchIncludeInBalance = findViewById(R.id.switchIncludeInBalance);

        /// Инициализация ImageButton
        imageButtonIcon1 = findViewById(R.id.imageButtonIconAcc1);
        imageButtonIcon2 = findViewById(R.id.imageButtonIconAcc2);
        imageButtonIcon3 = findViewById(R.id.imageButtonIconAcc3);
        imageButtonIcon4 = findViewById(R.id.imageButtonIconAcc4);
        imageButtonIcon5 = findViewById(R.id.imageButtonIconAcc5);

        // Установка обработчиков нажатий на ImageButton
        imageButtonIcon1.setOnClickListener(iconClickListener);
        imageButtonIcon2.setOnClickListener(iconClickListener);
        imageButtonIcon3.setOnClickListener(iconClickListener);
        imageButtonIcon4.setOnClickListener(iconClickListener);
        imageButtonIcon5.setOnClickListener(iconClickListener);

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
    public void showSuccessMessage() {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
