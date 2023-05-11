package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import utils.Utils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetCreationPagePetTest {
RequestPet requestPet = new RequestPet();
Utils utils = new Utils();

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
    public void mustCreatePet() {
        requestPet.getPet("89430780");
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных питомца")
    @DisplayName("In this test case, we check the change of pet data")
    @Test
    public void mustUpdatePet() {
        requestPet.UpdatePet(
                "89430780",
                "1",
                "cat",
                utils.updateNamePet(),
                "1",
                utils.UpdateTagsName(),
                utils.updateStatus());
    }

    @Order(3)
    @Description("В этом тест-кейсе мы проверяем поиск по статусу питомца")
    @DisplayName("In this test case, we check the search by pet status")
    @Test
    public void findByStatus() {
        requestPet.petGetStatus("available");
    }

    @Order(4)
    @Description("В этом тест-кейсе мы проверяем обновление данных питомца в магазине")
    @DisplayName("In this test case, we check the update of pet data in the store")
    @Test
    public void mustUpdatePetDataInStore() {
        requestPet.mustNotChangePetId(
                "%",
                "1",
                "cat",
                "crty",
                "1",
                "crty",
                "available"
        );
    }

    @Order(5)
    @Description("В этом тест-кейсе мы проверяем невозможность находить животное по статусу при неверно введенном значении")
    @DisplayName("must not find an animal by statuses with an incorrectly entered value")
    @Test
    public void mustNotFindPet() {
    requestPet.mustNotFindPetByIncorrectStatus("as");
    }

    @Order(6)
    @Description("В этом тест-кейсе мы проверяем невозможность добавить питомеца в магазин при недопустимом вводе данных")
    @DisplayName("a pet should not be added to the store with invalid data entry")
    @Test
    public void petShouldNotBeAdded() {
        requestPet.notCreatePet(
                "?",
                "1",
                "cat",
                "crty",
                "1",
                "crty",
                "available"
        );
    }

    @Order(7)
    @Description("В этом тест-кейсе мы проверяем невозможность находить не созданного питомца")
    @DisplayName("In this test case, we check the impossibility of finding an uncreated pet")
    @Test
    public void mustNotFindAnUnCreatedPet() {
        requestPet.mustNotFindAnUnCreatedPet(
                "8943078015");
    }

}