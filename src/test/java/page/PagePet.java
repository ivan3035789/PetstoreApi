package page;

import data.Pet;
import lombok.Data;

@Data
public class PagePet {
    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

    private String baseUri = "https://petstore.swagger.io/v2";
    private String petCreationPage = "/pet"; // создание питомца
    private String petRemovalPage = "/pet/" + pet.getIdOfTheCreatedPet(); //удаление питомца
    private String petGetPage = "/pet/" + pet.getIdOfTheCreatedPet();
}
