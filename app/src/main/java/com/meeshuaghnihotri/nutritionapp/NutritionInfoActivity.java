package com.meeshuaghnihotri.nutritionapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

/**
 * Created by batman on 22/11/15.
 */
public class NutritionInfoActivity extends Activity {
    public static final String TAG = NutritionInfoActivity.class.getSimpleName();
    public static final String FOOD_ITEM_TAG = TAG + ".foodItem";
    private FoodItem mFoodItem;
    private Button mDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_info_activity);

        mFoodItem = Parcels.unwrap(getIntent().getParcelableExtra(FOOD_ITEM_TAG));
        mDoneButton = (Button) findViewById(R.id.back_button);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sanitizeValues();

        setTextValues();
    }

    private void sanitizeValues() {
        if (mFoodItem.mItemName.isEmpty()) {
            mFoodItem.mItemName = "Not Available";
        }

        if (mFoodItem.mItemDescription.isEmpty()) {
            mFoodItem.mItemDescription = "Not Available";
        }

        if (mFoodItem.mIngredients.isEmpty()) {
            mFoodItem.mIngredients = "Not Available";
        }

        if (mFoodItem.mServingsPerContainer <= 0) {
            mFoodItem.mServingsPerContainer = 1;
        }

        if (mFoodItem.mServingSize <= 0) {
            mFoodItem.mServingSize = 1;
        }

        if (mFoodItem.mServingSizeUnit.isEmpty()) {
            mFoodItem.mServingSizeUnit = "Not Available";
        }

        if (mFoodItem.mCalories <= 0) {
            mFoodItem.mCalories = 0;
        }

        if (mFoodItem.mCaloriesFromFat <= 0) {
            mFoodItem.mCaloriesFromFat = 0;
        }

        if (mFoodItem.mTotalFat <= 0) {
            mFoodItem.mTotalFat = 0;
        }

        if (mFoodItem.mSaturatedFat <= 0) {
            mFoodItem.mSaturatedFat = 0;
        }

        if (mFoodItem.mCholesterol <= 0) {
            mFoodItem.mCholesterol = 0;
        }

        if (mFoodItem.mSodium <= 0) {
            mFoodItem.mSodium = 0;
        }

        if (mFoodItem.mTotalCarbs <= 0) {
            mFoodItem.mTotalCarbs = 0;
        }

        if (mFoodItem.mDietaryFiber <= 0) {
            mFoodItem.mDietaryFiber = 0;
        }

        if (mFoodItem.mSugar <= 0) {
            mFoodItem.mSugar = 0;
        }

        if (mFoodItem.mProtein <= 0) {
            mFoodItem.mProtein = 0;
        }

        if (mFoodItem.mVitaminA <= 0) {
            mFoodItem.mVitaminA = 0;
        }

        if (mFoodItem.mVitaminC <= 0) {
            mFoodItem.mVitaminC = 0;
        }

        if (mFoodItem.mCalcium <= 0) {
            mFoodItem.mCalcium = 0;
        }

        if (mFoodItem.mIron <= 0) {
            mFoodItem.mIron = 0;
        }

    }

    private void setTextValues() {
        ((TextView) findViewById(R.id.item_name)).setText(mFoodItem.mItemName);
        ((TextView) findViewById(R.id.item_description)).setText(mFoodItem.mItemDescription);
        ((TextView) findViewById(R.id.item_ingredients)).setText(mFoodItem.mIngredients);
        ((TextView) findViewById(R.id.item_servings_per_container)).
                setText(String.valueOf(mFoodItem.mServingsPerContainer));
        ((TextView) findViewById(R.id.item_serving_size)).setText(String.valueOf(mFoodItem.mServingSize));
        ((TextView) findViewById(R.id.item_serving_size_unit)).setText(mFoodItem.mServingSizeUnit);
        ((TextView) findViewById(R.id.item_calories)).setText(String.valueOf(mFoodItem.mCalories));
        ((TextView) findViewById(R.id.item_calories_from_fat)).setText(String.valueOf(mFoodItem.mCaloriesFromFat));
        ((TextView) findViewById(R.id.item_fat)).setText(String.valueOf(mFoodItem.mTotalFat));
        ((TextView) findViewById(R.id.item_saturated_fat)).setText(String.valueOf(mFoodItem.mSaturatedFat));
        ((TextView) findViewById(R.id.item_cholesterol)).setText(String.valueOf(mFoodItem.mCholesterol));
        ((TextView) findViewById(R.id.item_sodium)).setText(String.valueOf(mFoodItem.mSodium));
        ((TextView) findViewById(R.id.item_carbs)).setText(String.valueOf(mFoodItem.mTotalCarbs));
        ((TextView) findViewById(R.id.item_dietary_fiber)).setText(String.valueOf(mFoodItem.mDietaryFiber));
        ((TextView) findViewById(R.id.item_sugar)).setText(String.valueOf(mFoodItem.mSugar));
        ((TextView) findViewById(R.id.item_proteins)).setText(String.valueOf(mFoodItem.mProtein));
        ((TextView) findViewById(R.id.item_vitamin_a)).setText(String.valueOf(mFoodItem.mVitaminA));
        ((TextView) findViewById(R.id.item_vitamin_c)).setText(String.valueOf(mFoodItem.mVitaminC));
        ((TextView) findViewById(R.id.item_calcium)).setText(String.valueOf(mFoodItem.mCalcium));
        ((TextView) findViewById(R.id.item_iron)).setText(String.valueOf(mFoodItem.mIron));
    }
}
