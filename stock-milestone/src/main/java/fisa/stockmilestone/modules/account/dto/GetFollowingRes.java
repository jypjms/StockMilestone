package fisa.stockmilestone.modules.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetFollowingRes {
    private Long id;
    private String nickName;
}
