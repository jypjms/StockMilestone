package fisa.stockmilestone.modules.board.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.board.domain.Comment;
import fisa.stockmilestone.modules.board.domain.Post;
import fisa.stockmilestone.modules.board.dto.GetCommentRes;
import fisa.stockmilestone.modules.board.dto.PostCommentReq;
import fisa.stockmilestone.modules.board.repository.AccountRepository;
import fisa.stockmilestone.modules.board.repository.CommentRepository;
import fisa.stockmilestone.modules.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, AccountRepository accountRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    public List<GetCommentRes> getAllComments(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> {return new IllegalArgumentException("post doesn't exist");});
        List<Comment> comments = commentRepository.findByPost(post);
        Stream<Comment> stream = comments.stream();
        List<GetCommentRes> getCommentsRes = (List)stream.map((c) -> {
            Account acc = c.getAccount();
            GetCommentRes gcr = new GetCommentRes(acc.getId(), acc.getNickName(), c.getContent());
            return gcr;
        }).collect(Collectors.toList());

        return getCommentsRes;
    }

    public void postNewComment(Long postId, PostCommentReq postCommentReq) {
        Post post = postRepository.findById(postId).orElseThrow(() -> {return new IllegalArgumentException("post doesn't exist");});
        Account account = accountRepository.findById(postCommentReq.getAccountId()).orElseThrow(() -> {return new IllegalArgumentException("account doesn't exist");});
        Comment comment = Comment.builder()
                .post(post).account(account).likeNum(0).content(postCommentReq.getContent()).build();
        commentRepository.save(comment);
    }
}
