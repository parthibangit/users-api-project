package apiservice.requestfactory;

import apiservice.requestmodel.UsersCreateRequest;
import apiservice.requestmodel.UsersUpdateRequest;
import common.utility.UsersUtils;

public class UserFactory {

    private UserFactory() {

    }

    /**
     * This method used to set the values in request body for create user
     *
     */
    public static UsersCreateRequest createUserRequest() {
        UsersCreateRequest createRequest = new UsersCreateRequest();
        String randomUserName = UsersUtils.generateUserName();
        String randomJob = UsersUtils.generateJob();
        createRequest.setName(randomUserName);
        createRequest.setJob(randomJob);
        return createRequest;
    }


    /**
     * This method used to set the values in request body for update user
     *
     */
    public static UsersUpdateRequest updateUserRequest() {
        UsersUpdateRequest updateRequest = new UsersUpdateRequest();
        String randomUserName = UsersUtils.generateUserName();
        String randomJob = UsersUtils.generateJob();
        updateRequest.setName(randomUserName);
        updateRequest.setJob(randomJob);
        return updateRequest;
    }


}
