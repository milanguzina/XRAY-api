package pojo;

import com.google.gson.annotations.SerializedName;

public class StepFields {

    private String action;
    private String data;

    @SerializedName("expected result") public String expected_result;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExpected_result() {
        return expected_result;
    }

    public void setExpected_result(String expected_result) {
        this.expected_result = expected_result;
    }
}
