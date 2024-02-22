import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongTimeTest {

    @Test

    public void testTask() throws InterruptedException {

        JsonPath response = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String getToken = response.get("token");



        Map<String, String> token = new HashMap<>();
        token.put("token", getToken);
        JsonPath secondResponse = RestAssured

                .given()
                .queryParams(token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String getStatus = secondResponse.get("status");
        if (Objects.equals(getStatus, "Job is NOT ready")){
            System.out.println("The status is correct: Job is NOT ready");
        } else if (Objects.equals(getStatus, "Job is ready")) {
            System.out.println("The status is correct: Job is ready");
        }


        Thread.sleep(20000);
        JsonPath thirdResponse = RestAssured

                .given()
                .queryParams(token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String getNewStatus = thirdResponse.get("status");
        String result = thirdResponse.get("result");
        if (Objects.equals(getNewStatus, "Job is NOT ready")){
            System.out.println("The status is correct: Job is NOT ready");
        } else if (Objects.equals(getNewStatus, "Job is ready")) {
            System.out.println("The status is correct: Job is ready");
        }
     if (result != null){
         System.out.println(result);
     }


    }
}
