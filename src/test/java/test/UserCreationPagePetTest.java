package test;


import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestUser;
import utils.Utils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreationPagePetTest {
    RequestUser requestUser = new RequestUser();
    Utils utils = new Utils();
    String idUser = utils.idUser(8);
    String userName = utils.firstName();
    String firstName = utils.firstName();
    String lastName = utils.lastName();
    String email = utils.email();
    String password =utils.password();
    String updatePassword =utils.updatePassword();
    String phone = utils.phone(10);
    String updatePhone = utils.updatePhone(10);
    String userStatus = utils.userStatus();

    @BeforeEach
    public void setUp() {
        requestUser.createUser(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                password,
                phone,
                userStatus
        );
    }

    @AfterEach
    public void clearingData() {
        requestUser.deleteUser(userName);
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание пользователя")
    @DisplayName("In this test case, we check the creation of a user")
    @Test
    public void mustCreateUser() {
        requestUser.getUser(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                password,
                phone,
                userStatus);
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных пользователя")
    @DisplayName("In this test case, we check the change of user data")
    @Test
    public void mustUpdateUser() {
        requestUser.updateUser(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                updatePassword,
                updatePhone,
                userStatus
        );
        requestUser.getUpdateUser(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                updatePassword,
                updatePhone,
                userStatus);
    }


    @Order(3)
    @Description("В этом тест-кейсе мы проверяем вход пользователя в систему")
    @DisplayName("In this test case, we check the user's login to the system")
    @Test
    public void mustLogIn() {
        requestUser.logsUserIntoSystem(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                password,
                phone,
                userStatus
        );
    }
    @Order(4)
    @Description("В этом тест-кейсе мы проверяем выход пользователя из системы")
    @DisplayName("In this test case, we check the user's logout")
    @Test
    public void userLogout() {
        requestUser.userLogout(
                idUser,
                userName,
                firstName,
                lastName,
                email,
                password,
                phone,
                userStatus
        );
    }
}
