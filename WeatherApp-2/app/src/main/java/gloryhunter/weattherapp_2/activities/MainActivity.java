package gloryhunter.weattherapp_2.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stone.vega.library.VegaLayoutManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gloryhunter.weattherapp_2.Constants;
import gloryhunter.weattherapp_2.R;
import gloryhunter.weattherapp_2.RetrofitFactory;
import gloryhunter.weattherapp_2.adapter.WeatherAdapter;
import gloryhunter.weattherapp_2.database.WeatherModel;
import gloryhunter.weattherapp_2.network.GetWeatherService;
import gloryhunter.weattherapp_2.network.MainObjectJSON;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "test";
    private RecyclerView rvWeather;
    private List<WeatherModel> weatherModels = new ArrayList<>();
    private WeatherAdapter weatherAdapter;


    private TextView tvCity, tvCountry, tvDate, tvDesciption, tvTemp, tvHum, tvSpeed;
    private ImageView ivWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

        loadData();

    }

    private void loadData() {
        GetWeatherService getWeatherService = RetrofitFactory.getInstance().create(GetWeatherService.class);
        getWeatherService.getWeather("brasil", Constants.APPID, Constants.UNIT, Constants.CNT).enqueue(new Callback<MainObjectJSON>() {
            @Override
            public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {

                if (response.body() == null) {
                    Toast.makeText(MainActivity.this, "Wrong location", Toast.LENGTH_SHORT).show();
                } else {
                    List<MainObjectJSON.ListJSON> listJSONs = response.body().getList();

                    MainObjectJSON.CityJSON cityJSON = response.body().getCity();
                    tvCity.setText(cityJSON.getName());
                    tvCountry.setText(cityJSON.getCountry());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
                    Date date1 = new Date(listJSONs.get(0).getDt() * 1000L);
                    Log.d(TAG, "onResponse: " + sdf.format(date1));
                    tvDate.setText(sdf.format(date1));


                    tvDesciption.setText(listJSONs.get(0).getWeather().get(0).getDescription());

                    Log.d(TAG, "onResponse: " + listJSONs.get(0).getTemp().getDay());
                    tvTemp.setText(String.valueOf((int) (listJSONs.get(0).getTemp().getDay())));
                    tvHum.setText((String.valueOf(listJSONs.get(0).getHumidity()))+ "%");
                    tvSpeed.setText((int) listJSONs.get(0).getSpeed()+" km/h");



                    ivWeather.setImageResource(MainActivity.this.getResources().getIdentifier(
                            "artb_" + listJSONs.get(0).getWeather().get(0).getMain().toLowerCase(),
                            "raw",
                            MainActivity.this.getPackageName()
                    ));

                    for (MainObjectJSON.ListJSON listJSON : listJSONs) {
                        Date date = new Date(listJSON.getDt() * 1000L);
                        Date curDate = new Date(System.currentTimeMillis());
                        if (date.getDate() != curDate.getDate()) {
                            WeatherModel weatherModel = new WeatherModel();
                            weatherModel.setTemp((int) listJSON.getTemp().getDay());
                            weatherModel.setHum((int) listJSON.getHumidity());

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                            if (listJSON.getDt() * 1000L - System.currentTimeMillis() <= 86400000) {
                                weatherModel.setDate("Tomorrow");
                            } else {
                                weatherModel.setDate(simpleDateFormat.format(date));
                            }
                            weatherModel.setImageID(MainActivity.this.getResources().getIdentifier(
                                    "art_" + listJSON.getWeather().get(0).getMain().toLowerCase(),
                                    "raw",
                                    MainActivity.this.getPackageName()
                            ));

                            weatherModels.add(weatherModel);
                        }
                    }
                    weatherAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainObjectJSON> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupUI() {

        tvCity = (TextView) findViewById(R.id.tv_city);
        tvCountry = (TextView) findViewById(R.id.tv_country);
        tvDate = (TextView) findViewById(R.id.tv_time);
        tvDesciption = (TextView) findViewById(R.id.tv_descrip);
        tvTemp = (TextView) findViewById(R.id.tv_tempMain);
        tvHum = (TextView) findViewById(R.id.tv_hum);
        tvSpeed = (TextView) findViewById(R.id.tv_speed);

        ivWeather  = (ImageView) findViewById(R.id.iv_weather);

        rvWeather = (RecyclerView) findViewById(R.id.recycle_view);
        weatherAdapter = new WeatherAdapter(weatherModels);
        rvWeather.setAdapter(weatherAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false
        );

        rvWeather.setLayoutManager(linearLayoutManager);


    }
}
