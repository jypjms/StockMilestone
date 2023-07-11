package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Data
public class GetCommentRes {
    private final Long id;
    private final String nickName;
    private final String content;
}
