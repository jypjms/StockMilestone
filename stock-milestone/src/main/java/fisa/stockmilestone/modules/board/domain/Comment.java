package fisa.stockmilestone.modules.board.domain;

import fisa.stockmilestone.modules.account.domain.Account;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    private Integer likeNum;
    private String content;
    //상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
