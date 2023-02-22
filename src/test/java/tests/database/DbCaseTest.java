package tests.database;

import adapters.CaseAdapter;
import baseEntities.BaseApiGSONTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DbCaseTest extends BaseApiGSONTest {
    TestCase expectedCase;
    int caseId;

    @Test
    public void dropTable() {
        testCasesTable.dropTable();
    }

    @Test(dependsOnMethods = "dropTable")
    public void createCaseTable() {
        testCasesTable.createTable();
    }

    @Test(dependsOnMethods = "createCaseTable")
    public void addCaseToTable() {
        expectedCase = new TestCase();
        expectedCase.setTitle("New Test Case");
        expectedCase.setSectionId(1);
        expectedCase.setTemplateId(1);
        expectedCase.setTypeId(1);
        expectedCase.setPriorityId(2);
        testCasesTable.addTestCase(expectedCase);
    }

    @Test(dependsOnMethods = "addCaseToTable")
    public void addCase() {
        CaseAdapter caseAdapter = new CaseAdapter();
        int sectionId = 1;
        expectedCase = testCasesTable.getTestCasesById(1);
        TestCase actualCase = caseAdapter.add(expectedCase, sectionId);
        caseId = actualCase.getId();

        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "addCase")
    public void get() {
        CaseAdapter caseAdapter = new CaseAdapter();
        TestCase actualCase = caseAdapter.get(caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "get")
    public void updateCase() {
        CaseAdapter caseAdapter = new CaseAdapter();
        expectedCase = new TestCase();
        expectedCase.setTitle("New Test Case");
        expectedCase.setSectionId(1);
        expectedCase.setTemplateId(1);
        expectedCase.setTypeId(1);
        expectedCase.setPriorityId(2);
        expectedCase.setPreconditions("New preconditions");
        expectedCase.setSteps("New steps");
        expectedCase.setExpectedResult("New expected result");
        testCasesTable.updateTestCase(expectedCase, 1);
        expectedCase = testCasesTable.getTestCasesById(1);
        TestCase actualCase = caseAdapter.update(expectedCase, caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "updateCase")
    public void moveToSection() {
        CaseAdapter caseAdapter = new CaseAdapter();
        int newSectionId = 2;
        caseAdapter.moveToSection(newSectionId, caseId);
        TestCase actualCase = caseAdapter.get(caseId);
        Assert.assertEquals(newSectionId, actualCase.getSectionId());
    }

    @Test(dependsOnMethods = "moveToSection")
    public void deleteCase() {
        CaseAdapter caseAdapter = new CaseAdapter();
        caseAdapter.deleteCase(caseId);
        caseAdapter.getDeleted(caseId);
    }
}
