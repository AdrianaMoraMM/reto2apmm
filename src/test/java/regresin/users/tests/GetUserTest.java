package regresin.users.tests;

import org.junit.jupiter.api.Test;

import regresin.general.RegresinAPIBase;
import regresin.users.payload.CreateUserPayload;
import regresin.users.questions.GetUserQuestions;
import regresin.users.requests.GetUsersRequest;


public class GetUserTest extends RegresinAPIBase{
    
    @Test
    public void listUser(){

        int expectedPage =2;
        String page ="page";
        String complement ="";

        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedPage)), 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedPage)), expectedPage,page);

    }

    @Test
    public void userId(){

        int expectedId =12;
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),""), 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),""), 12,"data.id");

    }


    @Test
    public void userIdNotExist(){

        int expectedId =30;
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),""), 404);

    }

 
    @Test
    public void createUser(){

        String userPayload = CreateUserPayload.userPayload("Adriana","Desarrollador QA");
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.postUsers(requestSpecification,userPayload), 201);

    }



    
}


