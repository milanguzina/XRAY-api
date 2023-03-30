import java.io.IOException;

public class TestOptimization {

    XRAYFunctionalities validateTest = new XRAYFunctionalities();

    public void createTest () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }


    public void getTest () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.getTest("GetTestAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }

    public void deleteTest () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }

    public void addTestStep () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.addTestStep("CreateTestStepAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }


    public void editTestStep () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.addTestStep("CreateTestStepAPI");
        validateTest.editTestStep("EditTestStepAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }

    public void deleteTestStep () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.addTestStep("CreateTestStepAPI");
        validateTest.deleteTestStep("DeleteTestStepAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }

    public void negativeGetTest () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.deleteTest("DeleteTestAPI");
        validateTest.getNonExistingTestRequest("GetTestAPI");
    }

    public void negativeGetTestStep () throws IOException {
        validateTest.getSession();
        validateTest.createTest("CreateTestAPI");
        validateTest.addTestStep("CreateTestStepAPI");
        validateTest.deleteTestStep("DeleteTestStepAPI");
        validateTest.getNonExistingTestStepRequest("GetTestStepAPI");
        validateTest.deleteTest("DeleteTestAPI");
    }

    public void AddTestsToTestSet () throws IOException {
        validateTest.getSession();
        validateTest.AddTestsToTestSet("TestSetAPI");
        validateTest.removeTestFromTestSet("TestSetAPI");
    }

    public void getTestSet () throws IOException {
        validateTest.getSession();
        validateTest.getTestSet("TestSetAPI");
    }

    public void removeTestFromTestSet () throws IOException {
        validateTest.getSession();
        validateTest.AddTestsToTestSet("TestSetAPI");
        validateTest.removeTestFromTestSet("TestSetAPI");
    }

}
