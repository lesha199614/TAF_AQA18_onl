package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseAdapter {
    protected Gson gson;

    public void setupApi() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();
    }
}
