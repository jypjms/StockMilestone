package fisa.stockmilestone.modules.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GetCommentRes {
    private Long id;
    private String nickName;
    private String content;
}
