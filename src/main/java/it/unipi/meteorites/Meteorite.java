package it.unipi.meteorites;


public class Meteorite {
    private Long year;
    private Integer mass;
    private String lat;
    private String lon;
    private String recclass;
    private Boolean resolved;
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

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public void setRecclass(String recclass) {
        this.recclass = recclass;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getInfo() {
        return info.toString();
    }

    public Boolean isResolved() {
        return resolved;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public Integer getMass() {
        return mass;
    }

    public Long getYear() {
        return year;
    }

    public String getRecclass() {
        return recclass;
    }
}
