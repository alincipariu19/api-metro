package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import models.requestbodies.BaseRequestBody;

import static io.restassured.RestAssured.given;

public class RestActions {

    public static Response doGetRequest(String baseUri, String path) {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = baseUri;
        return given()
                .log().all()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response doPostRequest(String baseUri, String path, BaseRequestBody body) {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = baseUri;
        return given()
                .log().all()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response doPutRequest(String baseUri, String path, BaseRequestBody body) {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = baseUri;
        return given()
                .log().all()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response doDeleteRequest(String baseUri, String path) {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = baseUri;
        return given()
                .log().all()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
