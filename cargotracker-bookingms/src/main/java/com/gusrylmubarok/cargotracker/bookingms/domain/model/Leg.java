package com.gusrylmubarok.cargotracker.bookingms.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Leg extends Itinerary {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");

    private String voyagerNumber;
    private String fromUnLocode;
    private String toUnLocode;
    private String loadTime;
    private String unloadTime;

    private Voyage voyage;
    private Location loadLocation;
    private Location unloadLocation;
    private Date loadTimeDate;
    private Date unloadTimeDate;

    public Leg(String voyagerNumber, String fromUnLocode, String toUnLocode,
               String loadTime, String unloadTime) {
        this.voyagerNumber = voyagerNumber;
        this.fromUnLocode = fromUnLocode;
        this.toUnLocode = toUnLocode;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;
    }

    public Leg(Voyage voyage, Location loadLocation, Location unloadLocation,
               Date loadTimeDate, Date unloadTimeDate) {
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTimeDate = loadTimeDate;
        this.unloadTimeDate = unloadTimeDate;
    }

    public String getVoyagerNumber() {
        return voyagerNumber;
    }

    public void setVoyagerNumber(String voyagerNumber) {
        this.voyagerNumber = voyagerNumber;
    }

    public String getFromUnLocode() {
        return fromUnLocode;
    }

    public void setFromUnLocode(String fromUnLocode) {
        this.fromUnLocode = fromUnLocode;
    }

    public String getToUnLocode() {
        return toUnLocode;
    }

    public void setToUnLocode(String toUnLocode) {
        this.toUnLocode = toUnLocode;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    public String getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(String unloadTime) {
        this.unloadTime = unloadTime;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "voyagerNumber='" + voyagerNumber + '\'' +
                ", fromUnLocode='" + fromUnLocode + '\'' +
                ", toUnLocode='" + toUnLocode + '\'' +
                ", loadTime='" + loadTime + '\'' +
                ", unloadTime='" + unloadTime + '\'' +
                '}';
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public Location getLoadLocation() {
        return loadLocation;
    }

    public Location getUnloadLocation() {
        return unloadLocation;
    }

    public Date getLoadTimeDate() {
        return loadTimeDate;
    }

    public Date getUnloadTimeDate() {
        return unloadTimeDate;
    }
}
