package apiservice.responsemodel;

import lombok.Data;

@Data
public class UsersUpdateResponse {

    private String name;
    private String job;
    private String updatedAt;
}
