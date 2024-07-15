package woowacourse.chongdaemarket.article.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import woowacourse.chongdaemarket.global.exception.ErrorMessage;
import woowacourse.chongdaemarket.global.exception.ErrorResponse;

@AllArgsConstructor
@Getter
public enum ArticleErrorCode implements ErrorResponse {

    ARTICLE_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 게시글이 존재하지 않습니다."),
    ARTICLE_PARTICIPANT_ALREADY_FULL(HttpStatus.BAD_REQUEST, "해당 게시글의 참여 가능한 인원수를 초과하였습니다.");

    private final HttpStatus status;

    private final String detail;

    @Override
    public ErrorMessage getErrorMessage() {
        return new ErrorMessage(this.detail);
    }
}
