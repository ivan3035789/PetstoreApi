package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {
    Faker faker = new Faker();
    Random random = new Random();

    public String idUser(int numberOfLetters) {
        Random random = new Random();
        String idUser;
        int numberOfLettersValid;
        String[] randomId = { "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if (numberOfLetters > 9) {
            numberOfLettersValid = 8;
        } else {
            numberOfLettersValid = numberOfLetters;
        }
        idUser = randomId[random.nextInt(randomId.length)];
        for (int i = 1; i < numberOfLettersValid; i++) {
            idUser = idUser.concat(randomId[random.nextInt(randomId.length)]);
        }
        return idUser;
    }

    public String firstName() {
        String[] firstName = {faker.name().firstName(), faker.name().firstName()};
        return firstName[random.nextInt(firstName.length)];
    }
    public String lastName() {
        String[] lastName = {faker.name().lastName(), faker.name().lastName()};
        return lastName[random.nextInt(lastName.length)];
    }
    public String email() {
        String[] email = {faker.internet().emailAddress(), faker.internet().emailAddress()};
        return email[random.nextInt(email.length)];
    }
    public String password() {
        String[] password = {faker.internet().password(), faker.internet().password()};
        return password[random.nextInt(password.length)];
    }

        public String phone(int num) {
        return "+7" + faker.number().digits(num);
    }

    public String userStatus() {
        String[] userStatus = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        return userStatus[random.nextInt(userStatus.length)];
    }

    public String idOfTheCreatedPet(int numberOfLetters) {
        Random random = new Random();
        String idOfTheCreatedPet;
        String[] randomId = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        idOfTheCreatedPet = randomId[random.nextInt(randomId.length)];
        for (int i = 1; i < numberOfLetters; i++) {
            idOfTheCreatedPet = idOfTheCreatedPet.concat(randomId[random.nextInt(randomId.length)]);
        }
        return idOfTheCreatedPet;
    }

    public String idCategory() {
        String[] randomId = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
       return randomId[random.nextInt(randomId.length)];
    }

    public String nameCategory() {
        String[] nameCategory = {"dog", "cat", "rodent", "bird"};
        return nameCategory[random.nextInt(nameCategory.length)];
    }

    public String nameOfTheCreatedPet() {
        String[] name = {faker.name().firstName(), faker.name().firstName()};
        return name[random.nextInt(name.length)];
    }

    public String idTags(String nameCategory) {
        String id;
        String[] idTags = {"1", "2", "3", "4"};
        if (nameCategory.equals("dog")) {
            id = idTags[0];
        }
        else if (nameCategory.equals("cat")) {
            id = idTags[1];
        }
        else if (nameCategory.equals("rodent")) {
            id = idTags[2];
        } else {
            id = idTags[3];
        }
        return id;
    }

    public String nameTags(String idTags) {
        String name;
        String[] nameTags = {"dog", "cat", "rodent", "bird"};
        if (idTags.equals("1")) {
            name = nameTags[0];
        }
        else if (idTags.equals("2")) {
            name = nameTags[1];
        }
        else if (idTags.equals("3")) {
            name = nameTags[2];
        } else {
            name = nameTags[3];
        }
        return name;
    }

    public String updateNameTags(String nameTags) {
        String updateName = null;
        String[] name = {"dog", "cat", "rodent", "bird"};
        if (nameTags.equals(name[0])) {
            String[] un = {"cat", "rodent", "bird"};
            updateName = un[random.nextInt(un.length)];
        }
        else if (nameTags.equals(name[1])) {
            String[] un = {"dog", "rodent", "bird"};
            updateName = un[random.nextInt(un.length)];
        }
        else if (nameTags.equals(name[2])) {
            String[] un = {"dog", "cat", "bird"};
            updateName = un[random.nextInt(un.length)];
        } else if (nameTags.equals(name[3])) {
            String[] un = {"dog", "cat", "rodent"};
            updateName = un[random.nextInt(un.length)];
        }
        return updateName;
    }

    public String idOfPetThatWasNotCreated(int numberOfLetters) {
        Random random = new Random();
        String idOfTheCreatedPet;
        String[] randomId = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        idOfTheCreatedPet = randomId[random.nextInt(randomId.length)];
        for (int i = 1; i < numberOfLetters; i++) {
            idOfTheCreatedPet = idOfTheCreatedPet.concat(randomId[random.nextInt(randomId.length)]);
        }
        return idOfTheCreatedPet;
    }

    public String statusTags() {
        String[] status = {"available", "pending", "sold"};
        return status[random.nextInt(status.length)];
    }

    public String updateStatusTags(String statusTags) {
        String updateStatus = null;
        String[] status = {"available", "pending", "sold"};
        if (statusTags.equals(status[0])) {
            String[] st = {"pending", "sold"};
            updateStatus = st[random.nextInt(st.length)];
        }
        else if (statusTags.equals(status[1])) {
            String[] st = {"available", "sold"};
            updateStatus = st[random.nextInt(st.length)];
        } else if (statusTags.equals(status[2])) {
            String[] st = {"available", "pending"};
            updateStatus = st[random.nextInt(st.length)];
        }
        return updateStatus;
    }

    public String updatePassword() {
        String[] password = {faker.internet().password(), faker.internet().password()};
        return password[random.nextInt(password.length)];
    }

    public String updatePhone(int num) {
        return "+7" + faker.number().digits(num);
    }

    public String nonExistentUser() {
        Random random = new Random();
        int min = 0;
        int max = 9;
        max -= min;
        int numberOfLetters = (int) ((Math.random() * ++max) + min);
        String randomNum;
        String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String username = faker.name().username();

        randomNum = num[random.nextInt(num.length)];
        for (int i = 1; i < numberOfLetters; i++) {
            randomNum = randomNum.concat(num[random.nextInt(num.length)]);
        }
        return username + randomNum;
    }

    public String quantity(int numberOfLetters) {
        Random random = new Random();
        String idOfTheCreatedPet;
        String[] randomId = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        idOfTheCreatedPet = randomId[random.nextInt(randomId.length)];
        for (int i = 1; i < numberOfLetters; i++) {
            idOfTheCreatedPet = idOfTheCreatedPet.concat(randomId[random.nextInt(randomId.length)]);
        }
        return idOfTheCreatedPet;
    }

    public String exceedingTheNumber() {
        return "100";
    }

    public String shipDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getExceedingTheNumber() {
        return "2023-04-04T09:28:18.115+0000";
    }

    public String invalidUserName() {
        return "fvhbjbkrjhbjkbgjjbjk";
    }
    //    private String updatePassword = "1111";
//    private String updatePhone = "84442222222";
//    private String nonExistentUser = "Olega123654";
//    private String updateNamePet = "rufus";
//    private String updateTagsName = "rufus";
//    private String updateStatus = "sold";
//    private String quantity = "1";
//    private String exceedingTheNumber = "100";
//    private String shipDate = "100";
//    private String getExceedingTheNumber = "2023-04-04T09:28:18.115+0000";
//    private String invalidUserName = "fvhbjbkrjhbjkbgjjbjk";
}


