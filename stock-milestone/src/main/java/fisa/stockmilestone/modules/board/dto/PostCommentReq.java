package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Data
public class PostCommentReq {
    private Long accountId;
    private String content;
}
