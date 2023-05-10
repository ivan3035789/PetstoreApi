package test;


import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestUser;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreationPagePetTest {
    RequestUser requestUser = new RequestUser();

    @BeforeEach
    public void setUp() {
        requestUser.createUser(
                "894307801",
                "Genka",
                "Genadiy",
                "Ivanov",
                "Genadiy@rambler.ru",
                "0000",
                "83332222222",
                "1"
        );
    }

    @AfterEach
    public void clearingData() {
        requestUser.deleteUser("Genka");
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание пользователя")
    @DisplayName("In this test case, we check the creation of a user")
    @Test
    public void mustCreateUser() {
        requestUser.getUser("Genka");
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных пользователя")
    @DisplayName("In this test case, we check the change of user data")
    @Test
    public void mustUpdateUser() {
        requestUser.updateUser(
                "894307801",
                "Genka",
                "Genadiy",
                "Ivanov",
                "Genadiy@rambler.ru",
                "1111",
                "84442222222",
                "1"
        );
        requestUser.getUpdateUser("Genka");
    }


    @Order(3)
    @Description("В этом тест-кейсе мы проверяем вход пользователя в систему")
    @DisplayName("In this test case, we check the user's login to the system")
    @Test
    public void mustLogIn() {
        requestUser.logsUserIntoSystem(
                "894307801",
                "Genka",
                "Genadiy",
                "Ivanov",
                "Genadiy@rambler.ru",
                "0000",
                "83332222222",
                "1"
        );
    }
    @Order(4)
    @Description("В этом тест-кейсе мы проверяем выход пользователя из системы")
    @DisplayName("In this test case, we check the user's logout")
    @Test
    public void userLogoutFromTheSystem() {
        requestUser.userLogout(
                "894307801",
                "Genka",
                "Genadiy",
                "Ivanov",
                "Genadiy@rambler.ru",
                "0000",
                "83332222222",
                "1"
        );
    }
}
