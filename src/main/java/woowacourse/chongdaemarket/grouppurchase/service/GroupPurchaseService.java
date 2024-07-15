package woowacourse.chongdaemarket.grouppurchase.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowacourse.chongdaemarket.global.exception.MarketException;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.GroupPurchaseGetByIdResponse;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.ParticipationCountRequest;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.ParticipationCountResponse;
import woowacourse.chongdaemarket.grouppurchase.exception.GroupPurchaseErrorCode;
import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchase;
import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchaseRepository;
import woowacourse.chongdaemarket.grouppurchase.repository.GroupPurchaseStatus;

@RequiredArgsConstructor
@Service
public class GroupPurchaseService {

    private final GroupPurchaseRepository groupPurchaseRepository;

    public GroupPurchaseGetByIdResponse getGroupPurchaseById(Long groupPurchaseId) {
        GroupPurchase groupPurchase = groupPurchaseRepository.findById(groupPurchaseId)
                .orElseThrow(); // TODO: 예외 처리
        BigDecimal splitPrice = calculateSplitPrice(groupPurchase);
        GroupPurchaseStatus status = GroupPurchaseStatus.decideGroupPurchaseStatus(groupPurchase);
        return new GroupPurchaseGetByIdResponse(groupPurchase, splitPrice, status);
    }

    private BigDecimal calculateSplitPrice(GroupPurchase groupPurchase) {
        BigDecimal totalPrice = groupPurchase.getTotalPrice();
        int totalCount = groupPurchase.getTotalCount();
        return totalPrice.divide(BigDecimal.valueOf(totalCount), RoundingMode.HALF_UP);
    }

    @Transactional
    public ParticipationCountResponse participateGroupPurchaseById(ParticipationCountRequest request) {
        GroupPurchase groupPurchase = groupPurchaseRepository.findById(request.articleId())
                .orElseThrow(() -> new MarketException(GroupPurchaseErrorCode.GROUP_PURCHASE_NOT_FOUND));
        return new ParticipationCountResponse(groupPurchase.addParticipant());
    }
}
