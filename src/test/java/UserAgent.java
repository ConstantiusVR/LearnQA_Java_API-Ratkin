
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAgent {

    @ParameterizedTest
    @ValueSource (strings = {"Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
    "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1",
    "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0",
    "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1"})

    public void testAgent(String name) {

int i=0;

do {
    Map<String, String> params = new HashMap<>();
    params.put("user_agent", name);

    JsonPath response = RestAssured
            .given()
            .queryParams(params)
            .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
            .jsonPath();

    String platform = response.getString("platform");
    String browser = response.getString("browser");
    String device = response.getString("device");
    String answer = platform + " " + browser + " " + device + " ";

    String[] expectedValues = new String[]{"platform': 'Mobile', 'browser': 'No', 'device': 'Android",
            "platform': 'Mobile', 'browser': 'Chrome', 'device': 'iOS",
            "platform': 'Googlebot', 'browser': 'Unknown', 'device': 'Unknown",
            "platform': 'Web', 'browser': 'Chrome', 'device': 'No",
            "platform': 'Mobile', 'browser': 'No', 'device': 'iPhone"};


    assertEquals(expectedValues[i], answer, "Unexpected values");
} while (true);




    }

}