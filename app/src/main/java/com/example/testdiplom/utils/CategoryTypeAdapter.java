package com.example.testdiplom.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdiplom.R;
import com.example.testdiplom.category.CategoryType;

import java.util.List;

public class CategoryTypeAdapter extends ArrayAdapter<CategoryType> {
    private final Context context;
    private final List<CategoryType> categoryTypes;
    private final int[] icons;

    public CategoryTypeAdapter(Context context, List<CategoryType> categoryTypes, int[] icons) {
        super(context, R.layout.spinner_item, categoryTypes);
        this.context = context;
        this.categoryTypes = categoryTypes;
        this.icons = icons;
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

        CategoryType categoryType = categoryTypes.get(position);

        TextView textView = view.findViewById(R.id.textViewName);
        textView.setText(categoryType.getDisplayName());

        ImageView imageView = view.findViewById(R.id.imageViewIcon);
        imageView.setImageResource(icons[position]);

        return view;
    }
}

