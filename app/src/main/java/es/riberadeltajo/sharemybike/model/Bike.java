package es.riberadeltajo.sharemybike.model;

public class Bike {
    // bike only has a brand and a model
    private String city;
    private String country;
    private String description;
    private String email;
    private String image;
    private double latitude;
    private String location;
    private double longitude;
    private String owner;

    public Bike() {
        //constructor vacio necesario para firebase
    }

    public Bike(String city, String country, String description, String email, String image,
                double latitude,String location, double longitude, String owner) {
        this.city = city;
        this.country = country;
        this.description = description;
        this.email = email;
        this.image = image;
        this.latitude = latitude;
        this.location = location;
        this.longitude = longitude;
        this.owner = owner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
