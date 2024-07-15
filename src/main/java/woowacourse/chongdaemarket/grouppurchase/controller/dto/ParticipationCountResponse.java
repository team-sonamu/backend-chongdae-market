package woowacourse.chongdaemarket.grouppurchase.controller.dto;

import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchaseStatus;

public record ParticipationCountResponse(GroupPurchaseStatus status, Integer currentCount) {
}
