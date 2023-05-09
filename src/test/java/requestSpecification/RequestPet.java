package requestSpecification;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import page.PagePet;
import scheme.PetCreationScheme;
import scheme.PetUpdateScheme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestPet {
    Gson gson = new Gson();
    PagePet pagePet = new PagePet();
    PetCreationScheme petCreationScheme = new PetCreationScheme();
    PetUpdateScheme petUpdateScheme = new PetUpdateScheme();

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(pagePet.getBaseUri())
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Description("Метод POST создать питомца")
    public void createPet() {
        given()
                .spec(requestSpec)
                .body(gson.toJson(petCreationScheme.getJsonObject()))
                .when()
                .post(pagePet.getPetCreationPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("id", equalTo(89430780))
                .body("name", equalTo("crty"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("cat"));
    }

    @Description("Метод DELETE удалить созданного питомца")
    public void deletePet() {
        given()
                .spec(requestSpec)
                .when()
                .delete(pagePet.getPetRemovalPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("89430780"));
    }

    @Description("Метод GET найти созданного питомца")
    public void getPet() {
        given()
                .spec(requestSpec)
                .when()
                .get(pagePet.getPetGetPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("id", equalTo(89430780))
                .body("name", equalTo("crty"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("cat"));
    }

    @Description("Метод PUT изменить данные питомца")
    public void UpdatePet() {
        given()
                .spec(requestSpec)
                .body(gson.toJson(petUpdateScheme.getJsonObject()))
                .when()
                .put(pagePet.getPetCreationPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("id", equalTo(89430780))
                .body("name", equalTo("rufus"))
                .body("status", equalTo("sold"))
                .body("tags[0].name", equalTo("rufus"));

    }
}
