package gloryhunter.weatherapp.jsons;

/**
 * Created by SNOW on 10/13/2017.
 */

public class CoordJSON {
    private double lon;
    private double lat;

    public CoordJSON(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
