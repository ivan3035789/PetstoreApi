package page;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class PageShop {

    private String baseUri = "https://petstore.swagger.io/v2";

    @Description("добавление питомца в заказ")
    public String petAddStore() {
        return "/store/order";
    }

    @Description("удаление питомца из заказа")
    public String petRemovalStore(String IdOfTheCreatedPet) {
        return "/store/order/" + IdOfTheCreatedPet;
    }

    @Description("просмотр питомца в магазине")
    public String petGetStore(String getIdOfTheCreatedPet) {
        return "/store/order/" + getIdOfTheCreatedPet;
    }

    @Description("возвращает количество животных в запасе")
    public String mustFindOrderById() {
        return "/store/inventory";
    }
}
