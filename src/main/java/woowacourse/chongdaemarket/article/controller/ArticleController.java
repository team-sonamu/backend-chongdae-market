package woowacourse.chongdaemarket.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import woowacourse.chongdaemarket.article.controller.dto.ArticleResponse;
import woowacourse.chongdaemarket.article.controller.dto.ArticleResponses;
import woowacourse.chongdaemarket.article.controller.dto.ParticipationCountRequest;
import woowacourse.chongdaemarket.article.controller.dto.ParticipationCountResponse;
import woowacourse.chongdaemarket.article.service.ArticleService;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articles/{article-id}")
    public ResponseEntity<ArticleResponse> getArticleById(
            @PathVariable(name = "article-id") Long articleId) {
        ArticleResponse response = articleService.getArticleById(articleId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/articles")
    public ResponseEntity<ArticleResponses> getAllArticles() {
        ArticleResponses responses = articleService.getAllArticles();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/participation")
    public ResponseEntity<ParticipationCountResponse> participateArticle(
            @RequestBody ParticipationCountRequest request) {
        ParticipationCountResponse response = articleService.participateArticleById(request);
        return ResponseEntity.ok(response);
    }
}
