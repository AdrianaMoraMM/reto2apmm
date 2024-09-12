package regresin.general;

import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import regresin.utils.IConfigBase;

public class RegresinAPIBase implements IConfigBase{

    protected RequestSpecification requestSpecification;

    @BeforeEach

    public void configure(){

        RestAssured.baseURI = "https://reqres.in";

        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
    }
    
}
