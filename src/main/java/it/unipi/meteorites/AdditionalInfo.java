package it.unipi.meteorites;

public class AdditionalInfo {
    private String Name;
    private String State;
    private String Country;

    public AdditionalInfo(String n, String s, String c){
        Name=n;
        State=s;
        Country=c;
    }

    public String getCountry() {
        return Country;
    }

    public String getName() {
        return Name;
    }

    public String getState() {
        return State;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "{\"Name\":\""+Name+"\",\"State\":\""+State+"\",\"Country\":\""+Country+"\"}";
    }
}
