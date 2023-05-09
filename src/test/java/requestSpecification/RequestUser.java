package requestSpecification;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import page.PageUser;
import scheme.UserCreationScheme;
import scheme.UserUpdateScheme;
import utils.Utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestUser {
    Gson gson = new Gson();
    PageUser pageUser = new PageUser();
    UserCreationScheme userCreationScheme = new UserCreationScheme();
    UserUpdateScheme userUpdateScheme = new UserUpdateScheme();
    Utils utils = new Utils();

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(pageUser.getBaseUri())
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Description("Метод POST создать ользователя")
    public void createUser() {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userCreationScheme.getJsonObject()))
                .when()
                .post(pageUser.getCreationUser())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("894307801"));
    }

    @Description("Метод DELETE удалить пользователя")
    public void deleteUser() {
        given()
                .spec(requestSpec)
                .when()
                .delete(pageUser.getRemovalUser()) // удалить ользователя
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("Genka"));
    }

    @Description("Метод GET найти пользователя")
    public void getUser() {
        given()
                .spec(requestSpec)
                .when()
                .get(pageUser.getUserGetPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("id", equalTo(894307801))
                .body("username", equalTo("Genka"))
                .body("firstName", equalTo("Genadiy"))
                .body("lastName", equalTo("Ivanov"))
                .body("email", equalTo("Genadiy@rambler.ru"))
                .body("password", equalTo("0000"))
                .body("phone", equalTo("83332222222"))
                .body("userStatus", equalTo(1));
    }

    @Description("Метод PUT изменить данные ользователя")
    public void updateUser() {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userUpdateScheme.getJsonObject()))
                .when()
                .put(pageUser.getUserGetPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("894307801"));
    }

    @Description("Метод GET найти пользователя")
    public void getUpdateUser() {
        given()
                .spec(requestSpec)
                .when()
                .get(pageUser.getUserGetPage())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body("id", equalTo(894307801))
                .body("username", equalTo("Genka"))
                .body("firstName", equalTo("Genadiy"))
                .body("lastName", equalTo("Ivanov"))
                .body("email", equalTo("Genadiy@rambler.ru"))
                .body("password", equalTo("1111"))
                .body("phone", equalTo("84442222222"))
                .body("userStatus", equalTo(1));
    }
}
