package apiservice.requestmodel;

import lombok.Data;

@Data
public class UsersCreateRequest {

    private String name;
    private String job;
}
