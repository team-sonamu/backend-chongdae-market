package woowacourse.chongdaemarket.article.controller.dto;

import woowacourse.chongdaemarket.article.repository.ArticleStatus;

public record ParticipationCountResponse(ArticleStatus status, Integer currentCount) {
}
