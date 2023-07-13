package fisa.stockmilestone.modules.account.controller;

import fisa.stockmilestone.modules.account.dto.TokenRequest;
import fisa.stockmilestone.modules.account.dto.TokenResponse;
import fisa.stockmilestone.modules.account.service.AuthService;
import fisa.stockmilestone.modules.global.response.BaseResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @GetMapping("/")
    public BaseResponse<String> loginSuccessTest(){
        return new BaseResponse<>("success");
    }

    @GetMapping("/{oauthProvider}/link")
    public BaseResponse<String> generateLink(@PathVariable final String oauthProvider) {
        return new BaseResponse<>(authService.generateGoogleLink());
    }

    @PostMapping("/{oauthProvider}/token")
    public BaseResponse<TokenResponse> generateToken(@PathVariable final String oauthProvider, @RequestBody final TokenRequest tokenRequest) {
        TokenResponse tokenResponse = authService.generateTokenWithCode(tokenRequest.getCode());

        log.info("Controller - return AccessToken "+tokenResponse.getAccessToken());
        return new BaseResponse<>(tokenResponse);
    }
}
