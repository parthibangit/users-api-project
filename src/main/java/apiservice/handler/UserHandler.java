package apiservice.handler;

import apiservice.requestmodel.UsersCreateRequest;
import apiservice.requestmodel.UsersUpdateRequest;
import common.configuration.ObjectRepositoryReader;
import common.restcommon.RestRequests;
import io.restassured.response.Response;

public class UserHandler {

    private static final String END_PATH = "/api/users";

    private UserHandler() {

    }

    /**
     * This method used to read the single user from server
     * @param id
     * @return Response
     */
    public static Response readSingleUser(String id) {
        String url = ObjectRepositoryReader.readObjectRepo("url");
        RestRequests requests = new RestRequests(url);
        String endPath = END_PATH+ "/" + id;
        return requests.getRequest(endPath);
    }

    /**
     * This method used to create new user
     * @param requestBody
     * @return Response
     */
    public static Response postUser(UsersCreateRequest requestBody) {
        String url = ObjectRepositoryReader.readObjectRepo("url");
        RestRequests requests = new RestRequests(url);
        return requests.postRequest(requestBody, END_PATH);
    }

    /**
     * This method used to update user
     * @param requestBody
     * @param userId
     * @return Response
     */
    public static Response updateUser(UsersUpdateRequest requestBody, String userId) {
        String url = ObjectRepositoryReader.readObjectRepo("url");
        RestRequests requests = new RestRequests(url);
        String endPath = END_PATH+ "/" +userId;
        return requests.putRequest(requestBody, endPath);
    }

    /**
     * This method used to patch user
     * @param requestBody
     * @param userId
     * @return Response
     */
    public static Response patchUser(UsersUpdateRequest requestBody, String userId) {
        String url = ObjectRepositoryReader.readObjectRepo("url");
        RestRequests requests = new RestRequests(url);
        String endPath = END_PATH+ "/" +userId;
        return requests.patchRequest(requestBody, endPath);
    }

    /**
     * This method used to delete user
     * @param userId
     * @return Response
     */
    public static Response deleteUser(String userId) {
        String url = ObjectRepositoryReader.readObjectRepo("url");
        RestRequests requests = new RestRequests(url);
        String endPath = END_PATH+ "/" +userId;
        return requests.deleteRequest(endPath);
    }

}
