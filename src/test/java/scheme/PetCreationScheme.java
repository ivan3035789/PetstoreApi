package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.Pet;
import lombok.Data;

@Data
public class PetCreationScheme {
    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

    private String jsonString = "{ " +
            "id : " + pet.getIdOfTheCreatedPet() + "," +
            "category : {" +
              "id : " + pet.getIdCategory() + "," +
              "name : " + pet.getNameCategory() +
            "}," +
            "name : " + pet.getNameOfTheCreatedPet() + "," +
            "photoUrls : [string]," +
            "tags : [" +
                "{" +
                  "id : " + pet.getIdTags() + "," +
                  "name : " + pet.getNameTags() +
                "}" +
            "]," +
            "status : " + pet.getStatusTags() +
            "}";

    private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
}


