package regresin.users.tests;

import org.junit.jupiter.api.Test;

import regresin.general.RegresinAPIBase;
import regresin.users.questions.GetUserQuestions;
import regresin.users.requests.GetUsersRequest;


public class GetUserTest extends RegresinAPIBase{
    
    @Test
    public void createUser(){

        int expectedPage =2;
        String page ="page";
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification), 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification), expectedPage,page);

    }

    
}


