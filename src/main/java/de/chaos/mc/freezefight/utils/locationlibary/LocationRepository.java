package de.chaos.mc.freezefight.utils.locationlibary;

import lombok.Getter;
import org.bukkit.Location;

import java.util.Arrays;
import java.util.List;

public class LocationRepository implements LocationInterface {
    @Getter
    private final LocationConfigHandler locationConfigHandler;


    public LocationRepository() {
        this.locationConfigHandler = new LocationConfigHandler();
        locationConfigHandler.loadConfig();
    }

    @Override
    public List<String> getAllLocations() {
        List<String> locations = Arrays.asList(locationConfigHandler.getLocationsFile().list());
        return locations;
    }


    @Override
    public Location addLocation(String Locationname, Location location) {
        locationConfigHandler.saveMap(Locationname, location);
        return location;
    }

    @Override
    public Location getLocation(String LocationName) {
        return locationConfigHandler.readLocation(LocationName);
    }
}