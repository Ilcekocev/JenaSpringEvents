package mk.ukim.finki.wbs.jena_event.model;

/**
 * @author Ilce Kocev
 */
public class Employee {
    private String name;
    private int id;
    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public Employee(String name, int id, double lat, double lon) {
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
