package de.chaos.mc.freezefight.utils.daos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DatabaseTable(tableName = "FreezeFightStats")
public class StatsDAO {
    private static final String UUID_FIELD = "UUID";
    private static final String KILLS_FIELD = "KILLS";
    private static final String DEATHS_FIELD = "DEATHS";

    @DatabaseField(id = true, columnName = UUID_FIELD)
    public UUID uuid;
    @DatabaseField(columnName = KILLS_FIELD)
    public long Kills;
    @DatabaseField(columnName = DEATHS_FIELD)
    public long Deaths;
}
