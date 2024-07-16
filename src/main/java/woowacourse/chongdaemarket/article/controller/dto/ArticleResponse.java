package woowacourse.chongdaemarket.article.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import woowacourse.chongdaemarket.article.repository.Article;
import woowacourse.chongdaemarket.article.repository.ArticleStatus;

public record ArticleResponse(Long id,
                              String title,
                              String nickname,
                              String productUrl,
                              String meetingAddress,
                              String meetingAddressDetail,
                              String description,
                              LocalDateTime deadline,
                              Integer currentCount,
                              Integer totalCount,
                              String thumbnailUrl,
                              BigDecimal dividedPrice,
                              BigDecimal totalPrice,
                              ArticleStatus status,
                              Boolean isClosed) {

    public ArticleResponse(Article article,
                           BigDecimal dividedPrice,
                           ArticleStatus status) {
        this(article.getId(),
                article.getTitle(),
                article.getMember().getNickname(),
                article.getProductUrl(),
                article.getMeetingAddress(),
                article.getMeetingAddressDetail(),
                article.getDescription(),
                article.getDeadline(),
                article.getCurrentCount(),
                article.getTotalCount(),
                article.getThumbnailUrl(),
                dividedPrice,
                article.getTotalPrice(),
                status,
                status.isClosed());
    }
}
