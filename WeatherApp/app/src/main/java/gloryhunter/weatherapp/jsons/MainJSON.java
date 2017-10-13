package gloryhunter.weatherapp.jsons;

/**
 * Created by SNOW on 10/13/2017.
 */

public class MainJSON {
    private double temp;
    private double humidity;

    public MainJSON(double temp, double humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }
}
