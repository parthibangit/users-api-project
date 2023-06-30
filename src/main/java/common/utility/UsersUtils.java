package common.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class UsersUtils {

    private UsersUtils () {

    }

    /**
     * This method used to generate the random name
     *
     */
    public static String generateUserName() {
        String randomUser = RandomStringUtils.randomAlphabetic(5);
        return "User " + randomUser;
    }

    /**
     * This method used to generate the random job
     *
     */
    public static String generateJob() {
        String randomJob = RandomStringUtils.randomAlphabetic(5);
        return "Job " + randomJob;
    }
}
