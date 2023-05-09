package test;


import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestUser;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreationPagePetTest {
    RequestUser requestUser = new RequestUser();

    @BeforeEach
    public void setUp() {
        requestUser.createUser();
    }

    @AfterEach
    public void clearingData() {
        requestUser.deleteUser();
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание пользователя")
    @DisplayName("In this test case, we check the creation of a user")
    @Test
    public void mustCreateUser() {
        requestUser.getUser();
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных пользователя")
    @DisplayName("In this test case, we check the change of user data")
    @Test
    public void mustUpdateUser() {
        requestUser.updateUser();
        requestUser.getUpdateUser();
    }
}
