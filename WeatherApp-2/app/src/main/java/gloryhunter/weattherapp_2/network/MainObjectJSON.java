package gloryhunter.weattherapp_2.network;

import java.util.List;

/**
 * Created by SNOW on 10/16/2017.
 */

public class MainObjectJSON {
    CityJSON city;
    List<ListJSON> list;

    public CityJSON getCity() {
        return city;
    }

    public List<ListJSON> getList() {
        return list;
    }

    public class CityJSON{
        private String name;
        private String country;

        public CityJSON(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }
    }


    public class ListJSON{
        private long dt;
        private TempJSON temp;
        private double humidity;
        private List<WetherJSON> weather;
        private double speed;


        public ListJSON(long dt, TempJSON temp, double humidity, List<WetherJSON> weather, double speed) {
            this.dt = dt;
            this.temp = temp;
            this.humidity = humidity;
            this.weather = weather;
            this.speed = speed;
        }

        public long getDt() {
            return dt;
        }

        public TempJSON getTemp() {
            return temp;
        }

        public double getHumidity() {
            return humidity;
        }

        public List<WetherJSON> getWeather() {
            return weather;
        }

        public double getSpeed() {
            return speed;
        }
    }

    public class TempJSON{
        private double day;
        private double min;
        private double max;
        private double night;
        private double eve;
        private double morn;

        public TempJSON(double day, double min, double max, double night, double eve, double morn) {
            this.day = day;
            this.min = min;
            this.max = max;
            this.night = night;
            this.eve = eve;
            this.morn = morn;
        }

        public double getDay() {
            return day;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public double getNight() {
            return night;
        }

        public double getEve() {
            return eve;
        }

        public double getMorn() {
            return morn;
        }
    }

    public class WetherJSON{
        private String main;
        private String description;

        public WetherJSON(String main, String description) {
            this.main = main;
            this.description = description;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }
    }
}
