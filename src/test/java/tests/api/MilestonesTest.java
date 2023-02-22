package tests.api;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiGSONTest;
import models.Milestone;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MilestonesTest extends BaseApiGSONTest {

    int projectId;
    int milestoneId;
    Milestone expectedMilestone;
    ProjectAdapter projectAdapter = new ProjectAdapter();
    MilestoneAdapter milestoneAdapter = new MilestoneAdapter();

    @Test
    public void addProject() {

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
        expectedMilestone = new Milestone();
        expectedMilestone.setName("New Milestone 1");
        expectedMilestone.setDescription("Description");
        expectedMilestone.setCompleted(false);

        Milestone actualMilestone = milestoneAdapter.addMilestone(expectedMilestone, projectId);

        milestoneId = actualMilestone.getId();
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        Milestone actualMilestone = milestoneAdapter.getMilestone(milestoneId);
        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        expectedMilestone.setName("Updated name");
        expectedMilestone.setDescription("Updated description");
        expectedMilestone.setCompleted(true);

        Milestone actualMilestone = milestoneAdapter.updateMilestone(milestoneId, expectedMilestone);
        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.deleteMilestone(milestoneId);
        milestoneAdapter.getDeletedMilestone(milestoneId);
    }
}
