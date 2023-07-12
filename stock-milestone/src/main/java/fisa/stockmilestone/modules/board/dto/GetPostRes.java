package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetPostRes {
    private Long id;
    private String nickName;
    private int likeNum;
    private String content;
}
