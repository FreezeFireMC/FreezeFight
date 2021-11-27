package de.chaos.mc.freezefight.utils.stats;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import de.chaos.mc.freezefight.utils.stats.dao.StatsDAO;
import de.chaos.mc.serverapi.utils.daos.DAOManager;

import java.sql.SQLException;
import java.util.UUID;

public class StatsRepository implements StatsInterface {
    private JdbcPooledConnectionSource source;
    public DAOManager<StatsDAO, UUID> daoManager;
    public StatsRepository(JdbcPooledConnectionSource source) {
        this.source = source;
        this.daoManager = new DAOManager<StatsDAO, UUID>(StatsDAO.class, source);
    }

    @Override
    public long getKills(UUID uuid) {
        StatsDAO dao = null;
        try {
            dao = daoManager.getDAO().queryForId(uuid);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dao.getKills();
    }

    @Override
    public long getDeath(UUID uuid) {
        StatsDAO dao = null;
        try {
            dao = daoManager.getDAO().queryForId(uuid);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dao.getDeaths();
    }

    @Override
    public long addKills(UUID uuid, long amount) {
        StatsDAO dao = null;
        try {
            dao = daoManager.getDAO().queryForId(uuid);
            dao.setKills(Math.addExact(dao.getKills(), amount));
            daoManager.getDAO().createOrUpdate(dao);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dao.getKills();
    }

    @Override
    public long addDeath(UUID uuid, long amount) {
        StatsDAO dao = null;
        try {
            dao = daoManager.getDAO().queryForId(uuid);
            dao.setDeaths(Math.addExact(dao.getDeaths(), amount));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dao.getDeaths();
    }
}
