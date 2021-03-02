package com.rtsoftworld.retrofitgetpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rtsoftworld.retrofitgetpost.Model.MyDataModel;
import com.rtsoftworld.retrofitgetpost.network.ApiInterface;
import com.rtsoftworld.retrofitgetpost.network.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView ipAddress;
    TextView country;
    TextView city;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = new ProgressBar(this);

        ipAddress = findViewById(R.id.ipAddress);
        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyIp(view);
            }
        });

    }

    private void showMyIp(View view) {
        progressBar.setVisibility(View.VISIBLE);  //network call start. show progress bar

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        Call<MyDataModel> call = apiInterface.getMyIp();
        call.enqueue(new Callback<MyDataModel>() {
            @Override
            public void onResponse(Call<MyDataModel> call, Response<MyDataModel> response) {
                progressBar.setVisibility(View.GONE); //network call success

                MyDataModel myDataModel = response.body();

                if (response.code() == 200 && myDataModel != null){ //response code 200 means server call successful
                    //data found so place the data into textview
                    ipAddress.setText(myDataModel.getIp());
                    country.setText(myDataModel.getCountry());
                    city.setText(myDataModel.getCity());
                } else{
                    // if data not found then error message show in first text view
                    ipAddress.setText(response.message());
                    country.setText("");
                    city.setText("");
                }

            }

            @Override
            public void onFailure(Call<MyDataModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                // if failure
                ipAddress.setText(t.getMessage());
                country.setText("");
                city.setText("");
            }
        });
    }


}