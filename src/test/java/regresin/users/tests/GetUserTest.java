package regresin.users.tests;

import org.junit.jupiter.api.Test;

import regresin.general.RegresinAPIBase;
import regresin.users.payload.CreateUserPayload;
import regresin.users.questions.GetUserQuestions;
import regresin.users.requests.GetUsersRequest;


public class GetUserTest extends RegresinAPIBase{
    
    @Test
    public void listUser(){

        //Datos para la creación del Api

        String path ="";//Path
        String param ="page"; // Parametro
        Integer paramValue =2; //Complemento del parametro

        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification
                                                                    ,path
                                                                    ,String.valueOf(paramValue)
                                                                    ,param)
                                                                    , 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification
                                                                  ,path
                                                                  , String.valueOf(paramValue)
                                                                  ,param)
                                                                  , paramValue
                                                                  ,param);
        GetUserQuestions.validateJsonSchema(GetUsersRequest.getUsers(requestSpecification
                                                                    ,path
                                                                    , String.valueOf(paramValue)
                                                                    ,param)
                                                                    ,path
                                                                    ,param
                                                                    ,paramValue);

    }

    @Test
    public void userId(){

        //Datos para la creación del Api

        String path ="12";//Path
        String param =""; // Parametro
        Integer paramValue =null;//Complemento del parametro
        Integer id=12;//Id del usuario

        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification
                                                                    ,String.valueOf(path)
                                                                    ,param
                                                                    ,param)
                                                                    , 200);
        GetUserQuestions.validateResponse(GetUsersRequest.getUsers(requestSpecification
                                                                    ,String.valueOf(path)
                                                                    ,param,param)
                                                                    , id
                                                                    ,"data.id");
        GetUserQuestions.validateJsonSchema(GetUsersRequest.getUsers(requestSpecification, String.valueOf(path)
                                                                    ,param
                                                                    ,param)
                                                                    ,path
                                                                    ,param
                                                                    ,paramValue);
    }


    @Test
    public void userIdNotExist(){


        //Datos para la creación del Api
        
        String path ="30";//Path
        String param =""; // Parametro
        Integer id=30;//Id del usuario

      
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification
                                                                    ,String.valueOf(path)
                                                                    ,param
                                                                    ,param)
                                                                    , 404);
        GetUserQuestions.validateJsonSchema(GetUsersRequest.getUsers(requestSpecification
                                                                    , String.valueOf(path)
                                                                    ,param
                                                                    ,param)
                                                                    ,"error"
                                                                    ,param
                                                                    ,id);

    }

 
    @Test
    public void createUser(){

        String name="Adriana Mora"; //Nombre Usuario
        String job= "Desarrollador QA";//Trabajo Usuario

        String userPayload = CreateUserPayload.userPayload(name,job); //Creación del user Payload
        
        GetUserQuestions.validateStatusCode(GetUsersRequest.postUsers(requestSpecification
                                                                        ,userPayload)
                                                                        , 201);
        GetUserQuestions.validateResponsePost(GetUsersRequest.postUsers(requestSpecification
                                                                        ,userPayload)
                                                                        , name
                                                                        , "name");
        GetUserQuestions.validateResponsePost(GetUsersRequest.postUsers(requestSpecification
                                                                        ,userPayload)
                                                                        , job
                                                                        , "job");
        GetUserQuestions.validateJsonSchema(GetUsersRequest.postUsers(requestSpecification
                                                                      ,userPayload)
                                                                      ,"Post"
                                                                      ,"Createuser"
                                                                      ,null);

    }



    @Test
    public void delayResponse(){

        String path ="";
        String param ="delay";
        Integer paramValue =3;

        
        GetUserQuestions.validateStatusCode(GetUsersRequest.getUsers(requestSpecification
                                                                    ,path
                                                                    ,String.valueOf(paramValue)
                                                                    ,param)
                                                                    , 200);
        GetUserQuestions.validateJsonSchema(GetUsersRequest.getUsers(requestSpecification
                                                                    ,path
                                                                    ,String.valueOf(paramValue)
                                                                    ,param)
                                                                    ,path
                                                                    ,param
                                                                    ,paramValue);
        

    }
}


