package page;

import data.User;
import jdk.jfr.Description;
import lombok.Data;

@Data
public class PageUser {
    User user = new User(
            "894307801",
            "Genka",
            "Genadiy",
            "Ivanov",
            "Genadiy@rambler.ru",
            "0000",
            "83332222222",
            "1");

    private String baseUri = "https://petstore.swagger.io/v2";

    @Description("создание пользователя")
    public String creationUser() {
        return "/user";
    }
//    private String creationUser = "/user";

    @Description("удаление пользователя")
    public String removalUser(String Username) {
        return "/user/" + Username;
    }
//    private String removalUser = "/user/" + user.getUsername();

    @Description("просмотр пользователя")
    public String userGetPage(String Username) {
        return "/user/" + Username;
    }
//    private String userGetPage = "/user/" + user.getUsername();
    @Description("регистрирует пользователя в системе")
    public String logsUserIntoSystem(String Username, String Password) {
        return "/user/login?username=" + Username + "&password=" + Password;
    }
//    private String logsUserIntoSystem = "/user/login?username=" + user.getUsername() + "&password=" + user.getPassword();

    @Description("выход пользователя из системы")
    public String userLogoutFromSystem(String Username) {
        return "/user/logout?username=" + Username;
    }
//    private String userLogoutFromSystem = "/user/logout?username=" + user.getUsername();
}
