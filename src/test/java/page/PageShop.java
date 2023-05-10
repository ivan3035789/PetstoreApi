package page;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class PageShop {
//    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

    private String baseUri = "https://petstore.swagger.io/v2";

    @Description("добавление питомца в заказ")
    public String petAddStore() {
        return "/store/order";
    }
//    private String petAddStore = "/store/order";

    @Description("удаление питомца из заказа")
    public String petRemovalStore(String IdOfTheCreatedPet) {
        return "/store/order/" + IdOfTheCreatedPet;
    }
//    private String petRemovalStore = "/store/order/" + pet.getIdOfTheCreatedPet();

    @Description("просмотр питомца в магазине")
    public String petGetStore(String getIdOfTheCreatedPet) {
        return "/store/order/" + getIdOfTheCreatedPet;
    }
//    private String petGetStore = "/store/order/" + pet.getIdOfTheCreatedPet();
}
