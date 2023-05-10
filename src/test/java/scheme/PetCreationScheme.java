package scheme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

@Data
public class PetCreationScheme {
//    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

    public JsonObject schema(
            String IdOfTheCreatedPet,
            String IdCategory,
            String NameCategory,
            String NameOfTheCreatedPet,
            String IdTags,
            String NameTags,
            String StatusTags) {
         String jsonString = "{ " +
                "id : " + IdOfTheCreatedPet + "," +
                "category : {" +
                "id : " + IdCategory + "," +
                "name : " + NameCategory +
                "}," +
                "name : " + NameOfTheCreatedPet + "," +
                "photoUrls : [string]," +
                "tags : [" +
                "{" +
                "id : " + IdTags + "," +
                "name : " + NameTags +
                "}" +
                "]," +
                "status : " + StatusTags +
                "}";
        return (JsonObject) JsonParser.parseString(jsonString);
    }

//    private String jsonString = "{ " +
//            "id : " + pet.getIdOfTheCreatedPet() + "," +
//            "category : {" +
//              "id : " + pet.getIdCategory() + "," +
//              "name : " + pet.getNameCategory() +
//            "}," +
//            "name : " + pet.getNameOfTheCreatedPet() + "," +
//            "photoUrls : [string]," +
//            "tags : [" +
//                "{" +
//                  "id : " + pet.getIdTags() + "," +
//                  "name : " + pet.getNameTags() +
//                "}" +
//            "]," +
//            "status : " + pet.getStatusTags() +
//            "}";
//
//    private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
}


