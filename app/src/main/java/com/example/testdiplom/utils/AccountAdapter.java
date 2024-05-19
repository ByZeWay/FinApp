package com.example.testdiplom.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdiplom.account.Account;
import com.example.testdiplom.R;

import java.util.List;

public class AccountAdapter extends ArrayAdapter<Account> {
    private final Context context;
    private final List<Account> accounts;

    public AccountAdapter(Context context, List<Account> accounts) {
        super(context, R.layout.spinner_item, accounts);
        this.context = context;
        this.accounts = accounts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }

        Account account = accounts.get(position);

        TextView textView = view.findViewById(R.id.textViewName);
        textView.setText(account.getName());

        ImageView imageView = view.findViewById(R.id.imageViewIcon);
        imageView.setImageResource(account.getIconResId());

        return view;
    }
}
