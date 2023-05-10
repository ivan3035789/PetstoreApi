package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import requestSpecification.RequestShop;
import requestSpecification.RequestUser;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetToStoreTest {
    RequestShop requestShop = new RequestShop();
    RequestPet requestPet = new RequestPet();

    @BeforeAll
    public static void createPetAndUser() {
        RequestUser requestUser = new RequestUser();
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

    @AfterAll
    public static void deletePetAndUser() {
        RequestUser requestUser = new RequestUser();
        requestUser.deleteUser("Genka");
    }

    @BeforeEach
    public void setUp() {
        requestPet.createPet(
                "89430780",
                "1",
                "cat",
                "crty",
                "1",
                "crty",
                "available"
        );

        requestShop.addPetStore(
                "89430780",
                "1",
                "1",
                "100",
                "available",
                "true"
        );
    }

    @AfterEach
    public void clearingData() {
        requestShop.deletePetStore("89430780");
        requestPet.deletePet("89430780");
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем добавление питомца в магазин")
    @DisplayName("In this test case, we check the addition of a pet to the store")
    @Test
    void mustAddPetStore() {
        requestShop.getPetStore("89430780");
    }
}
