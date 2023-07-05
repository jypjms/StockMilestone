package fisa.stockmilestone.modules.board.exception;

import java.util.Objects;

public class NoSuchPostException extends RuntimeException{
    public NoSuchPostException(final long postId){
        super(String.format("%d번 게시글을 찾을 수 없습니다.", postId));
    }
}
