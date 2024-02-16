import groovyjarjarpicocli.CommandLine;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

public class testRestAssured {


    @Test
    public void getText(){

        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        List<LinkedHashMap> answer = response.get("messages");
        System.out.println(answer.get(1));





    }
}
