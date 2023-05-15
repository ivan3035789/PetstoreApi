package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

@Data
public class SchemeAddingPetToStore {

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
}
