package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.User;
import lombok.Data;
import utils.Utils;

@Data
public class UserUpdateScheme {
    Utils utils = new Utils();
    User user = new User("894307801", "Genka", "Genadiy", "Ivanov", "Genadiy@rambler.ru", utils.updatePassword(), utils.updatePhone(), "1");

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