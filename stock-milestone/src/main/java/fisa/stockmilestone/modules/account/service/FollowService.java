package fisa.stockmilestone.modules.account.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.domain.Follow;
import fisa.stockmilestone.modules.account.dto.GetFollowingRes;
import fisa.stockmilestone.modules.account.dto.PostFollowReq;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import fisa.stockmilestone.modules.account.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public FollowService(FollowRepository followRepository, AccountRepository accountRepository){
        this.followRepository = followRepository;
        this.accountRepository = accountRepository;
    }

    public void followAccount(PostFollowReq postFollowReq){
        Account following = accountRepository.findById(postFollowReq.getFollowingId()).orElseThrow();
        Account followed = accountRepository.findById(postFollowReq.getFollowedId()).orElseThrow();

        followRepository.save(Follow.builder().following(following).followed(followed).build());
    }

    public List<GetFollowingRes> showFollowing(Long accountId){
        Account owner = accountRepository.findById(accountId).orElseThrow();
        List<GetFollowingRes> getFollowingResList = owner.getFollowings().stream().map(following -> new GetFollowingRes(
                following.getFollowed().getId(),
                following.getFollowed().getNickName()
        )).collect(Collectors.toList());
        return getFollowingResList;
    }
}
