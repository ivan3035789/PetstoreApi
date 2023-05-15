package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

@Data
public class UserCreationScheme {

    public JsonObject schema(
            String IdUser,
            String Username,
            String FirstName,
            String LastName,
            String Email,
            String Password,
            String Phone,
            String UserStatus) {
        String jsonString = "{" +
                "id :" + Integer.parseInt(IdUser) + "," +
                "username : " + Username + "," +
                "firstName : " + FirstName + "," +
                "lastName : " + LastName + "," +
                "email : " + Email + "," +
                "password : " + Password + "," +
                "phone : " + Phone + "," +
                "userStatus :" + Integer.parseInt(UserStatus) +
                "}";
        return  (JsonObject) JsonParser.parseString(jsonString);
    }
}
