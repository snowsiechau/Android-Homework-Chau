package gloryhunter.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SNOW on 10/13/2017.
 */

public interface GetWeatherService {
    @GET("data/2.5/weather?")
    Call<MainObjectJSON> getWeather(@Query("q") String location, @Query("appid") String appID );
}
