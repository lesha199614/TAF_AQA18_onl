package dbTables;

import models.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

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
                "    refs        CHARACTER VARYING(255)," +
                "    automationType    CHARACTER VARYING(255)," +
                "    preconditions     CHARACTER VARYING(255)," +
                "    steps             CHARACTER VARYING(255)," +
                "    expectedResult    CHARACTER VARYING(255)" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Drop customers TestCases...");
        String dropTableSQL = "DROP TABLE if exists public.TestCases";
        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getTestCases() {
        String sql = "SELECT * FROM public.TestCases " +
                "order by 1;";
        return dbService.executeQuery(sql);
    }

    public void addTestCase(TestCase testCase) {
        String insertTableSQL = "INSERT INTO public.TestCases(" +
                "title, sectionId, templateId, typeId, priorityId, refs," +
                "preconditions, steps, expectedResult)" +
                "VALUES ('" + testCase.getTitle() + "', '" + testCase.getSectionId() +
                "', '" + testCase.getTemplateId() + "', '" + testCase.getTypeId() + "', '" +
                testCase.getPriorityId() + "', '" +
                testCase.getRefs() + "', '"  + testCase.getPreconditions() + "', '"
                + testCase.getSteps() + "', '" + testCase.getExpectedResult() + "');";
        dbService.executeSQL(insertTableSQL);
    }

    public TestCase getTestCasesById(int id) {
        String sql = "SELECT * FROM public.TestCases " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        TestCase resultCase = new TestCase();
        try {
            while (rs.next()) {
                resultCase.setId(rs.getInt("id"));
                resultCase.setTitle(rs.getString("title"));
                resultCase.setSectionId(rs.getInt("sectionId"));
                resultCase.setTemplateId(rs.getInt("templateId"));
                resultCase.setTypeId(rs.getInt("typeId"));
                resultCase.setPriorityId(rs.getInt("priorityId"));
                resultCase.setRefs(rs.getString("refs"));
                resultCase.setPreconditions(rs.getString("preconditions"));
                resultCase.setSteps(rs.getString("steps"));
                resultCase.setExpectedResult(rs.getString("expectedResult"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultCase;
    }


    public void updateTestCase(TestCase testCase, int id) {
        String insertTableSQL = "UPDATE public.TestCases " +
                "SET title = '" + testCase.getTitle() + "', " +
                "sectionId = '" + testCase.getSectionId() + "', " +
                "templateId = '" + testCase.getTemplateId() + "', " +
                "typeId = '" + testCase.getTypeId() + "', " +
                "priorityId = '" + testCase.getPriorityId() + "', " +
                "refs = '" + testCase.getRefs() + "', " +
                "preconditions = '" + testCase.getPreconditions() + "', " +
                "steps = '" + testCase.getSteps() + "', " +
                "expectedResult = '" + testCase.getExpectedResult() + "' " +
                "WHERE id = " + id;
        dbService.executeSQL(insertTableSQL);
    }
}
