package requestSpecification;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import page.PagePet;
import scheme.PetCreationScheme;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RequestPet {
    Gson gson = new Gson();
    PagePet pagePet = new PagePet();
    PetCreationScheme petCreationScheme = new PetCreationScheme();

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(pagePet.getBaseUri())
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Description("Метод POST создать питомца")
    public void createPet(String IdOfTheCreatedPet,
                          String IdCategory,
                          String NameCategory,
                          String NameOfTheCreatedPet,
                          String IdTags,
                          String NameTags,
                          String StatusTags) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(petCreationScheme.schema(IdOfTheCreatedPet,
                        IdCategory,
                        NameCategory,
                        NameOfTheCreatedPet,
                        IdTags,
                        NameTags,
                        StatusTags)))
                .when()
                .post(pagePet.petCreationPage())
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("id", equalTo(89430780))
                .body("name", equalTo("crty"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("cat"));
    }

    @Description("Метод DELETE удалить созданного питомца")
    public void deletePet(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .delete(pagePet.petRemovalPage(IdOfTheCreatedPet))
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("89430780"));
    }

    @Description("Метод GET найти созданного питомца")
    public void getPet(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .get(pagePet.petGetPage(IdOfTheCreatedPet))
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("id", equalTo(89430780))
                .body("name", equalTo("crty"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("cat"))
                .body(matchesJsonSchemaInClasspath("schemaPet.json"));
    }

    @Description("Метод PUT изменить данные питомца")
    public void UpdatePet(String IdOfTheCreatedPet,
                          String IdCategory,
                          String NameCategory,
                          String NameOfTheCreatedPet,
                          String IdTags,
                          String NameTags,
                          String StatusTags) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(petCreationScheme.schema(
                        IdOfTheCreatedPet,
                        IdCategory,
                        NameCategory,
                        NameOfTheCreatedPet,
                        IdTags,
                        NameTags,
                        StatusTags)))
                .when()
                .put(pagePet.petCreationPage())
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("id", equalTo(89430780))
                .body("name", equalTo("rufus"))
                .body("status", equalTo("sold"))
                .body("tags[0].name", equalTo("rufus"))
                .body(matchesJsonSchemaInClasspath("schemaPet.json"));
    }
}
