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

    @Description("Метод GET узнать статус питомца")
    public void petGetStatus(String status) {
        given()
                .spec(requestSpec)
                .when()
                .get(pagePet.petGetStatus(status))
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("[0].status", equalTo("available"))
                .body(matchesJsonSchemaInClasspath("schemaPet.json"));
    }

//    @Description("Метод POST обновляет данные питомца в магазине")
//    public void updatesPetDataInStore(
//            String IdOfTheCreatedPet,
//            String IdCategory,
//            String NameCategory,
//            String NameOfTheCreatedPet,
//            String IdTags,
//            String NameTags,
//            String StatusTags) {
//
//        given()
//                .spec(requestSpec)
//                .body(gson.toJson(petCreationScheme.schema(
//                        IdOfTheCreatedPet,
//                        IdCategory,
//                        NameCategory,
//                        NameOfTheCreatedPet,
//                        IdTags,
//                        NameTags,
//                        StatusTags)))
//                .when()
//                .post(pagePet.petGetPage(IdOfTheCreatedPet))
//                .then()
//                .assertThat()
//                .statusCode(200);
//                .header("Content-Type", "application/json")
//                .contentType(ContentType.JSON)
//                .time(lessThan(5000L));
//                .body("id", equalTo(89430780))
//                .body("type", equalTo("unknown"))
//                .body("message", equalTo(89430780));
//                .body(matchesJsonSchemaInClasspath("schemaPet.json"));
//    }

    @Description("Метод PUT не должен изменить id питомца ")
    public void mustNotChangePetId(
            String IdOfTheCreatedPet,
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
                .statusCode(500)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("something bad happened"));
    }

    @Description("Метод GET не должен находить питомца по некорректному статусу")
    public void mustNotFindPetByIncorrectStatus(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .get(pagePet.petGetPage(IdOfTheCreatedPet))
                .then()
                .assertThat()
                .statusCode(404)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("java.lang.NumberFormatException: For input string: \"as\""));
    }

    @Description("Метод POST не должен создать питомца")
    public void notCreatePet(
            String IdOfTheCreatedPet,
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
                .post(pagePet.petCreationPage())
                .then()
                .assertThat()
                .statusCode(500)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("something bad happened"));
    }

    @Description("Метод GET не должен находить не созданного питомца")
    public void mustNotFindAnUnCreatedPet(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .get(pagePet.petGetPage(IdOfTheCreatedPet))
                .then()
                .assertThat()
//                .statusCode(1)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found"));
    }
}
