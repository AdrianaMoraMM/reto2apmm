package regresin.users.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;

public class GetUserQuestions {

    public static void validateStatusCode(Response response, Integer statusCodeExpected){
        assertEquals(
            statusCodeExpected,
            response.statusCode(),
            "Validacion del Status Code"
        );
    }

    public static void validateResponse(Response response, int number,String page){

        assertEquals(number,response.jsonPath().getInt(page),"Expected page  '" + number + "' not found in response." );
    
    }

    public static void validateResponsePost(Response response, String nameresponse,String name){

        assertEquals(nameresponse,response.jsonPath().getString(name),"Expected name '" + nameresponse + "' not found in response." );
    
    }
    
}
