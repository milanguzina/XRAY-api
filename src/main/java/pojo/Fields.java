package pojo;

public class Fields {

    private Project project;
    private String summary;
    private  String description;

    private Issuetype issuetype;
    private Customfield_10204 customfield_10204;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    public Customfield_10204 getCustomfield_10204() {
        return customfield_10204;
    }

    public void setCustomfield_10204(Customfield_10204 customfield_10204) {
        this.customfield_10204 = customfield_10204;
    }
}
