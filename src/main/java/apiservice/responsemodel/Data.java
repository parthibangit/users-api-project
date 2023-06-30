package apiservice.responsemodel;

import com.google.gson.annotations.SerializedName;

@lombok.Data
public class Data {

    private int id;
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String avatar;
}
