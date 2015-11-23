package com.meeshuaghnihotri.nutritionapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.Result;

import org.parceler.Parcels;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 *
 * Created by batman on 22/11/15.
 */
public class MainActivity extends Activity implements ZXingScannerView.ResultHandler{
    public static final String TAG = MainActivity.class.getSimpleName();

    private ListView mFoodItems;
    private FoodItemAdapter mAdapter;

    private Button mScanButton;
    private ZXingScannerView mScannerView;

    private FoodRequestService mFoodRequestService;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
        setUpButtonControl();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setUpButtonControl() {
        mScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showScannerView();
            }
        });
    }

    private void showScannerView() {
        mScannerView.setVisibility(View.VISIBLE);
        mScannerView.startCamera();
    }

    private void hideScannerView() {
        mScannerView.stopCamera();
        mScannerView.setVisibility(View.GONE);
    }


    private void init() {
        mFoodItems = (ListView) findViewById(R.id.item_list);
        mFoodItems.setClickable(false);
        mFoodItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodItem foodItem = mAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, NutritionInfoActivity.class);
                intent.putExtra(NutritionInfoActivity.FOOD_ITEM_TAG, Parcels.wrap(foodItem));
                startActivityForResult(intent, 100);
            }
        });
        mAdapter = new FoodItemAdapter();
        mFoodItems.setAdapter(mAdapter);

        mScanButton = (Button) findViewById(R.id.scan_and_add_button);
        mScannerView = (ZXingScannerView) findViewById(R.id.barcode_scanner);
        mScannerView.setResultHandler(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getString(R.string.progress_message));
        mProgressDialog.setCancelable(false);

        mFoodRequestService = ServiceGenerator.createService(FoodRequestService.class);
    }

    @Override
    public void handleResult(Result result) {
        Log.d(TAG, "Barcode result: " + result.getText());
        hideScannerView();
        Call<FoodItem> foodItemCall = mFoodRequestService.getFoodItem(result.getText(),
                getString(R.string.app_id), getString(R.string.app_key));

        mProgressDialog.show();

        foodItemCall.enqueue(new Callback<FoodItem>() {
            @Override
            public void onResponse(Response<FoodItem> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.hide();
                    }
                    Log.d(TAG, "Food Item found. Response: " + response);
                    FoodItem foodItem = response.body();
                    mAdapter.addItem(foodItem);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.hide();
                }
                Toast.makeText(MainActivity.this, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Some Error Occurred:" + t);
            }
        });
    }
}
