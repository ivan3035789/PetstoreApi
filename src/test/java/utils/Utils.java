package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class Utils {
    Faker faker = new Faker();
    Random random = new Random();

    public String idUser() {
        String[] idUser = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        return idUser[random.nextInt(idUser.length)];
    }

    public String username() {
        String[] username = {faker.name().username(), faker.name().username()};
        return username[random.nextInt(username.length)];
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
    public String phone() {
        String[] phone = {String.valueOf(faker.phoneNumber()), String.valueOf(faker.phoneNumber())};
        return phone[random.nextInt(phone.length)];
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
       return "1";
    }

    public String nameCategory() {
        return "cat";
    }

    public String nameOfTheCreatedPet() {
        return "crty";
    }

    public String idTags() {
        return "1";
    }

    public String UpdateTagsName() {
        return "rufus";
    }

    public String nameTags() {
        return "crty";
    }

    public String statusTags() {
        return "available";
    }

//    public String updatePassword() {
//        String[] updatePassword = {faker.internet().password(), faker.internet().password()};
//        return updatePassword[random.nextInt(updatePassword.length)];
//    }

    public String updatePassword() {

        return "1111";
    }

//    public String updatePhone() {
//        String[] updatePhone = {String.valueOf(faker.phoneNumber()), String.valueOf(faker.phoneNumber())};
//        return updatePhone[random.nextInt(updatePhone.length)];
//    }

    public String updatePhone() {

        return "84442222222";
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
}


