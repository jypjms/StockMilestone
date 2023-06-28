package fisa.stockmilestone.modules.board.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.board.domain.Comment;
import fisa.stockmilestone.modules.board.domain.Post;
import fisa.stockmilestone.modules.board.dto.GetCommentRes;
import fisa.stockmilestone.modules.board.dto.PatchCommentReq;
import fisa.stockmilestone.modules.board.dto.PostCommentReq;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import fisa.stockmilestone.modules.board.repository.CommentRepository;
import fisa.stockmilestone.modules.board.repository.PostRepository;
import fisa.stockmilestone.modules.global.response.BaseException;
import fisa.stockmilestone.modules.global.response.BaseResponse;
import fisa.stockmilestone.modules.global.response.BaseResponseStatus;
import fisa.stockmilestone.modules.global.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fisa.stockmilestone.modules.global.response.BaseResponseStatus.*;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    public List<GetCommentRes> getAllComments(Long postId) throws BaseException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new BaseException(new ExceptionResponse(POST_NOT_FOUND)));
        List<Comment> comments = commentRepository.findByPost(post);
        Stream<Comment> stream = comments.stream();
        List<GetCommentRes> getCommentsRes = (List) stream.map((c) -> {
            Account acc = c.getAccount();
            GetCommentRes gcr = new GetCommentRes(acc.getId(), acc.getNickName(), c.getContent());
            return gcr;
        }).collect(Collectors.toList());

        return getCommentsRes;
    }

    @Transactional
    public void postNewComment(Long postId, PostCommentReq postCommentReq) throws BaseException {
        Post post = postRepository.findById(postId).orElseThrow(() -> {
            return new BaseException(new ExceptionResponse(POST_NOT_FOUND));
        });
        Account account = accountRepository.findById(postCommentReq.getAccountId()).orElseThrow(() -> {
            return new BaseException(new ExceptionResponse(ACCOUNT_NOT_FOUND));
        });
        Comment comment = Comment.builder()
                .post(post).account(account).likeNum(0).content(postCommentReq.getContent()).build();
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Long commentId, PatchCommentReq patchCommentReq) throws BaseException {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> {
            return new BaseException(new ExceptionResponse(COMMENT_NOT_FOUND));
        });
        comment.updateComment(patchCommentReq.getContent());
    }

    @Transactional
    public void deleteComment(Long commentId) throws BaseException {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> {
            return new BaseException(new ExceptionResponse(COMMENT_NOT_FOUND));
        });
        comment.deleteComment();
    }


}
