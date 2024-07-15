package woowacourse.chongdaemarket.article.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ParticipationCountRequest(
        @NotNull
        @Positive
        Long articleId) {
}
