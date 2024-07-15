package woowacourse.chongdaemarket.grouppurchase.repository;

import java.time.LocalDateTime;

public enum GroupPurchaseStatus {

    FULL,
    TIME_OUT,
    CONFIRMED,
    AVAILABLE;

    public static GroupPurchaseStatus decideGroupPurchaseStatus(GroupPurchase groupPurchase) {
        LocalDateTime deadline = groupPurchase.getDeadline();
        int totalCount = groupPurchase.getTotalCount();
        int currentCount = groupPurchase.getCurrentCount();
        boolean isManualConfirmed = groupPurchase.getIsManualConfirmed();
        if (isCountFull(totalCount, currentCount)) {
            return GroupPurchaseStatus.FULL;
        }
        if (isDeadlineOver(deadline)) {
            return GroupPurchaseStatus.TIME_OUT;
        }
        if (isManualConfirmed || isAutoConfirmed(totalCount, currentCount, deadline)) {
            return GroupPurchaseStatus.CONFIRMED;
        }
        return GroupPurchaseStatus.AVAILABLE;
    }

    private static boolean isCountFull(int totalCount, int currentCount) {
        return totalCount == currentCount;
    }

    private static boolean isDeadlineOver(LocalDateTime deadline) {
        return LocalDateTime.now().isAfter(deadline);
    }

    private static boolean isAutoConfirmed(int totalCount, int currentCount, LocalDateTime deadline) {
        return isCountFull(totalCount, currentCount) && isDeadlineOver(deadline);
    }
}
