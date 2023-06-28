package fisa.stockmilestone.modules.global.response;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     * 2000 : Request 오류
     */
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    POST_NOT_FOUND(false,2001,"게시글을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(false, 2002, "댓글을 찾을 수 없습니다."),
    ACCOUNT_NOT_FOUND(false, 2003, "계정을 찾을 수 없습니다"),

    /**
     * 3000 : Response 오류
     */
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message){
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
