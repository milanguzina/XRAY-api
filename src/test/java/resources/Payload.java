package resources;

public class Payload {

    public static String AddTest(){
        return "{\r\n    \"fields\": {" +
                "\r\n       \"project\":" +
                "\r\n       {" +
                "\r\n          \"key\": \"XRAY\"" +
                "\r\n       }," +
                "\r\n       \"summary\": \"2nd Test Case\"," +
                "\r\n       \"description\": \"Validating user login\"," +
                "\r\n       \"issuetype\": {" +
                "\r\n          \"name\": \"Test\"" +
                "\r\n       }," +
                "\r\n      \"customfield_10204\":{" +
                "\r\n         \"steps\":[" +
                "\r\n            {" +
                "\r\n               \"index\":1," +
                "\r\n               \"fields\":{" +
                "\r\n                  \"action\":\"Step 1\"," +
                "\r\n                  \"data\":\"input Data 1\"," +
                "\r\n                  \"expected result\":\"Excepted result 1\"" +
                "\r\n               }" +
                "\r\n            }," +
                "\r\n            {" +
                "\r\n               \"index\":2," +
                "\r\n               \"fields\":{" +
                "\r\n                  \"action\":\"Step 2\"," +
                "\r\n                  \"data\":\"input Data 2\"," +
                "\r\n                  \"expected result\":\"Excepted result 2\"" +
                "\r\n               }" +
                "\r\n            }," +
                "\r\n            {" +
                "\r\n               \"index\":3," +
                "\r\n               \"fields\":{" +
                "\r\n                  \"action\":\"Step 3\"," +
                "\r\n                  \"data\":\"input Data 3\"," +
                "\r\n                  \"expected result\":\"Excepted result 3\"" +
                "\r\n               }" +
                "\r\n            }" +
                "\r\n         ]" +
                "\r\n      }" +
                "\r\n   }" +
                "\r\n   }";
    }

    public static String AddTestStep(){
        return "{\r\n  \"fields\": {" +
                "\r\n    \"Action\": \"New Added Step Action\"," +
                "\r\n    \"Data\":\"New Added Test Step Data\"," +
                "\r\n    \"Expected Result\":\"New Added Expected Result\"" +
                "\r\n  }" +
                "\r\n}";
    }

    public static String EditTestStep(){
        return "{\r\n  \"fields\": {" +
                "\r\n    \"Action\": \"EDITED Step Action\"," +
                "\r\n    \"Data\":\"EDITED Test Step Data\"," +
                "\r\n    \"Expected Result\":\"EDITED Expected Result\"" +
                "\r\n  }" +
                "\r\n}";
    }

    public static String addTestsToTestSet(){
        return "{\r\n    \"add\": [\r\n        \"XRAY-29\",\r\n        \"XRAY-3\"\r\n    ]\r\n}";
    }

    public static String removeTestsFromTestSet(){
        return "{\r\n    \"remove\": [\r\n        \"XRAY-29\",\r\n        \"XRAY-3\"\r\n    ]\r\n}";
    }



}
