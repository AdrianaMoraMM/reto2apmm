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

        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedPage),page), 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedPage),page), expectedPage,page);

    }

    @Test
    public void userId(){

        int expectedId =12;
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),"",""), 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),"",""), 12,"data.id");

    }


    @Test
    public void userIdNotExist(){

        int expectedId =30;
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,String.valueOf(expectedId),"",""), 404);

    }

 
    @Test
    public void createUser(){

        String name="Adriana Mora"; 
        String job= "Desarrollador QA";

        String userPayload = CreateUserPayload.userPayload(name,job);
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.postUsers(requestSpecification,userPayload), 201);
        GetUserQuestions.validateResponsePost(GetUsersRequest.postUsers(requestSpecification,userPayload), name, "name");
        GetUserQuestions.validateResponsePost(GetUsersRequest.postUsers(requestSpecification,userPayload), job, "job");

    }



    @Test
    public void delayResponse(){

        int expectedDelay =3;
        String delay ="delay";
        String complement ="";

        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedDelay),delay), 200);
        //GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification,complement, String.valueOf(expectedPage)), expectedPage,page);

    }
}


