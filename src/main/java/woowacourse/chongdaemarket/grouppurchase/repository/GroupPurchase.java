package woowacourse.chongdaemarket.grouppurchase.repository;

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
import woowacourse.chongdaemarket.common.repository.BaseTimeEntity;
import woowacourse.chongdaemarket.member.repository.Member;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
public class GroupPurchase extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private String thumbnailUrl;

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
}
