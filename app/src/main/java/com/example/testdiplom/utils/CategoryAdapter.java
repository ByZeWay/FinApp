package com.example.testdiplom.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdiplom.R;
import com.example.testdiplom.category.Category;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private final Context context;
    private final List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        super(context, R.layout.spinner_item, categories);
        this.context = context;
        this.categories = categories;
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

        Category category = categories.get(position);

        TextView textView = view.findViewById(R.id.textViewName);
        textView.setText(category.getName());

        ImageView imageView = view.findViewById(R.id.imageViewIcon);
        imageView.setImageResource(category.getIconResId());

        return view;
    }
}
