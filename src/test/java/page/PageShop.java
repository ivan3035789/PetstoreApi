package page;

import data.Pet;
import lombok.Data;

@Data
public class PageShop {
    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

    private String baseUri = "https://petstore.swagger.io/v2";
    private String petAddStore = "/store/order"; // добавление питомца в заказ
    private String petRemovalStore = "/store/order/" + pet.getIdOfTheCreatedPet(); //удаление питомца из заказа
    private String petGetStore = "/store/order/" + pet.getIdOfTheCreatedPet(); // просмотр питомца в магазине
}
