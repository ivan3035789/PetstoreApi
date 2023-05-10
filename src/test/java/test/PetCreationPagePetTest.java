package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import utils.Utils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetCreationPagePetTest {
RequestPet requestPet = new RequestPet();
Utils utils = new Utils();
//    Pet pet = new Pet("89430780", "1", "cat", "crty", "1", "crty", "available");

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
    }

    @AfterEach
    public void clearingData() {
        requestPet.deletePet("89430780");
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание питомца")
    @DisplayName("In this test case, we check the creation of a pet")
    @Test
    void mustCreatePet() {
        requestPet.getPet("89430780");
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных питомца")
    @DisplayName("In this test case, we check the change of pet data")
    @Test
    void mustUpdatePet() {
        requestPet.UpdatePet(
                "89430780",
                "1",
                "cat",
                utils.updateNamePet(),
                "1",
                utils.UpdateTagsName(),
                utils.updateStatus());
    }
}
