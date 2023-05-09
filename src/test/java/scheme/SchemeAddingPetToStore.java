package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.Pet;
import lombok.Data;

@Data
public class SchemeAddingPetToStore {
    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");
    data.Data data = new data.Data();
    private String jsonString = "{ " +
            "id : " + pet.getIdOfTheCreatedPet() + "," +
            "petId : " + pet.getIdCategory() + "," +
            "quantity : " + data.getQuantity() + "," +
            "shipDate : " + data.getShipDate() + "," +
            "status : " + pet.getStatusTags() + "," +
            "complete : " + "true" +
            "}";

    private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
}
