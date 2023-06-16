package fisa.stockmilestone.modules.board.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.board.domain.Comment;
import fisa.stockmilestone.modules.board.domain.Post;
import fisa.stockmilestone.modules.board.dto.GetCommentsRes;
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

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<GetCommentsRes> getAllComments(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> {return new IllegalArgumentException("post doesn't exist");});
        List<Comment> comments = commentRepository.findByPost(post);
        Stream<Comment> stream = comments.stream();
        List<GetCommentsRes> getCommentsRes = (List)stream.map((c) -> {
            Account acc = c.getAccount();
            GetCommentsRes gcr = new GetCommentsRes(acc.getNickName(), c.getContent());
            return gcr;
        }).collect(Collectors.toList());

        return getCommentsRes;
    }
}
