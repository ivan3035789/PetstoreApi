package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;
import utils.Utils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetCreationPagePetTest {
RequestPet requestPet = new RequestPet();
Utils utils = new Utils();

String idOfTheCreatedPet = utils.idOfTheCreatedPet(7);
String invalidIdOfTheCreatedPet = "%";

String invalidIdOfTheCreatedPet2 = "?";
String idCategory = utils.idCategory();
String nameCategory = utils.nameCategory();
String nameOfTheCreatedPet = utils.nameOfTheCreatedPet();
String idTags = utils.idTags(nameCategory);
String nameTags = utils.nameTags(idTags);

String updateNameTags = utils.updateNameTags(nameTags);
String statusTags = utils.statusTags();

String updateStatusTags = utils.updateStatusTags(statusTags);
String invalidStatus = "as";

String idOfPetThatWasNotCreated = utils.idOfPetThatWasNotCreated(10);

    @BeforeEach
    public void setUp() {
        requestPet.createPet(
                idOfTheCreatedPet,
                idCategory,
                nameCategory,
                nameOfTheCreatedPet,
                idTags,
                nameTags,
                statusTags
        );
    }

    @AfterEach
    public void clearingData() {
        requestPet.deletePet(idOfTheCreatedPet);
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание питомца")
    @DisplayName("In this test case, we check the creation of a pet")
    @Test
    public void mustCreatePet() {
        requestPet.getPet(
                idOfTheCreatedPet,
                nameCategory,
                nameOfTheCreatedPet,
                statusTags);
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных питомца")
    @DisplayName("In this test case, we check the change of pet data")
    @Test
    public void mustUpdatePet() {
        requestPet.UpdatePet(
                idOfTheCreatedPet,
                idCategory,
                nameCategory,
                nameOfTheCreatedPet,
                idTags,
                updateNameTags,
                updateStatusTags);
    }

    @Order(3)
    @Description("В этом тест-кейсе мы проверяем поиск по статусу питомца")
    @DisplayName("In this test case, we check the search by pet status")
    @Test
    public void findByStatus() {
        requestPet.petGetStatus(statusTags);
    }

    @Order(4)
    @Description("В этом тест-кейсе мы проверяем обновление данных питомца в магазине")
    @DisplayName("In this test case, we check the update of pet data in the store")
    @Test
    public void mustUpdatePetDataInStore() {
        requestPet.mustNotChangePetId(
                invalidIdOfTheCreatedPet,
                idCategory,
                nameCategory,
                nameOfTheCreatedPet,
                idTags,
                updateNameTags,
                updateStatusTags
        );
    }

    @Order(5)
    @Description("В этом тест-кейсе мы проверяем невозможность находить животное по статусу при неверно введенном значении")
    @DisplayName("must not find an animal by statuses with an incorrectly entered value")
    @Test
    public void mustNotFindPet() {
    requestPet.mustNotFindPetByIncorrectStatus(invalidStatus);
    }

    @Order(6)
    @Description("В этом тест-кейсе мы проверяем невозможность добавить питомеца в магазин при недопустимом вводе данных")
    @DisplayName("a pet should not be added to the store with invalid data entry")
    @Test
    public void petShouldNotBeAdded() {
        requestPet.notCreatePet(
                invalidIdOfTheCreatedPet2,
                idCategory,
                nameCategory,
                nameOfTheCreatedPet,
                idTags,
                nameTags,
                statusTags
        );
    }

    @Order(7)
    @Description("В этом тест-кейсе мы проверяем невозможность находить не созданного питомца")
    @DisplayName("In this test case, we check the impossibility of finding an uncreated pet")
    @Test
    public void mustNotFindAnUnCreatedPet() {
        requestPet.mustNotFindAnUnCreatedPet(idOfPetThatWasNotCreated);
    }
}