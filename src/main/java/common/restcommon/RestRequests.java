package common.restcommon;

import apiservice.requestmodel.UsersCreateRequest;
import apiservice.requestmodel.UsersUpdateRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestRequests {


   private String url;
   private RequestSpecBuilder requestSpecBuilder;
   private RequestSpecification requestSpecification;

   public RestRequests(String url) {
       this.requestSpecBuilder = new RequestSpecBuilder();
       this.url = url;
       init();
   }

   public void init() {
      requestSpecBuilder.setBaseUri(url);
      requestSpecBuilder.setContentType("application/json");
      requestSpecification = requestSpecBuilder.build();
   }

   public Response getRequest(String path) {
      RequestSpecification request = given().spec(requestSpecification);
      return request.when().get(path);
   }

   public Response postRequest(UsersCreateRequest requestBody, String path) {
      RequestSpecification request = given().spec(requestSpecification).body(requestBody, ObjectMapperType.GSON);
      return request.when().post(path);
   }

   public Response putRequest(UsersUpdateRequest requestBody, String path) {
      RequestSpecification request = given().spec(requestSpecification).body(requestBody, ObjectMapperType.GSON);
      return request.when().put(path);
   }

   public Response deleteRequest(String path) {
      RequestSpecification request = given().spec(requestSpecification);
      return request.when().delete(path);
   }

   public Response patchRequest(UsersUpdateRequest requestBody,  String path) {
      RequestSpecification request = given().spec(requestSpecification).body(requestBody, ObjectMapperType.GSON);
      return request.when().patch(path);
   }

}
