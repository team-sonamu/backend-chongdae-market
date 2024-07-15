package woowacourse.chongdaemarket.grouppurchase.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchase;
import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchaseStatus;

public record GroupPurchaseResponse(Long id,
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
                                    BigDecimal splitPrice,
                                    BigDecimal totalPrice,
                                    GroupPurchaseStatus status) {

    public GroupPurchaseResponse(GroupPurchase groupPurchase,
                                 BigDecimal splitPrice,
                                 GroupPurchaseStatus status) {
        this(groupPurchase.getId(),
                groupPurchase.getTitle(),
                groupPurchase.getMember().getNickname(),
                groupPurchase.getProductUrl(),
                groupPurchase.getMeetingAddress(),
                groupPurchase.getMeetingAddressDetail(),
                groupPurchase.getDescription(),
                groupPurchase.getDeadline(),
                groupPurchase.getCurrentCount(),
                groupPurchase.getTotalCount(),
                groupPurchase.getThumbnailUrl(),
                splitPrice,
                groupPurchase.getTotalPrice(),
                status);
    }
}
