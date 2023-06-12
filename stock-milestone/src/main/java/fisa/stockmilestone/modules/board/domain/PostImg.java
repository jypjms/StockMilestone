package fisa.stockmilestone.modules.board.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class PostImg {
    @Id
    @GeneratedValue
    private Long id;
    private Post post;
    private String imgUrl;
    //상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
