package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {

    public static RequestSpecification reqSpecBuilder;
    public static ResponseSpecification resSpecBuilder;


    public  RequestSpecification  requestSpecification() throws IOException {
        if (reqSpecBuilder==null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpecBuilder = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return reqSpecBuilder;
        }  return reqSpecBuilder;
    }

    public ResponseSpecification responseSpecification(){
        if (resSpecBuilder==null) {
            resSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        }return resSpecBuilder;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\PC\\Desktop\\Automation\\AutomationProjectsPractice\\XRAYAPIProject\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key){
        String resp  = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
