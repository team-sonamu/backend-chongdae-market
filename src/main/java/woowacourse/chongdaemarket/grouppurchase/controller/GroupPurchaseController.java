package woowacourse.chongdaemarket.grouppurchase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.GroupPurchaseGetByIdResponse;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.ParticipationCountRequest;
import woowacourse.chongdaemarket.grouppurchase.controller.dto.ParticipationCountResponse;
import woowacourse.chongdaemarket.grouppurchase.service.GroupPurchaseService;

@RequiredArgsConstructor
@Controller
public class GroupPurchaseController {

    private final GroupPurchaseService groupPurchaseService;

    @GetMapping("/group-purchases/{group-purchase-id}")
    public ResponseEntity<GroupPurchaseGetByIdResponse> getGroupPurchaseById(
            @PathVariable(name = "group-purchase-id") Long groupPurchaseId) {
        GroupPurchaseGetByIdResponse response = groupPurchaseService.getGroupPurchaseById(groupPurchaseId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/participation")
    public ResponseEntity<ParticipationCountResponse> participateGroupPurchase(
            @RequestBody ParticipationCountRequest request) {
        ParticipationCountResponse response = groupPurchaseService.participateGroupPurchaseById(request);
        return ResponseEntity.ok(response);
    }
}
