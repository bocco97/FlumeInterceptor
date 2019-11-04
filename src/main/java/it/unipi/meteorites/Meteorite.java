package it.unipi.meteorites;

public class Meteorite {
    private String year;
    private String mass;
    private String lat;
    private String lon;
    private String recclass;
    private String resolved;
    private AdditionalInfo info;

    public void setInfo(AdditionalInfo info) {
        this.info = info;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setRecclass(String recclass) {
        this.recclass = recclass;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInfo() {
        return info.toString();
    }

    public String isResolved() {
        return resolved;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getMass() {
        return mass;
    }

    public String getYear() {
        return year;
    }

    public String getRecclass() {
        return recclass;
    }
}
