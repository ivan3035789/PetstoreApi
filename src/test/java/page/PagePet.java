package page;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class PagePet {

    private String baseUri = "https://petstore.swagger.io/v2";

    @Description("создание питомца")
    public String petCreationPage() {
        return "/pet";
    }

    @Description("удаление питомца")
    public String petRemovalPage(String IdOfTheCreatedPet) {
        return "/pet/" + IdOfTheCreatedPet;
    }

    @Description("просмотр питомца")
    public String petGetPage(String IdOfTheCreatedPet) {
        return "/pet/" + IdOfTheCreatedPet;
    }

    @Description("узнать статус питомца")
    public String petGetStatus(String status) {
        return "/pet/findByStatus?status=" + status;
    }

//    @Description("обновляет данные питомца в магазине")
//    public String updatesPetDataInStore(String IdOfTheCreatedPet, String name, String status) {
//        return "/pet/" + IdOfTheCreatedPet + "?name=" + name + "&status=" + status;
//    }
}
