package fisa.stockmilestone.modules.account.domain;

import fisa.stockmilestone.modules.board.domain.Comment;
import fisa.stockmilestone.modules.board.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private List<Follow> followings = new ArrayList<>();

    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL)
    private List<Follow> followeds = new ArrayList<>();
}
