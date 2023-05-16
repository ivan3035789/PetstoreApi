package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import requestSpecification.RequestShop;
import requestSpecification.RequestUser;
import utils.Utils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetToStoreTest {
    RequestShop requestShop = new RequestShop();
    RequestPet requestPet = new RequestPet();
    RequestUser requestUser = new RequestUser();
    Utils utils = new Utils();
    String idUser = utils.idUser(8);
    String userName = utils.firstName();
    String firstName = utils.firstName();
    String lastName = utils.lastName();
    String email = utils.email();
    String password =utils.password();
    String phone = utils.phone(10);
    String userStatus = utils.userStatus();

    String idOfTheCreatedPet = utils.idOfTheCreatedPet(7);
    String idCategory = utils.idCategory();
    String nameCategory = utils.nameCategory();
    String nameOfTheCreatedPet = utils.nameOfTheCreatedPet();
    String idTags = utils.idTags(nameCategory);
    String nameTags = utils.nameTags(idTags);
    String statusTags = utils.statusTags();
    String quantity = utils.quantity(1);
    String shipDate = String.valueOf(utils.shipDate());

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

        requestPet.createPet(
                idOfTheCreatedPet,
                idCategory,
                nameCategory,
                nameOfTheCreatedPet,
                idTags,
                nameTags,
                statusTags
        );

        requestShop.addPetStore(
                idOfTheCreatedPet,
                idCategory,
                quantity,
                shipDate,
                nameTags,
                true
        );
    }

    @AfterEach
    public void clearingData() {
        requestShop.deletePetStore(idOfTheCreatedPet);
        requestPet.deletePet(idOfTheCreatedPet);
        requestUser.deleteUser(userName);
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем добавление питомца в магазин")
    @DisplayName("In this test case, we check the addition of a pet to the store")
    @Test
    void mustAddPetStore() {
        requestShop.getPetStore(
                idOfTheCreatedPet,
                idCategory,
                nameTags,
                true);
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем ошуществление поиска питомца на покупку по идентификатору")
    @DisplayName("the purchase order must be searched by ID")
    @Test
    void mustFindOrderById() {
        requestShop.searchForPetsById(idOfTheCreatedPet);
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем ошуществление поиска количества питомцев в запасе")
    @DisplayName("must return the number of animals in stock")
    @Test
    void mustReturnNumberOfAnimalsInStock() {
        requestShop.getFindOrderById();
    }
}
