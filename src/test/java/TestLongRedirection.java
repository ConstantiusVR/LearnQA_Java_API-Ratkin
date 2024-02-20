
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;



public class TestLongRedirection {


    @Test

    public void repFindLocationLong(String x) {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(x)
                .andReturn();
        String locationHeader = response.getHeader("Location");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        x = locationHeader;
        System.out.println(x);
    }


    public void findLocationLong() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();
        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        do {
            repFindLocationLong(locationHeader);
        } while (response.getStatusCode() == 301);

    }

}






