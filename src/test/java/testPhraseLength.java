import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPhraseLength {
    @Test
    public void lengthCheck(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        List<LinkedHashMap> fromHomework = response.get("messages");
        String answer = String.valueOf(fromHomework.get(0));
        assertTrue(answer.length() > 15, "The string is too short");

    }
}
