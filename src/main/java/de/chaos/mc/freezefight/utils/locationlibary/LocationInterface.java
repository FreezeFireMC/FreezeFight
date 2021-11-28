package de.chaos.mc.freezefight.utils.locationlibary;

import org.bukkit.Location;

import java.util.List;

public interface LocationInterface {
    List<String> getAllKeys(String Namespace);
    List<String> getAllMaps();
    Location addLocation(String Namespace, String LocationName, Location location);
    Location getLocation(String LocationName);
    Location delLocation(String LocationName);
}
