package gloryhunter.weattherapp_2.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SNOW on 10/16/2017.
 */

public interface GetWeatherService {
    @GET("forecast/daily?")
    Call<MainObjectJSON> getWeather(@Query("q") String location,
                                    @Query("appid") String appid,
                                    @Query("units") String unit,
                                    @Query("cnt") int cnt
    );
}
