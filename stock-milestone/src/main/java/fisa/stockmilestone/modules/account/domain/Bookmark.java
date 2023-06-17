package fisa.stockmilestone.modules.account.domain;

import fisa.stockmilestone.modules.board.domain.Post;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Bookmark {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Post post;
}
