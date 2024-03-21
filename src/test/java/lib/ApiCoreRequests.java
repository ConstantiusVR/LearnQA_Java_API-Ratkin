package lib;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.path.json.JsonPath.given;
import static io.restassured.RestAssured.given;

public class ApiCoreRequests {
    @Step ("Make post-request with wrong body fields")
    public Response makePostRequest (String url, Map<String,String> userData) {
        return given()
                .filter (new AllureRestAssured())
                .body (userData)
                .post(url)
                .andReturn();
    }
}
