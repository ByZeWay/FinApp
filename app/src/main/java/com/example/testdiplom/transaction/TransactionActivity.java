package com.example.testdiplom.transaction;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.example.testdiplom.R;
import com.example.testdiplom.account.Account;
import com.example.testdiplom.category.Category;
import com.example.testdiplom.utils.AccountAdapter;
import com.example.testdiplom.utils.CategoryAdapter;

public class TransactionActivity extends AppCompatActivity implements TransactionContract.View {
    private TransactionContract.Presenter presenter;
    private Spinner spinnerTransactionType, spinnerAccount, spinnerCategory;
    private EditText editTextAmount, editTextDate, editTextComment;
    private Button buttonSaveTransaction;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        // Инициализация представления
        spinnerTransactionType = findViewById(R.id.spinnerTransactionType);
        setupSpinnerTransactionType();
        spinnerAccount = findViewById(R.id.spinnerAccount);
        //setupSpinnerAccount();
        spinnerCategory = findViewById(R.id.spinnerCategory);
        //setupSpinnerCategory();
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextDate = findViewById(R.id.editTextDate);
        editTextComment = findViewById(R.id.editTextComment);

        // Инициализация презентера
        presenter = new TransactionPresenter(this);
        presenter.loadAccounts();
        presenter.loadCategories();

        // Инициализация календаря и формата даты
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        // Обработчик нажатия на поле даты
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }


    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        editTextDate.setText(dateFormat.format(calendar.getTime()));
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void setupSpinnerTransactionType() {
        List<String> categoryTypes = new ArrayList<>();
        categoryTypes.add(getString(R.string.select_category_type)); // Добавление элемента-заполнителя
        categoryTypes.add(getString(R.string.income)); // "Доход"
        categoryTypes.add(getString(R.string.expense)); // "Расход"

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categoryTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTransactionType.setAdapter(adapter);

        // Установить элемент-заполнитель как выбранный по умолчанию
        spinnerTransactionType.setSelection(0);
//        List<CategoryType> categoryTypes = new ArrayList<>();
//        categoryTypes.add(CategoryType.INCOME);
//        categoryTypes.add(CategoryType.EXPENSE);
//        int[] icons = {R.drawable.icon_plus, R.drawable.icon_minus}; // Иконки для дохода и расхода
//        CategoryTypeAdapter typeAdapter = new CategoryTypeAdapter(this, categoryTypes, icons);
//        spinnerTransactionType.setAdapter(typeAdapter);
    }

    @Override
    public void showAccounts(List<Account> accounts) {
//        ArrayAdapter<Account> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, accounts);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AccountAdapter adapter = new AccountAdapter(this, accounts);
        spinnerAccount.setAdapter(adapter);
        spinnerAccount.setPrompt("Выберите счет");
    }

    @Override
    public void showCategories(List<Category> categories) {
//        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, categories);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        spinnerCategory.setAdapter(adapter);
        spinnerCategory.setPrompt("Выберите категорию");
    }

    @Override
    public void showError(String message) {
        // Отображение сообщения об ошибке
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

