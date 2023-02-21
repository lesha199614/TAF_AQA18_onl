package tests.api;

import adapters.CaseAdapter;
import baseEntities.BaseApiGSONTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CasesTest extends BaseApiGSONTest {
    TestCase expectedCase;
    CaseAdapter caseAdapter = new CaseAdapter();
    int caseId;

    @Test
    public void addCase() {
        int sectionId = 1;
        expectedCase = new TestCase();
        expectedCase.setTitle("New Test Case");
        expectedCase.setSectionId(1);
        expectedCase.setTemplateId(1);
        expectedCase.setTypeId(1);
        expectedCase.setPriorityId(2);

        TestCase actualCase = caseAdapter.add(expectedCase, sectionId);
        caseId = actualCase.getId();

        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "addCase")
    public void get() {
        TestCase actualCase = caseAdapter.get(caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "get")
    public void updateCase() {
        expectedCase.setPreconditions("New preconditions");
        expectedCase.setSteps("New steps");
        expectedCase.setExpectedResult("New expected result");

        TestCase actualCase = caseAdapter.update(expectedCase, caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }


    @Test(dependsOnMethods = "updateCase")
    public void moveToSection() {
        int newSectionId = 2;
        caseAdapter.moveToSection(newSectionId, caseId);
        TestCase actualCase = caseAdapter.get(caseId);
        Assert.assertEquals(newSectionId, actualCase.getSectionId());
    }

    @Test(dependsOnMethods = "moveToSection")
    public void deleteCase() {
        caseAdapter.deleteCase(caseId);
    }
}
