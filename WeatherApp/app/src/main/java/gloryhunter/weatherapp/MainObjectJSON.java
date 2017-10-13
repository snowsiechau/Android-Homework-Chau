package gloryhunter.weatherapp;

import java.util.List;

import gloryhunter.weatherapp.jsons.CoordJSON;
import gloryhunter.weatherapp.jsons.MainJSON;
import gloryhunter.weatherapp.jsons.SysJSON;
import gloryhunter.weatherapp.jsons.WeatherJSON;

/**
 * Created by SNOW on 10/13/2017.
 */

public class MainObjectJSON {
    CoordJSON coord;
    SysJSON sys;
    List<WeatherJSON> weather;
    MainJSON main;

    public CoordJSON getCoord(){
        return coord;
    }

    public SysJSON getSys() {
        return sys;
    }

    public List<WeatherJSON> getWeather() {
        return weather;
    }

    public MainJSON getMain() {
        return main;
    }
}
