
import io.restassured.RestAssured;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class BookTests extends BaseTest{

    @Test
    public void Addbook() {

        String bodyPayLoad = "{\n" +
                "    \"id\": 101,\n" +
                "    \"category\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Fiction\"\n" +
                "    },\n" +
                "    \"name\": \"The Great Gatsby\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"https://m.media-amazon.com/images/I/61qPJBZToiL._SY466_.jpg\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"classic\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .post("/v2/pet")
                .then()
                .statusCode(200);


    }

    @Test
    public void GetInfoByID() {
        Addbook();
        String bodyPayLoad ="{\n" +
                "    \"id\": 101,\n" +
                "    \"category\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Science Fiction\"\n" +
                "    },\n" +
                "    \"name\": \"Dune\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"https://m.media-amazon.com/images/I/61qctaGFdUL._SY466_.jpg\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"name\": \"Adventure\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"sold\"\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .get("v2/pet/101")
                .then()
                .statusCode(200);
    }

    @Test
    public void BookUpdate() {

        String bodyPayLoad = "{\n" +
                "    \"id\": 101,\n" +
                "    \"category\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Science Fiction\"\n" +
                "    },\n" +
                "    \"name\": \"Dune\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"https://m.media-amazon.com/images/I/61qctaGFdUL._SY466_.jpg\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"name\": \"Adventure\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"sold\"\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .put("v2/pet")
                .then()
                .statusCode(200);
    }

    @Test
    public void BookDelete() {
        Addbook();

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .delete("v2/pet/101")
                .then()
                .statusCode(200);
    }
}
