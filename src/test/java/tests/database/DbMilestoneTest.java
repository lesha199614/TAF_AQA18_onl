package tests.database;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiGSONTest;
import models.Milestone;
import models.Project;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DbMilestoneTest extends BaseApiGSONTest {

    Milestone expectedMilestone;
    int milestoneId;
    int projectId;

    @Test
    public void dropTable() {
        milestoneTable.dropTable();
    }

    @Test(dependsOnMethods = "dropTable")
    public void createMilestoneTable() {
        milestoneTable.createTable();
    }

    @Test(dependsOnMethods = "createMilestoneTable")
    public void addMilestoneToTable() {
        expectedMilestone = new Milestone();
        expectedMilestone.setName("New Milestone 1");
        expectedMilestone.setDescription("Description");
        expectedMilestone.setCompleted(false);
        milestoneTable.addMilestone(expectedMilestone);
    }

    @Test (dependsOnMethods = "addMilestoneToTable")
    public void addProject() {
        ProjectAdapter projectAdapter = new ProjectAdapter();

        Project expectedProject = new Project();
        expectedProject.setName("AV_project_100500");
        expectedProject.setAnnouncement("AV_description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        Project actualProject = projectAdapter.add(expectedProject);
        projectId = actualProject.getId();
        Assert.assertEquals(expectedProject, actualProject);
    }
    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        expectedMilestone = milestoneTable.getMilestoneById(1);

        Milestone actualMilestone = milestoneAdapter.addMilestone(expectedMilestone, projectId);

        milestoneId = actualMilestone.getId();
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        Milestone actualMilestone = milestoneAdapter.getMilestone(milestoneId);
        //Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        expectedMilestone.setName("Updated name");
        expectedMilestone.setDescription("Updated description");
        expectedMilestone.setCompleted(true);

        milestoneTable.updateMilestone(expectedMilestone, 1);
        Milestone actualMilestone = milestoneTable.getMilestoneById(1);
        milestoneAdapter.updateMilestone(milestoneId, actualMilestone);
        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        milestoneAdapter.deleteMilestone(milestoneId);
        milestoneAdapter.getDeletedMilestone(milestoneId);
    }
}
