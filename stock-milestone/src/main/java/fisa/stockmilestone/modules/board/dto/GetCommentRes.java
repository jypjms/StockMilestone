package fisa.stockmilestone.modules.board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GetCommentRes {
    private Long id;
    private String nickName;
    private String content;
}
