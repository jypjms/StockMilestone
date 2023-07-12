package fisa.stockmilestone.modules.board.domain;

import fisa.stockmilestone.modules.account.domain.Account;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    private Integer likeNum;
    private String content;
    //상태
    @Enumerated(EnumType.STRING)
    private CommentStatus status;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void updateComment(String content){
        this.content = content;
    }

    public void deleteComment(){this.status = CommentStatus.DELETED;}

}
