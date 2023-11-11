package requestSpecification;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import page.PageShop;
import scheme.SchemeAddingPetToStore;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RequestShop {
    Gson gson = new Gson();
    PageShop pageShop = new PageShop();
    SchemeAddingPetToStore schemeAddingPetToStore = new SchemeAddingPetToStore();

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(pageShop.getBaseUri())
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    @Description("Метод POST добавить питомца в заказ")
    public void addPetStore(String IdOfTheCreatedPet,
                            String IdCategory,
                            String Quantity,
                            String ShipDate,
                            String StatusTags,
                            boolean bool) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(schemeAddingPetToStore.schema(
                        IdOfTheCreatedPet,
                        IdCategory,
                        Quantity,
                        ShipDate,
                        StatusTags,
                        bool)))
                .when()
                .post(pageShop.petAddStore())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
//                .time(lessThan(5000L))
                .body(matchesJsonSchemaInClasspath("schemaPet.json"))
                .body("id", equalTo(Integer.parseInt(IdOfTheCreatedPet)))
                .body("petId", equalTo(Integer.parseInt(IdCategory)))
                .body("status", equalTo(StatusTags))
                .body("complete", equalTo(bool));
    }

    @Description("Метод DELETE удалить питомца из заказа")
    public void deletePetStore(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .delete(pageShop.petRemovalStore(IdOfTheCreatedPet))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
//                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo(IdOfTheCreatedPet));
    }
    @Description("Метод GET найти питомца в заказе")
    public void getPetStore(
            String IdOfTheCreatedPet,
            String IdCategory,
            String nameTags,
            boolean bool) {
        given()
                .spec(requestSpec)
                .when()
                .get(pageShop.petGetStore(IdOfTheCreatedPet))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
//                .time(lessThan(5000L))
                .body(matchesJsonSchemaInClasspath("schemaStore.json"))
                .body("id", equalTo(Integer.parseInt(IdOfTheCreatedPet)))
                .body("petId", equalTo(Integer.parseInt(IdCategory)))
                .body("status", equalTo(nameTags))
                .body("complete", equalTo(bool));
    }

    @Description("Метод GET найти питомца в заказе")
    public void searchForPetsById(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .get(pageShop.petGetStore(IdOfTheCreatedPet))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
//                .time(lessThan(5000L))
                .body(matchesJsonSchemaInClasspath("schemaStore.json"))
                .body("id", equalTo(Integer.parseInt(IdOfTheCreatedPet)));
    }

    @Description("Метод GET найти количество питомцев в запасе")
    public void getFindOrderById() {
        given()
                .spec(requestSpec)
                .when()
                .get(pageShop.mustFindOrderById())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
//                .time(lessThan(5000L));
    }
}
