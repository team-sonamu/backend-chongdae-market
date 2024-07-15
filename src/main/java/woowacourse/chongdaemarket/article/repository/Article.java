package woowacourse.chongdaemarket.article.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import woowacourse.chongdaemarket.article.exception.ArticleErrorCode;
import woowacourse.chongdaemarket.common.repository.BaseTimeEntity;
import woowacourse.chongdaemarket.global.exception.MarketException;
import woowacourse.chongdaemarket.member.repository.Member;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @NotNull
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String thumbnailUrl;

    @Column(columnDefinition = "TEXT")
    private String productUrl;

    @NotNull
    private LocalDateTime deadline;

    @NotNull
    private String meetingAddress;

    private String meetingAddressDetail;

    @NotNull
    private Integer currentCount;

    @NotNull
    private Integer totalCount;

    @NotNull
    private Boolean isManualConfirmed;

    @NotNull
    private BigDecimal totalPrice;

    public boolean isCountFull() {
        return this.totalCount.equals(this.currentCount);
    }

    public boolean isDeadlineOver() {
        return LocalDateTime.now().isAfter(this.deadline);
    }

    public boolean isAutoConfirmed() {
        return isCountFull() && isDeadlineOver();
    }

    public Integer addParticipant() {
        if (this.currentCount >= this.totalCount) {
            throw new MarketException(ArticleErrorCode.ARTICLE_PARTICIPANT_ALREADY_FULL);
        }
        this.currentCount += 1;
        return this.currentCount;
    }
}
