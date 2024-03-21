package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import lib.ApiCoreRequests;

@Epic("Method 'User' tests")
public class UserRegisterTest extends BaseTestCase {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test
    @Description("Try to create new user with wrong email format")
    @DisplayName("Negative test with wrong email")
    public void testCreateUserWithWrongEmail (){

        Map<String, String> userData = new HashMap<>();
        userData.put("username", "Constantius");
        userData.put("firstName","Constantine");
        userData.put("lastName","Const");
        userData.put("email","const11.yandex.ru");
        userData.put("password","123456");

        Response responseCreateNewUser = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData);


System.out.println(responseCreateNewUser.asString());

    }


    @Description("Try to create user without one field from body")
    @DisplayName("One absend field from body")
    @ParameterizedTest
    @ValueSource (strings = {"\"email\": \"const11.@yandex.ru\", \"password\": \" \", \"username\": \"Constantius\", \"firstName\": \"Constantine\", \"lastName\": \"Const\"",
            "\"email\": \"const11.@yandex.ru\", \"password\": \"123456\", \"username\": \"Constantius\", \"firstName\": \"Constantine\"",
            "\"email\": \"const11.@yandex.ru\", \"password\": \"123456\", \"username\": \"Constantius\", \"lastName\": \"Const\"",
            "\"email\": \"const11.@yandex.ru\", \"password\": \"123456\", \"firstName\": \"Constantine\", \"lastName\": \"Const\"",
            "\"password\": \"123456\", \"username\": \"Constantius\", \"firstName\": \"Constantine\", \"lastName\": \"Const\""})

    public void testCreateUserWithoutOneParam (String  params){

        Map<String, String> userData = new HashMap<>();
        userData.put("body", params);


        Response responseCreateUser = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData);

        System.out.println(responseCreateUser.asString());

    }

    @Test
    @Description("Creation user with short name")
    @DisplayName("Short name test")

    public void testCreateUserWithShortName (){
        Map<String, String> userData = new HashMap<>();
        userData.put("username", "C");
        userData.put("firstName","Constantine");
        userData.put("lastName","Const");
        userData.put("email","const11.@yandex.ru");
        userData.put("password","123456");

        Response responseCreateShortUser = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData);


        System.out.println(responseCreateShortUser.asString());

    }

    @Test
    @Description("Creation user with long name")
    @DisplayName("Long name test")
    public void testCreateUserWithLongName () {
        Map<String, String> userData = new HashMap<>();
        userData.put("username", "Ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnntttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        userData.put("firstName", "Constantine");
        userData.put("lastName", "Const");
        userData.put("email", "const11.@yandex.ru");
        userData.put("password", "123456");

        Response responseCreateLongUser = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData);


        System.out.println(responseCreateLongUser.asString());
    }




}
