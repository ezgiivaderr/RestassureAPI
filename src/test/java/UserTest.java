import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void UserCreate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "  \"id\": 15151515,\n" +
                "  \"username\": \"EzgiKara120\",\n" +
                "  \"firstName\": \"Ezgi\",\n" +
                "  \"lastName\": \"Kara\",\n" +
                "  \"email\": \"someone000001@outlook.com.tr\",\n" +
                "  \"password\": \"restassure\",\n" +
                "  \"phone\": \"05333333333\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .post("/v2/user")
                .then()
                .statusCode(200);


    }

    @Test
    public void GetUserInfo() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .get("v2/user/EzgiKara120")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserUpdate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "  \"id\":151515189,\n" +
                "  \"username\": \"EzgiKara0\",\n" +
                "  \"firstName\": \"Ezgi\",\n" +
                "  \"lastName\": \"Kara\",\n" +
                "  \"email\": \"someone00@outlook.com.tr\",\n" +
                "  \"password\": \"restassured\",\n" +
                "  \"phone\": \"0533333333\",\n" +
                "  \"userStatus\": 0\n" +
                "}'";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .put("/v2/user/EzgiKara120")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserDelete() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .delete("/v2/user/EzgiKara120")
                .then()
                .statusCode(200);
    }
}
