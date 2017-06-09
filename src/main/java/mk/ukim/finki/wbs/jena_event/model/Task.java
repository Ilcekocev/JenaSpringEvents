package mk.ukim.finki.wbs.jena_event.model;

import java.util.Date;

/**
 * Created by Ilce on 5/28/2017.
 */

public class Task {
    private int id;
    private String name;
    private Date time;
    private String lon;
    private String lat;

    public Task(int id,String n, Date d, String la, String lo) {
        this.id=id;
        name=n;
        time = d;
        lon=lo;
        lat = la;
    }

    public String getName() {
        return name;
    }


    public Date getTime() {
        return time;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public int getId() {
        return id;
    }
}
