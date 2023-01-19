package models;

import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    private int type;
    private boolean shownAnnouncement;
    private boolean deleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isShownAnnouncement() {
        return shownAnnouncement;
    }

    public void setShownAnnouncement(boolean shownAnnouncement) {
        this.shownAnnouncement = shownAnnouncement;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", type=" + type +
                ", shownAnnouncement=" + shownAnnouncement +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return type == project.type && shownAnnouncement == project.shownAnnouncement && Objects.equals(name, project.name) && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, type, shownAnnouncement);
    }
}
