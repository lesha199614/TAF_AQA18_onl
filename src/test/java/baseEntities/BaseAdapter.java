package baseEntities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseAdapter {
    protected Gson gson;

    public BaseAdapter() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();
    }
}
