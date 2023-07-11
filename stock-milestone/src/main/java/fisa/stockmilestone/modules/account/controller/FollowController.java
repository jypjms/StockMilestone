package fisa.stockmilestone.modules.account.controller;

import fisa.stockmilestone.modules.account.dto.GetFollowingRes;
import fisa.stockmilestone.modules.account.dto.PostFollowReq;
import fisa.stockmilestone.modules.account.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow")
    public void followAccount(@RequestBody PostFollowReq postFollowReq) {
        followService.followAccount(postFollowReq);
    }

    @GetMapping("/account/{accountId}/following-list")
    public List<GetFollowingRes> showFollowing(@PathVariable Long accountId) {
        return followService.showFollowing(accountId);
    }
}