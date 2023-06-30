package stepdefinitions;

import apiservice.handler.UserHandler;
import apiservice.requestfactory.UserFactory;
import apiservice.requestmodel.UsersCreateRequest;
import apiservice.responsemodel.UsersCreateResponse;
import apiservice.responsemodel.UsersGetSingleUserResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UsersStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(UsersStepDefinitions.class);

    UsersCreateRequest createRequest;
    Response postResponse;
    Response readResponse;
    UsersCreateResponse createResponse;
    UsersGetSingleUserResponse singleUserResponse;

    @Given("^Set up the create user request body$")
    public void Set_up_the_create_user_request_body() {

        createRequest = UserFactory.createUserRequest();
        logger.info("User to create: {}", createRequest);

    }

    @When("Create a new user")
    public void create_a_new_user() {

        postResponse = UserHandler.postUser(createRequest);
        postResponse.then().log().all();

    }

    @Then("Verify the create response status code {int}")
    public void verify_the_create_response_status_code(Integer statusCode) {

        postResponse.then().statusCode(statusCode);

    }

    @Then("Verify the user details")
    public void verify_the_user_details() {

        String expectedUserName = createRequest.getName();
        String expectedJob = createRequest.getJob();
        String actualUserName = createResponse.getName();
        String actualJob = createResponse.getJob();
        Assert.assertEquals(actualUserName, expectedUserName, "User name not matched");
        Assert.assertEquals(actualJob, expectedJob, "Job not matched");
    }

    @And("Get the create user response details")
    public void get_the_create_user_response_details() {

        createResponse = postResponse.getBody().as(UsersCreateResponse.class, ObjectMapperType.GSON);

    }

    @When("Get a single user based on created user detail")
    public void get_a_single_user_based_on_created_user_detail() {

        String expectId = createResponse.getId();
        readResponse = UserHandler.readSingleUser(expectId);
        readResponse.then().log().all();
    }

    @When("Get a following single user {string}")
    public void get_a_following_single_user(String userId) {
        readResponse = UserHandler.readSingleUser(userId);
        readResponse.then().log().all();
    }

    @And("Get the single user response details")
    public void get_the_single_user_response_details() {

        singleUserResponse = readResponse.getBody().as(UsersGetSingleUserResponse.class, ObjectMapperType.GSON);
    }

    @Then("Verify the get single user response status code {int}")
    public void verify_the_get_single_user_response_status_code(Integer statusCode) {

        readResponse.then().statusCode(statusCode);
    }

    @When("Verify the single user details")
    public void Verify_the_single_user_details() {

        String expectId = createResponse.getId();
        int actualId = singleUserResponse.getData().getId();
        Assert.assertEquals(actualId, Integer.valueOf(expectId), "User Id not matched");
    }

    @Then("Verify the single user details {string}")
    public void verify_the_single_user_details(String userId) {

        int actualId = singleUserResponse.getData().getId();
        Assert.assertEquals(actualId, Integer.valueOf(userId), "User Id not matched");
    }








}
