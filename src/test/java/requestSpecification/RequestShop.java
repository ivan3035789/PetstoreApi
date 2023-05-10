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
                            String bool) {
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
                .time(lessThan(5000L))
                .body(matchesJsonSchemaInClasspath("schemaPet.json"))
                .body("id", equalTo(89430780))
                .body("petId", equalTo(1))
//                .body("quantity", equalTo(1))
                .body("status", equalTo("available"))
                .body("complete", equalTo(true));
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
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("89430780"));
    }
    @Description("Метод GET найти питомца в заказе")
    public void getPetStore(String IdOfTheCreatedPet) {
        given()
                .spec(requestSpec)
                .when()
                .get(pageShop.petGetStore(IdOfTheCreatedPet))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body(matchesJsonSchemaInClasspath("schemaStore.json"))
                .body("id", equalTo(89430780))
                .body("petId", equalTo(1))
//                .body("quantity", equalTo(1))
                .body("status", equalTo("available"))
                .body("complete", equalTo(true));
    }
}
