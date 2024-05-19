package com.example.testdiplom.category;

import com.example.testdiplom.R;

public enum CategoryType {
    INCOME("Доход", R.drawable.icon_plus),
    EXPENSE("Расход", R.drawable.icon_minus);

    private final String displayName;
    private final int iconResource;

    CategoryType(String displayName, int iconResource) {
        this.displayName = displayName;
        this.iconResource = iconResource;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getIconResource() {
        return iconResource;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

