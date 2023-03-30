package resources;

public enum APIResources {

    CreateTestAPI("/rest/api/2/issue"),
    GetTestAPI("/rest/api/2/issue/{issueId}"),
    EditTestAPI("/rest/api/3/issue/{issueId}"),
    DeleteTestAPI("/rest/api/2/issue/{issueId}"),
    CreateTestStepAPI("/rest/raven/2.0/api/test/{issueId}/steps"),
    GetTestStepAPI("/rest/raven/2.0/api/test/{issueId}/steps/{stepId}"),
    EditTestStepAPI("/rest/raven/2.0/api/test/{issueId}/steps/{stepId}"),
    DeleteTestStepAPI("/rest/raven/2.0/api/test/{issueId}/steps/{stepId}"),
    TestSetAPI("/rest/raven/1.0/api/testset/{testSetKey}/test");


    private String resource;
    APIResources(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
