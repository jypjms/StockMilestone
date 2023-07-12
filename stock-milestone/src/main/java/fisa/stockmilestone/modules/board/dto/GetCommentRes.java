package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentRes {
    private Long id;
    private String nickName;
    private String content;
}
