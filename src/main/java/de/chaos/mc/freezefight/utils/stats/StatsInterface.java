package de.chaos.mc.freezefight.utils.stats;

import java.util.UUID;

public interface StatsInterface {
    public long getKills(UUID uuid);
    public long getDeath(UUID uuid);
    public long addKills(UUID uuid, long amount);
    public long addDeath(UUID uuid, long amount);
}
