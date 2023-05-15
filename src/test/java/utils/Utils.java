package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class Utils {
    Faker faker = new Faker();
    Random random = new Random();

    public String idUser(int numberOfLetters) {
        Random random = new Random();
        String idUser;
        int numberOfLettersValid;
        String[] randomId = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
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
        String[] randomId = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        idOfTheCreatedPet = randomId[random.nextInt(randomId.length)];
        for (int i = 1; i < numberOfLetters; i++) {
            idOfTheCreatedPet = idOfTheCreatedPet.concat(randomId[random.nextInt(randomId.length)]);
        }
        return idOfTheCreatedPet;
    }

    public String idCategory() {
        String[] randomId = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
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
            id = idTags[2];
        }
        else if (nameCategory.equals("rodent")) {
            id = idTags[3];
        } else {
            id = idTags[4];
        }
        return id;
    }

    public String UpdateTagsName(String idTags) {
        String name;
        String[] nameTags = {"dog", "cat", "rodent", "bird"};
        if (idTags.equals("1")) {
            name = nameTags[0];
        }
        else if (idTags.equals("2")) {
            name = nameTags[2];
        }
        else if (idTags.equals("3")) {
            name = nameTags[3];
        } else {
            name = nameTags[4];
        }
        return name;
    }

    public String nameTags(String idTags) {
        String name;
        String[] nameTags = {"dog", "cat", "rodent", "bird"};
        if (idTags.equals("1")) {
            name = nameTags[0];
        }
        else if (idTags.equals("2")) {
            name = nameTags[2];
        }
        else if (idTags.equals("3")) {
            name = nameTags[3];
        } else {
            name = nameTags[4];
        }
        return name;
    }

    public String statusTags() {
        String[] status = {"available", "pending", "sold"};
        return status[random.nextInt(status.length)];
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

    public String updateNamePet() {
        return "rufus";
    }

    public String updateTagsName() {
        return "rufus";
    }

    public String updateStatus() {
        return "sold";
    }

    public String quantity() {
        return "1";
    }

    public String exceedingTheNumber() {
        return "100";
    }

    public String shipDate() {
        return "100";
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


