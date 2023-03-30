import java.io.IOException;

public class XRayAPITests {

    TestOptimization TestOpt = new TestOptimization();

    @org.junit.Test
    public void createTest () throws IOException {
      TestOpt.createTest();
    }

    @org.junit.Test
    public void getTest () throws IOException {
       TestOpt.getTest();
    }

    @org.junit.Test
    public void deleteTest () throws IOException {
       TestOpt.deleteTest();
    }

    @org.junit.Test
    public void addTestStep () throws IOException {
       TestOpt.addTestStep();
    }

    @org.junit.Test
    public void editTestStep () throws IOException {
      TestOpt.editTestStep();
    }

    @org.junit.Test
    public void deleteTestStep () throws IOException {
       TestOpt.deleteTestStep();
    }

    @org.junit.Test
    public void negativeGetTest () throws IOException {
        TestOpt.negativeGetTest();
    }

    @org.junit.Test
    public void negativeGetTestStep () throws IOException {
       TestOpt.negativeGetTestStep();
    }

    @org.junit.Test
    public void AddTestsToTestSet () throws IOException {
      TestOpt.AddTestsToTestSet();
    }

    @org.junit.Test
    public void removeTestFromTestSet () throws IOException {
       TestOpt.removeTestFromTestSet();
    }
    @org.junit.Test
    public void getTestSet () throws IOException {
        TestOpt.getTestSet();
    }
}
