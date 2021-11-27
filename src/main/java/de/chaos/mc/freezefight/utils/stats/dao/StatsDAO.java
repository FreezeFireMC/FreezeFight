package de.chaos.mc.freezefight.utils.stats.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@DatabaseTable(tableName = "FreezeFightStats")
public class StatsDAO {
    private static final String UUID_FIELD = "UUID";
    private static final String KILLS_FIELD = "UUID";
    private static final String DEATHS_FIELD = "UUID";

    @DatabaseField(id = true, columnName = UUID_FIELD)
    public UUID uuid;
    @DatabaseField(columnName = KILLS_FIELD)
    public long Kills;
    @DatabaseField(columnName = DEATHS_FIELD)
    public long Deaths;
}
