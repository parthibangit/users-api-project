package apiservice.responsemodel;

import lombok.Data;

@Data
public class UsersCreateResponse {

    private String name;
    private String job;
    private String id;
    private String createdAt;
}
