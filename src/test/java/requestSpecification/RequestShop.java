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
    public void addPetStore() {
        given()
                .spec(requestSpec)
                .body(gson.toJson(schemeAddingPetToStore.getJsonObject()))
                .when()
                .post(pageShop.getPetAddStore())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }
    @Description("Метод DELETE удалить питомца из заказа")
    public void deletePetStore() {
        given()
                .spec(requestSpec)
                .when()
                .delete(pageShop.getPetRemovalStore())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }
    @Description("Метод GET найти питомца в заказе")
    public void getPetStore() {
        given()
                .spec(requestSpec)
                .when()
                .get(pageShop.getPetGetStore())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }
}
