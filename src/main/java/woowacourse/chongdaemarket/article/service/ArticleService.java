package woowacourse.chongdaemarket.article.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowacourse.chongdaemarket.article.controller.dto.ArticleResponse;
import woowacourse.chongdaemarket.article.controller.dto.ArticleResponses;
import woowacourse.chongdaemarket.article.controller.dto.ParticipationCountRequest;
import woowacourse.chongdaemarket.article.controller.dto.ParticipationCountResponse;
import woowacourse.chongdaemarket.article.exception.ArticleErrorCode;
import woowacourse.chongdaemarket.article.repository.Article;
import woowacourse.chongdaemarket.article.repository.ArticleRepository;
import woowacourse.chongdaemarket.article.repository.ArticleStatus;
import woowacourse.chongdaemarket.global.exception.MarketException;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleResponse getArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(); // TODO: 예외 처리
        BigDecimal splitPrice = calculateSplitPrice(article);
        ArticleStatus status = ArticleStatus.decideArticleStatus(article);
        return new ArticleResponse(article, splitPrice, status);
    }

    public ArticleResponses getAllArticles() {
        List<ArticleResponse> articleResponse = articleRepository.findAll().stream()
                .map(article -> {
                    BigDecimal splitPrice = calculateSplitPrice(article);
                    ArticleStatus status = ArticleStatus.decideArticleStatus(article);
                    return new ArticleResponse(article, splitPrice, status);
                })
                .toList();

        return new ArticleResponses(articleResponse);
    }

    private BigDecimal calculateSplitPrice(Article article) {
        BigDecimal totalPrice = article.getTotalPrice();
        int totalCount = article.getTotalCount();
        return totalPrice.divide(BigDecimal.valueOf(totalCount), RoundingMode.HALF_UP);
    }

    @Transactional
    public ParticipationCountResponse participateArticleById(ParticipationCountRequest request) {
        Article article = articleRepository.findById(request.articleId())
                .orElseThrow(() -> new MarketException(ArticleErrorCode.ARTICLE_NOT_FOUND));
        Integer currentCount = article.addParticipant();
        ArticleStatus status = ArticleStatus.decideArticleStatus(article);
        return new ParticipationCountResponse(status, currentCount);
    }
}
