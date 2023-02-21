package tests.database;

import baseEntities.BaseApiGSONTest;
import dbTables.CaseTable;
import models.TestCase;
import org.testng.annotations.Test;

public class DataBaseTest extends BaseApiGSONTest {
    TestCase expectedCase;
    CaseTable testCasesTable = new CaseTable(dbService);
    @Test
    public void createCaseTable(){
        testCasesTable = new CaseTable(dbService);
        testCasesTable = new CaseTable(dbService);
        testCasesTable.createTable();
    }

    @Test
    public void dropTable(){
        testCasesTable.dropTable();
    }

    @Test
    public void addCaseToTable() {
        expectedCase = new TestCase();
        expectedCase.setTitle("New Test Case");
        expectedCase.setSectionId(1);
        expectedCase.setTemplateId(1);
        expectedCase.setTypeId(1);
        expectedCase.setPriorityId(2);
        testCasesTable.addTestCase1(expectedCase);
    }

}
