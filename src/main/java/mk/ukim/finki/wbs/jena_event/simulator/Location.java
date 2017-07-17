package mk.ukim.finki.wbs.jena_event.simulator;

/**
 * Created by Ilce on 6/23/2017.
 */
public class Location {

    double longitude;
    double latitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void IncrementLoc(double lat, double lot) {
        latitude+=lat;
        longitude+= lot;
    }

    public  void DecrementLoc(double lat,double lot) {
        latitude-=lat;
        longitude-= lot;
    }

    @Override
    public String toString() {
        return longitude+" "+latitude;
    }
}

