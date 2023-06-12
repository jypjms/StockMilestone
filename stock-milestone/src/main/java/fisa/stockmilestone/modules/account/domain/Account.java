package fisa.stockmilestone.modules.account.domain;

import fisa.stockmilestone.modules.board.domain.Post;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Account {

    @Id @GeneratedValue
    private Long id;
    private String nickName;
    private Integer commentNum;
    private Integer postNum;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<UserLikePost> likePosts = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
