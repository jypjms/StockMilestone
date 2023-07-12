package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentReq {
    private Long accountId;
    private String content;
}
