package fisa.stockmilestone.modules.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostImg {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;
    private String imgUrl;
    //상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
