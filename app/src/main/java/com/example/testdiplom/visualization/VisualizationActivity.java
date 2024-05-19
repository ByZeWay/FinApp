package com.example.testdiplom.visualization;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdiplom.R;
import com.example.testdiplom.transaction.Transaction;
import com.example.testdiplom.transaction.TransactionType;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.List;

// VisualizationActivity.java

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// VisualizationActivity.java
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// VisualizationActivity.java
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// VisualizationActivity.java
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VisualizationActivity extends AppCompatActivity implements VisualizationContract.View {
    private VisualizationContract.Presenter presenter;
    private BarChart barChart;
    private Button buttonLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualization);

        barChart = findViewById(R.id.barChart);
        buttonLoadData = findViewById(R.id.buttonLoadData);

        presenter = new VisualizationPresenter(this);

        buttonLoadData.setOnClickListener(v -> presenter.loadTransactions());

        // Enable scrolling
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setPinchZoom(true);
    }

    @Override
    public void showTransactions(List<Transaction> transactions) {
        Map<String, List<Transaction>> transactionsByMonth = new HashMap<>();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM yyyy", Locale.getDefault());

        for (Transaction transaction : transactions) {
            String month = monthFormat.format(transaction.getDate());
            if (!transactionsByMonth.containsKey(month)) {
                transactionsByMonth.put(month, new ArrayList<>());
            }
            transactionsByMonth.get(month).add(transaction);
        }

        List<String> sortedMonths = new ArrayList<>(transactionsByMonth.keySet());
        Collections.sort(sortedMonths, (o1, o2) -> {
            try {
                return monthFormat.parse(o1).compareTo(monthFormat.parse(o2));
            } catch (Exception e) {
                return o1.compareTo(o2);
            }
        });

        List<BarEntry> incomeEntries = new ArrayList<>();
        List<BarEntry> expenseEntries = new ArrayList<>();
        List<BarEntry> balanceEntries = new ArrayList<>();
        List<BarEntry> lossEntries = new ArrayList<>();

        int index = 0;
        for (String month : sortedMonths) {
            List<Transaction> monthlyTransactions = transactionsByMonth.get(month);
            float totalIncome = 0;
            float totalExpense = 0;

            for (Transaction transaction : monthlyTransactions) {
                if (transaction.getType() == TransactionType.INCOME) {
                    totalIncome += transaction.getAmount();
                } else if (transaction.getType() == TransactionType.EXPENSE) {
                    totalExpense += transaction.getAmount();
                }
            }

            float balance = totalIncome - totalExpense;
            incomeEntries.add(new BarEntry(index, totalIncome));
            expenseEntries.add(new BarEntry(index, totalExpense));
            if (balance >= 0) {
                balanceEntries.add(new BarEntry(index, balance));
                lossEntries.add(new BarEntry(index, 0));
            } else {
                balanceEntries.add(new BarEntry(index, 0));
                lossEntries.add(new BarEntry(index, -balance));
            }
            index++;
        }

        BarDataSet incomeDataSet = new BarDataSet(incomeEntries, "Доходы");
        incomeDataSet.setColor(Color.parseColor("#00FF7F"));

        BarDataSet expenseDataSet = new BarDataSet(expenseEntries, "Расходы");
        expenseDataSet.setColor(Color.parseColor("#FFA500"));

        BarDataSet balanceDataSet = new BarDataSet(balanceEntries, "Прибыль");
        balanceDataSet.setColor(Color.parseColor("#32CD32"));

        BarDataSet lossDataSet = new BarDataSet(lossEntries, "Убыток");
        lossDataSet.setColor(Color.parseColor("#DC143C"));

        BarData data = new BarData(incomeDataSet, expenseDataSet, balanceDataSet, lossDataSet);
        data.setBarWidth(0.15f);
        barChart.setData(data);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(sortedMonths));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);

        barChart.groupBars(0f, 0.3f, 0.02f);
        barChart.invalidate();
    }


    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


