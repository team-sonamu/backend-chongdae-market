package woowacourse.chongdaemarket.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorResponse {

    HttpStatus getStatus();

    String getDetail();
}