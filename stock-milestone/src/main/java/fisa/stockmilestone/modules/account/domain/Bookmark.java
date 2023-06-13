package fisa.stockmilestone.modules.account.domain;

import fisa.stockmilestone.modules.board.domain.Post;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Bookmark {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Post post;
}
