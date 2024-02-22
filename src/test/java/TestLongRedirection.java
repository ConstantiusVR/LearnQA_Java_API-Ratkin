
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;



public class TestLongRedirection {


    @Test

// https://playground.learnqa.ru/api/long_redirect
//    https://playground.learnqa.ru/
//   https://learnqa.ru/
//    https://www.learnqa.ru/

    public void findLocationLong() {
        String adUrl = "https://playground.learnqa.ru/api/long_redirect";

        Response response;
        do {
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(adUrl)
                    .andReturn();
            String locationHeader = response.getHeader("Location");
            System.out.println(locationHeader);
            int statusCode = response.getStatusCode();
            System.out.println(statusCode);
            adUrl = locationHeader;
        } while (response.getStatusCode() == 301);


    }



    }








