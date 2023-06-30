package apiservice.responsemodel;

import lombok.Data;

@Data
public class UsersPatchResponse {

    private String name;
    private String job;
    private String updatedAt;
}
