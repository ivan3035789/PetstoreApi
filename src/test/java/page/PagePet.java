package page;

import jdk.jfr.Description;

public class PagePet {

    public String getBaseUri() {
        return "https://petstore.swagger.io/v2";
    }

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
}
