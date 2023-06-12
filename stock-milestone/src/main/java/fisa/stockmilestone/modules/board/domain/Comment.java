package fisa.stockmilestone.modules.board.domain;

import fisa.stockmilestone.modules.account.domain.Account;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private Account account;
    private Post post;
    private Integer likeNum;
    private String content;
    //상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
