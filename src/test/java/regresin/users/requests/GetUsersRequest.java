package regresin.users.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsersRequest {

     public static Response getUsers(RequestSpecification requestSpecification  ){
        return requestSpecification.get("/api/users?page=2");
    
}
}