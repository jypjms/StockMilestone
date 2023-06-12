package fisa.stockmilestone.modules.account.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Profile {
    @Id @GeneratedValue
    private Long id;
    private Account account;
    private String imgUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
