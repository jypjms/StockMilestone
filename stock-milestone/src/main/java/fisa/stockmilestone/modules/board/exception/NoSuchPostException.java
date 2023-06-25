package fisa.stockmilestone.modules.board.exception;

public class NoSuchPostException extends RuntimeException{
    public NoSuchPostException(final String message){
        super(message);
    }

    public NoSuchPostException(){
        this("존재하지 않는 게시글입니다.");
    }
}
