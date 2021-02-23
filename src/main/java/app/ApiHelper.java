package app;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import responses.ResponseSearchUser;
import services.ApiService;

public class ApiHelper {

  private final ApiService apiService = new ApiService();
  ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
  Gson gson = new Gson();

  public ResponseSearchUser searchUser(String text) {
    RestAssured.baseURI = config.urlSearchUserApi();
    String json = apiService.setup()
        .param("query", text)
        .when()
        .get().asString();
    return gson.fromJson(json, ResponseSearchUser.class);
  }

  public <T> void registerUser(T model) {
    RestAssured.baseURI = config.urlDoRegisterApi();
    apiService.setup()
        .body(model)
        .when()
        .post()
        .then().log().all();
  }
}
