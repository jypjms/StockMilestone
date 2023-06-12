package fisa.stockmilestone.modules.board.domain;

import fisa.stockmilestone.modules.account.domain.Account;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    private int likeNum;
    private String content;

    @Enumerated(EnumType.STRING)
    private PostStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
