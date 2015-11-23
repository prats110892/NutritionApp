package com.meeshuaghnihotri.nutritionapp;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by batman on 22/11/15.
 */
public class FoodItemAdapter extends BaseAdapter {
    private ArrayList<FoodItem> mFoodItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mFoodItems.size();
    }

    @Override
    public FoodItem getItem(int position) {
        return mFoodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        TextView itemName, itemDescription;
        Button deleteButton;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        } else {
            view = convertView;
        }

        itemName = (TextView) view.findViewById(R.id.item_name);
        itemName.setText(getItem(position).mItemName);
        itemDescription = (TextView) view.findViewById(R.id.item_description);
        itemDescription.setText(getItem(position).mItemDescription);
        deleteButton = (Button) view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        deleteItem(getItem(position));
                    }
                }, 500);
            }
        });
        return view;
    }


    public void addItem(FoodItem foodItem) {
        mFoodItems.add(foodItem);
        notifyDataSetChanged();
    }

    public void deleteItem(FoodItem foodItem) {
        mFoodItems.remove(foodItem);
        notifyDataSetChanged();
    }
}
