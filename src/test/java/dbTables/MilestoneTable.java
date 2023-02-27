package dbTables;

import models.Milestone;
import models.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MilestoneTable {

    Logger logger = LogManager.getLogger(CaseTable.class);
    private DataBaseService dbService;

    public MilestoneTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Create Milestones table...");

        String createTableSQL = "Create table Milestones " +
                "(   id                SERIAL PRIMARY KEY," +
                "    name              CHARACTER VARYING(255)," +
                "    refs              CHARACTER VARYING(255)," +
                "    description       CHARACTER VARYING(255)," +
                "    completed         BOOLEAN" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Drop customers Milestones...");
        String dropTableSQL = "DROP TABLE if exists public.Milestones";
        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getMilestones() {
        String sql = "SELECT * FROM public.Milestones " +
                "order by 1;";
        return dbService.executeQuery(sql);
    }

    public void addMilestone(Milestone milestone) {
        String insertTableSQL = "INSERT INTO public.Milestones(" +
                "name, refs, description, completed)" +
                "VALUES ('" + milestone.getName() + "', " + milestone.getRefs() +
                ", '" + milestone.getDescription() + "', '" + milestone.isCompleted() + "');";
        dbService.executeSQL(insertTableSQL);
    }

    public Milestone getMilestoneById(int id) {
        String sql = "SELECT * FROM public.Milestones " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        Milestone resultMilestone = new Milestone();
        try {
            while (rs.next()) {
                resultMilestone.setId(rs.getInt("id"));
                resultMilestone.setName(rs.getString("name"));
                resultMilestone.setRefs(rs.getString("refs"));
                resultMilestone.setDescription(rs.getString("description"));
                resultMilestone.setCompleted(rs.getBoolean("completed"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultMilestone;
    }

    public void updateMilestone(Milestone milestone, int id) {
        String insertTableSQL = "UPDATE public.Milestones " +
                "SET name = '" + milestone.getName() + "', " +
                "refs = '" + milestone.getRefs() + "', " +
                "description = '" + milestone.getDescription() + "', " +
                "completed = '" + milestone.isCompleted() + "' " +
                "WHERE id = " + id;
        dbService.executeSQL(insertTableSQL);
    }


}
