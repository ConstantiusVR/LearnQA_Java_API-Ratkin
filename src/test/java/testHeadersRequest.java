import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class testHeadersRequest {
    @Test

    public void testHeaders() {


        Response response = RestAssured
                .given()
                .when()
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        Headers headers = response.getHeaders();
        System.out.print(headers);
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' header!");
    }
}
