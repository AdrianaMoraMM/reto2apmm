package regresin.users.payload;

public class CreateUserPayload {

    public static String userPayload( String name, String job){


        String json = "{"
        + "\"name\":\"" + name + "\","
        + "\"job\":\"" + job + "\""
        + "}";

        return json;
    }
    


}
