package gloryhunter.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gloryhunter.weatherapp.jsons.CoordJSON;
import gloryhunter.weatherapp.jsons.MainJSON;
import gloryhunter.weatherapp.jsons.SysJSON;
import gloryhunter.weatherapp.jsons.WeatherJSON;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String APPID = "56f68d79992e3efe241ddda0e46e4609";
    public static final String UNIT = "metric";
    EditText etLoction;
    Button btCheck;
    TextView tvLat, tvLon, tvCountry, tvMain, tvTemp, tvHum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUI();

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetWeatherService getWeatherService = RetrofitFactory.getInstance()
                        .create(GetWeatherService.class);

                getWeatherService.getWeather(etLoction.getText().toString(), APPID, UNIT).enqueue(new Callback<MainObjectJSON>() {
                    @Override
                    public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {
                        CoordJSON coord = response.body().getCoord();
                        String lat = String.valueOf(coord.getLat());
                        tvLat.setText(lat);
                        String lon = String.valueOf(coord.getLon());
                        tvLon.setText(lon);

                        SysJSON sys = response.body().getSys();
                        tvCountry.setText(sys.getCountry());

                        List<WeatherJSON> weathers = response.body().getWeather();
                        for (WeatherJSON weather: weathers){
                            tvMain.setText(weather.getDescription());
                        }

                        MainJSON main = response.body().getMain();
                        String temp = String.valueOf(main.getTemp());
                        String hum = String.valueOf(main.getHumidity());
                        tvTemp.setText(temp);
                        tvHum.setText(hum);
                    }

                    @Override
                    public void onFailure(Call<MainObjectJSON> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "no connection", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void loadUI() {
        etLoction = (EditText) findViewById(R.id.et_location);
        btCheck = (Button) findViewById(R.id.bt_check);
        tvLat = (TextView) findViewById(R.id.tv_lat);
        tvLon = (TextView) findViewById(R.id.tv_lon);
        tvCountry = (TextView) findViewById(R.id.tv_country);
        tvMain = (TextView) findViewById(R.id.tv_main);
        tvTemp = (TextView) findViewById(R.id.tv_temp);
        tvHum = (TextView) findViewById(R.id.tv_humidity);
    }
}
