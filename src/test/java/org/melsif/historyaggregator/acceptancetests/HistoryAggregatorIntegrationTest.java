package org.melsif.historyaggregator.acceptancetests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class HistoryAggregatorIntegrationTest extends BaseIntegrationTest {

    @Test
    void should_persist_an_msn_message() {
        given()
            .multiPart("file", new File("resources/examples/msn-message.xml"))
            .accept(ContentType.XML)
            .when()
            .post("http://localhost:8080/fileupload")
            .then()
            .statusCode(200);
    }
}

