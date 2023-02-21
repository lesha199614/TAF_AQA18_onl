package dbTables;

import models.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CaseTable {
    Logger logger = LogManager.getLogger(CaseTable.class);
    private DataBaseService dbService;

    public CaseTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Create Case table...");

        String createTableSQL = "create table TestCases " +
                "(   id                SERIAL PRIMARY KEY," +
                "    title             CHARACTER VARYING(30)," +
                "    sectionId         INTEGER," +
                "    templateId        INTEGER," +
                "    typeId            INTEGER," +
                "    priorityId        INTEGER," +
                "    estimate          CHARACTER VARYING(255)," +
                "    references        CHARACTER VARYING(255)," +
                "    automationType    CHARACTER VARYING(255)," +
                "    preconditions     CHARACTER VARYING(255)," +
                "    steps             CHARACTER VARYING(255)," +
                "    expectedResult    CHARACTER VARYING(255)" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Drop customers TestCases...");
        String dropTableSQL = "DROP TABLE if exist public.TestCases";
        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getTestCases() {
        String sql = "SELECT * FROM public.TestCases " +
                "order by 1;";
        return dbService.executeQuery(sql);
    }

    public void addTestCase(TestCase testCase) {
        String insertTableSQL = "INSERT INTO public.TestCases(" +
                "title, sectionId, templateId, typeId, priorityId, estimate, references, automationType," +
                "preconditions, steps, expectedResult)" +
                "VALUES ('" + testCase.getTitle() + "', '" + testCase.getSectionId() +
                "', '" + testCase.getTemplateId() + "', " + testCase.getTypeId() + "', " +
                testCase.getPriorityId() + "', " + testCase.getEstimate() + "', " +
                testCase.getReferences() + "', " + testCase.getAutomationType() + "', " +
                testCase.getPreconditions() + "', " + testCase.getSteps() + "', " + testCase.getExpectedResult() +");";
        dbService.executeSQL(insertTableSQL);
    }

    public ResultSet getTestCasesById(int id) {
        String sql = "SELECT * FROM public.TestCases " +
                "WHERE id = " + id;
        return dbService.executeQuery(sql);
    }

}
