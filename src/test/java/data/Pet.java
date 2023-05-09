package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String idOfTheCreatedPet;
    private String idCategory;
    private String nameCategory;
    private String nameOfTheCreatedPet;
    private String idTags;
    private String nameTags;
    private String statusTags;
}
