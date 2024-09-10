package regresin.users.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetUsersRequest {

     public static Response getUsers(RequestSpecification requestSpecification, String complement,String paramPage,String param){

        requestSpecification.param(param,paramPage);
        return requestSpecification.get("/api/users/"+ complement);
    
}

     public static Response postUsers(RequestSpecification requestSpecification,String userPayload){

       
        return requestSpecification.body(userPayload).post("/api/users");
    
}



}