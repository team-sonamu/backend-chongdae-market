package woowacourse.chongdaemarket.article.repository;

public enum ArticleStatus {

    FULL,
    TIME_OUT,
    CONFIRMED,
    AVAILABLE;

    public static ArticleStatus decideArticleStatus(Article article) {
        if (article.isCountFull()) {
            return ArticleStatus.FULL;
        }
        if (article.isDeadlineOver()) {
            return ArticleStatus.TIME_OUT;
        }
        if (article.getIsManualConfirmed() || article.isAutoConfirmed()) {
            return ArticleStatus.CONFIRMED;
        }
        return ArticleStatus.AVAILABLE;
    }

    public Boolean isClosed() {
        return this != AVAILABLE;
    }
}
