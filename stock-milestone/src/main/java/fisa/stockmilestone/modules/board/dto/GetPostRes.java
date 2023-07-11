package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Data
public class GetPostRes {
    private final Long id;
    private final String nickName;
    private final int likeNum;
    private final String content;
}
