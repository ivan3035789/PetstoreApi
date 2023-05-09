package test;


import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import requestSpecification.RequestPet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetCreationPagePetTest {
RequestPet requestPet = new RequestPet();

    @BeforeEach
    public void setUp() {
        requestPet.createPet();
    }

    @AfterEach
    public void clearingData() {
        requestPet.deletePet();
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем создание питомца")
    @DisplayName("In this test case, we check the creation of a pet")
    @Test
    void mustCreatePet() {
        requestPet.getPet();
    }

    @Order(2)
    @Description("В этом тест-кейсе мы проверяем изменение данных питомца")
    @DisplayName("In this test case, we check the change of pet data")
    @Test
    void mustUpdatePet() {
        requestPet.UpdatePet();
    }
}
