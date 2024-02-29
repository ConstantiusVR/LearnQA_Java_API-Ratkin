import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCookiesRequest {

    @Test

    public void testCookies(){


        Response response = RestAssured
                .given()
                .when()
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        Map<String,String> cookies = response.cookies();
        System.out.print(cookies);
       assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie!");

    }
}
