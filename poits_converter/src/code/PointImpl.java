package code;

import model.Point;

/**
 * Created by Blackstar on 12.01.14.
 */
public class PointImpl implements Point {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String name;
    private String description;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Double getLatitude(){
        return latitude;
    }
    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }
    public Double getLongitude(){
        return longitude;
    }
    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String toString(){
        return "Point "+id+" Name: "+name+" Lat: "+latitude+" Lon: "+longitude;

    }

}
