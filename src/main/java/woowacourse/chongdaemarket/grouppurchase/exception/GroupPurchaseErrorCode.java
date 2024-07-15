package woowacourse.chongdaemarket.grouppurchase.exception;

import org.springframework.http.HttpStatus;
import woowacourse.chongdaemarket.global.exception.ErrorResponse;

public enum GroupPurchaseErrorCode implements ErrorResponse {

    GROUP_PURCHASE_NOT_FOUND(HttpStatus.BAD_REQUEST,"해당 게시글이 존재하지 않습니다."),
    GROUP_PURCHASE_PARTICIPANT_ALREADY_FULL(HttpStatus.BAD_REQUEST,"해당 게시글의 참여 가능한 인원수를 초과하였습니다.")
    ;

    private final HttpStatus status;
    private final String detail;

    GroupPurchaseErrorCode(HttpStatus status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getDetail() {
        return this.detail;
    }
}
