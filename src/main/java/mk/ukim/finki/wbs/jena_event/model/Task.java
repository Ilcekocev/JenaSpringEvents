package mk.ukim.finki.wbs.jena_event.model;

import java.util.Date;

/**
 * Created by Ilce on 5/28/2017.
 */

public class Task {
    private String name;
    private Date time;

    public Task(String n, Date d) {
        name=n;
        time = d;
    }

    public String getName() {
        return name;
    }


    public Date getTime() {
        return time;
    }


}
