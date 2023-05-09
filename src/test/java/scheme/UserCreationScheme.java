package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.User;
import lombok.Data;

@Data
public class UserCreationScheme {
    User user = new User("894307801", "Genka", "Genadiy", "Ivanov", "Genadiy@rambler.ru", "0000", "83332222222", "1");

    private String jsonString = "{" +
            "id :" + user.getIdUser() + "," +
            "username : " + user.getUsername() + "," +
            "firstName : " + user.getFirstName() + "," +
            "lastName : " + user.getLastName() + "," +
            "email : " + user.getEmail() + "," +
            "password : " + user.getPassword() + "," +
            "phone : " + user.getPhone() + "," +
            "userStatus :" + user.getUserStatus() +
            "}";

    private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
}
