package resources;

import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public CreateTest createTestPayload(String summary, String description, String index, String action, String testData, String expected_result){

        CreateTest  createTest = new CreateTest();
        Fields fields = new Fields();
        Project project = new Project();
        project.setKey("XRAY");
        fields.setProject(project);
        fields.setSummary(summary);
        fields.setDescription(description);
        Issuetype issuetype = new Issuetype();
        issuetype.setName("Test");
        fields.setIssuetype(issuetype);
        Customfield_10204 customfield_10204 = new Customfield_10204();
        Steps steps = new Steps();
        steps.setIndex(index);
        StepFields stepFields = new StepFields();
        stepFields.setAction(action);
        stepFields.setData(testData);
        stepFields.setExpected_result("nada");
        steps.setFields(stepFields);
        List<Steps> stepsList = new ArrayList<Steps>();
        stepsList.add(steps);
        customfield_10204.setSteps(stepsList);
        fields.setCustomfield_10204(customfield_10204);
        createTest.setFields(fields);
        return createTest;
    }

    public Add addTest(String test1, String test2){
        Add addTest = new Add();
        List<String> testList = new ArrayList<String>();
        testList.add(test1);
        testList.add(test2);
        addTest.setAdd(testList);
       return addTest;
    }
}
