package fisa.stockmilestone.modules.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenRequest {
    private final String code;
}
