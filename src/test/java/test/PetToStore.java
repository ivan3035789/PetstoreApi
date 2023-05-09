package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import requestSpecification.RequestShop;
import requestSpecification.RequestUser;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetToStore {
    RequestShop requestShop = new RequestShop();

    @BeforeAll
    public static void createPetAndUser() {
        RequestPet requestPet = new RequestPet();
        RequestUser requestUser = new RequestUser();
        requestPet.createPet();
        requestUser.createUser();
    }

    @AfterAll
    public static void deletePetAndUser() {
        RequestPet requestPet = new RequestPet();
        RequestUser requestUser = new RequestUser();
        requestPet.deletePet();
        requestUser.deleteUser();
    }

    @BeforeEach
    public void setUp() {
        requestShop.addPetStore();
    }

    @AfterEach
    public void clearingData() {
        requestShop.deletePetStore();
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем добавление питомца в магазин")
    @DisplayName("In this test case, we check the addition of a pet to the store")
    @Test
    void mustAddPetStore() {
        requestShop.getPetStore();
    }
}
