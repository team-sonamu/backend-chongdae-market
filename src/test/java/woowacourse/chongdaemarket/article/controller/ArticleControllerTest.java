package woowacourse.chongdaemarket.article.controller;

import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ArticleControllerTest {

    @LocalServerPort
    int serverPort;

    @BeforeEach
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @DisplayName("게시글 목록 조회 API 작동을 확인한다")
    @Test
    void should_handle_read_all_articles_request_when_requested() {
        RestAssured.given().log().all()
                .when().get("/articles")
                .then().log().all()
                .statusCode(200).body("responses.size()", is(10));
    }

    @DisplayName("게시글 상세 조회 API 작동을 확인한다")
    @Test
    void should_handle_read_article_request_by_id_when_requested() {
        RestAssured.given().log().all()
                .when().get("/articles/1")
                .then().log().all()
                .statusCode(200);
    }

    @DisplayName("올바르지 않은 id로 게시글 상세 조회 API 요청 시 예외가 발생한다")
    @Test
    void should_throw_exception_when_article_id_not_exist() {
        RestAssured.given().log().all()
                .when().get("/articles/0")
                .then().log().all()
                .statusCode(400);
    }

    @DisplayName("참여하기 API 작동을 확인한다")
    @Test
    void should_handle_participation_request_by_id_when_requested() {
        Map<String, String> articleParam = Map.of(
                "articleId", "1"
        );

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(articleParam)
                .when().post("/participation")
                .then().log().all()
                .statusCode(200);
    }

    @DisplayName("정원이 모두 차있는 article에 참여하기 API 요청 시 예외가 발생한다")
    @Test
    void should_throw_exception_when_article_is_full() {
        Map<String, String> articleParam = Map.of(
                "articleId", "2"
        );

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(articleParam)
                .when().post("/participation")
                .then().log().all()
                .statusCode(400);
    }
}
