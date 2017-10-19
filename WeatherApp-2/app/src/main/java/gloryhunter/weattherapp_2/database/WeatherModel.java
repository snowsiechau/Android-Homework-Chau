package gloryhunter.weattherapp_2.database;

/**
 * Created by SNOW on 10/16/2017.
 */

public class WeatherModel {
    private String date;
    private int imageID;
    private int temp;
    private int hum;

    public String getDate() {
        return date;
    }

    public int getImageID() {
        return imageID;
    }

    public int getTemp() {
        return temp;
    }

    public int getHum() {
        return hum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }
}
