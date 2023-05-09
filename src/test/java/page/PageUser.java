package page;

import data.User;
import lombok.Data;

@Data
public class PageUser {
    User user = new User("894307801", "Genka", "Genadiy", "Ivanov", "Genadiy@rambler.ru", "0000", "83332222222", "1");

    private String baseUri = "https://petstore.swagger.io/v2";
    private String creationUser = "/user"; // создание пользователя
    private String removalUser = "/user/" + user.getUsername(); //удаление пользователя
    private String userGetPage = "/user/" + user.getUsername();
}
