package tests.database;

import baseEntities.BaseApiGSONTest;
import dbTables.CaseTable;
import org.testng.annotations.Test;

public class DataBaseTest extends BaseApiGSONTest {
    @Test
    public void createCaseTable(){
        CaseTable testCasesTable = new CaseTable(dbService);
        testCasesTable.createTable();
    }
}
