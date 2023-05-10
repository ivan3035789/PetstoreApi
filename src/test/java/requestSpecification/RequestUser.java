package requestSpecification;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import page.PageUser;
import scheme.UserCreationScheme;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RequestUser {
    Gson gson = new Gson();
    PageUser pageUser = new PageUser();
    UserCreationScheme userCreationScheme = new UserCreationScheme();

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(pageUser.getBaseUri())
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Description("Метод POST создать пользователя")
    public void createUser(String IdUser,
                           String Username,
                           String FirstName,
                           String LastName,
                           String Email,
                           String Password,
                           String Phone,
                           String UserStatus) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userCreationScheme.schema(IdUser,
                        Username,
                        FirstName,
                        LastName,
                        Email,
                        Password,
                        Phone,
                        UserStatus)))
                .when()
                .post(pageUser.creationUser())
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("894307801"));
    }

    @Description("Метод DELETE удалить пользователя")
    public void deleteUser(String userName) {
        given()
                .spec(requestSpec)
                .when()
                .delete(pageUser.removalUser(userName))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("Genka"));
    }

    @Description("Метод GET найти пользователя")
    public void getUser(String userName) {
        given()
                .spec(requestSpec)
                .when()
                .get(pageUser.userGetPage(userName))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("id", equalTo(894307801))
                .body("username", equalTo("Genka"))
                .body("firstName", equalTo("Genadiy"))
                .body("lastName", equalTo("Ivanov"))
                .body("email", equalTo("Genadiy@rambler.ru"))
                .body("password", equalTo("0000"))
                .body("phone", equalTo("83332222222"))
                .body("userStatus", equalTo(1))
                .body(matchesJsonSchemaInClasspath("schemaUser.json"));
    }

    @Description("Метод PUT изменить данные ользователя")
    public void updateUser(String IdUser,
                           String Username,
                           String FirstName,
                           String LastName,
                           String Email,
                           String Password,
                           String Phone,
                           String UserStatus) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userCreationScheme.schema(
                        IdUser,
                        Username,
                        FirstName,
                        LastName,
                        Email,
                        Password,
                        Phone,
                        UserStatus)))
                .when()
                .put(pageUser.userGetPage(Username))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("894307801"))
                .body(matchesJsonSchemaInClasspath("schemaUser.json"));
    }

    @Description("Метод GET найти пользователя")
    public void getUpdateUser(String userName) {
        given()
                .spec(requestSpec)
                .when()
                .get(pageUser.userGetPage(userName))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("id", equalTo(894307801))
                .body("username", equalTo("Genka"))
                .body("firstName", equalTo("Genadiy"))
                .body("lastName", equalTo("Ivanov"))
                .body("email", equalTo("Genadiy@rambler.ru"))
                .body("password", equalTo("1111"))
                .body("phone", equalTo("84442222222"))
                .body("userStatus", equalTo(1))
                .body(matchesJsonSchemaInClasspath("schemaUser.json"));
    }

    @Description("Метод GET регистрирует пользователя в системе")
    public void logsUserIntoSystem(String IdUser,
                                   String Username,
                                   String FirstName,
                                   String LastName,
                                   String Email,
                                   String Password,
                                   String Phone,
                                   String UserStatus) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userCreationScheme.schema(
                        IdUser,
                        Username,
                        FirstName,
                        LastName,
                        Email,
                        Password,
                        Phone,
                        UserStatus)))
                .when()
                .get(pageUser.logsUserIntoSystem(Username, Password))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"));
//                .body("message", equalTo("logged in user session:" + номер сессии 1254879));
    }

    @Description("Метод GET выход пользователя из системы")
    public void userLogout(String IdUser,
                           String Username,
                           String FirstName,
                           String LastName,
                           String Email,
                           String Password,
                           String Phone,
                           String UserStatus) {
        given()
                .spec(requestSpec)
                .body(gson.toJson(userCreationScheme.schema(
                        IdUser,
                        Username,
                        FirstName,
                        LastName,
                        Email,
                        Password,
                        Phone,
                        UserStatus)))
                .when()
                .get(pageUser.userLogoutFromSystem(Username))
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("ok"));
    }
}
