package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.Pet;
import utils.Utils;

@lombok.Data
public class PetUpdateScheme {

    Utils utils = new Utils();

    Pet pet = new Pet("89430780", "1", "cat", utils.updateNamePet(), "1", utils.UpdateTagsName(), utils.updateStatus());

    private String jsonString = "{ " +
        "id : " + pet.getIdOfTheCreatedPet() + "," +
        "category : {" +
        "id : " + pet.getIdCategory() + "," +
        "name : " + pet.getNameCategory() +
    "}," +
        "name : " + pet.getNameOfTheCreatedPet() + "," +
            "photoUrls : [" +
        "string" +
  "]," +
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
