package com.meeshuaghnihotri.nutritionapp;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by batman on 22/11/15.
 */

@Parcel
public class FoodItem {
    @SerializedName("item_id")
    public String mItemID;
    @SerializedName("item_name")
    public String mItemName;
    @SerializedName("brand_id")
    public String mBrandID;
    @SerializedName("brand_name")
    public String mBrandName;
    @SerializedName("item_description")
    public String mItemDescription;
    @SerializedName("updated_at")
    public String mUpdatedAt;
    @SerializedName("nf_ingredient_statement")
    public String mIngredients;
    @SerializedName("nf_calories")
    public int mCalories;
    @SerializedName("nf_calories_from_fat")
    public int mCaloriesFromFat;
    @SerializedName("nf_total_fat")
    public int mTotalFat;
    @SerializedName("nf_saturated_fat")
    public int mSaturatedFat;
    @SerializedName("nf_cholesterol")
    public int mCholesterol;
    @SerializedName("nf_sodium")
    public int mSodium;
    @SerializedName("nf_total_carbohydrate")
    public int mTotalCarbs;
    @SerializedName("nf_dietary_fiber")
    public int mDietaryFiber;
    @SerializedName("nf_sugars")
    public int mSugar;
    @SerializedName("nf_protein")
    public int mProtein;
    @SerializedName("nf_vitamin_a_dv")
    public int mVitaminA;
    @SerializedName("nf_vitamin_c_dv")
    public int mVitaminC;
    @SerializedName("nf_calcium_dv")
    public int mCalcium;
    @SerializedName("nf_iron_dv")
    public int mIron;
    @SerializedName("nf_servings_per_container")
    public int mServingsPerContainer;
    @SerializedName("nf_serving_size_qty")
    public int mServingSize;
    @SerializedName("nf_serving_size_unit")
    public String mServingSizeUnit;
}
