package woowacourse.chongdaemarket.grouppurchase.repository;

public enum GroupPurchaseStatus {

    FULL,
    TIME_OUT,
    CONFIRMED,
    AVAILABLE;

    public static GroupPurchaseStatus decideGroupPurchaseStatus(GroupPurchase groupPurchase) {
        if (groupPurchase.isCountFull()) {
            return GroupPurchaseStatus.FULL;
        }
        if (groupPurchase.isDeadlineOver()) {
            return GroupPurchaseStatus.TIME_OUT;
        }
        if (groupPurchase.getIsManualConfirmed() || groupPurchase.isAutoConfirmed()) {
            return GroupPurchaseStatus.CONFIRMED;
        }
        return GroupPurchaseStatus.AVAILABLE;
    }
}
