package fisa.stockmilestone.modules.account.dto;

import lombok.Data;

@Data
public class PostFollowReq {
    private final Long followingId;
    private final Long followedId;
}
