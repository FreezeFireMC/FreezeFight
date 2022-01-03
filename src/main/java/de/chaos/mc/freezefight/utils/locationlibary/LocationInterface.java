package de.chaos.mc.freezefight.utils.locationlibary;

import org.bukkit.Location;

import java.util.List;

public interface LocationInterface {
    List<String> getAllLocations();

    Location addLocation(String LocationName, Location location);

    Location getLocation(String LocationName);
}
