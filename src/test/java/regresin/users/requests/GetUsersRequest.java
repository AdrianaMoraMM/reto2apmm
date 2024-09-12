package regresin.users.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetUsersRequest {

     public static Response getUsers(RequestSpecification requestSpecification, String path,String paramValue,String param){

        requestSpecification.param(param,paramValue);
        return requestSpecification.get("/api/users/"+ path);
    
}

     public static Response postUsers(RequestSpecification requestSpecification,String userPayload){

       
        return requestSpecification.body(userPayload).post("/api/users");
    
}



}