package regresin.users.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class GetUserQuestions {

    public static void validateStatusCode(Response response, Integer statusCodeExpected){
        assertEquals(
            statusCodeExpected,
            response.statusCode(),
            "Validacion del Status Code"
        );
    }

    public static void validateResponse(Response response, int path,String param){

        assertEquals(path,response.jsonPath().getInt(param),"Expected page  '" + path + "' not found in response." );
    
    }

    public static void validateResponsePost(Response response, String propertieresponse,String propertie){

        assertEquals(propertieresponse,response.jsonPath().getString(propertie),"Expected name '" + propertieresponse + "' not found in response." );
    
    }
    

     public static void validateJsonSchema(Response response,String path,String param, Integer expectedPropertie){

        String schemaPath = "regresin/RegresinJsonSchema" + path + param +
        (expectedPropertie != null ? expectedPropertie : "") + ".json";

        System.out.println(schemaPath);
        JsonSchemaValidator jsv =JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath);
        assertTrue("Validación del Json Schema para  Questions",jsv.matches(response.asString()));

    }
}
