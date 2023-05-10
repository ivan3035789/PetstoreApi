package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

@Data
public class SchemeAddingPetToStore {
//    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");
//    data.Data data = new data.Data();

    public JsonObject schema(
            String IdOfTheCreatedPet,
            String IdCategory,
            String Quantity,
            String ShipDate,
            String StatusTags,
            String bool) {
        String jsonString = "{ " +
                "id : " + IdOfTheCreatedPet + "," +
                "petId : " + IdCategory + "," +
                "quantity : " + Quantity + "," +
                "shipDate : " + ShipDate + "," +
                "status : " + StatusTags + "," +
                "complete : " + bool +
                "}";
        return  (JsonObject) JsonParser.parseString(jsonString);
    }
//    private String jsonString = "{ " +
//            "id : " + pet.getIdOfTheCreatedPet() + "," +
//            "petId : " + pet.getIdCategory() + "," +
//            "quantity : " + data.getQuantity() + "," +
//            "shipDate : " + data.getShipDate() + "," +
//            "status : " + pet.getStatusTags() + "," +
//            "complete : " + "true" +
//            "}";
//
//    private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
}
