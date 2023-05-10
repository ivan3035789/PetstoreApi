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
}
