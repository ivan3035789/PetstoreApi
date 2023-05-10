package page;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class PageUser {

    private String baseUri = "https://petstore.swagger.io/v2";

    @Description("создание пользователя")
    public String creationUser() {
        return "/user";
    }

    @Description("удаление пользователя")
    public String removalUser(String Username) {
        return "/user/" + Username;
    }

    @Description("просмотр пользователя")
    public String userGetPage(String Username) {
        return "/user/" + Username;
    }

    @Description("регистрирует пользователя в системе")
    public String logsUserIntoSystem(String Username, String Password) {
        return "/user/login?username=" + Username + "&password=" + Password;
    }

    @Description("выход пользователя из системы")
    public String userLogoutFromSystem(String Username) {
        return "/user/logout?username=" + Username;
    }
}
