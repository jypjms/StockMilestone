package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Data
public class PostCommentReq {
    private final Long accountId;
    private final String content;
}
