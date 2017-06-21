package mk.ukim.finki.wbs.jena_event.model;

/**
 * @author Ilce Kocev
 */
public class Employee {
    private String name;
    private int id;
    private String lon;
    private String lat;

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public Employee(String name, int id, String lat, String lon) {
        this.name=name;
        this.id=id;
        this.lat=lat;
        this.lon=lon;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

}
