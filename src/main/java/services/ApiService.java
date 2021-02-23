package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

  public RequestSpecification setup() {

    return RestAssured
        .given().contentType(ContentType.JSON).log().all();
  }
}
