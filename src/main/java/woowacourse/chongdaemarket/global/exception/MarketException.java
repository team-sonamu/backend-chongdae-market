package woowacourse.chongdaemarket.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarketException extends RuntimeException {

    private final ErrorResponse errorResponse;
}
