package fisa.stockmilestone.modules.account.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
public class Profile {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Account account;
    private String imgUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
