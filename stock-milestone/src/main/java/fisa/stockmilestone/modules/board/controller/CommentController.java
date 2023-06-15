package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.board.dto.GetCommentsRes;
import fisa.stockmilestone.modules.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/app"})
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping({"/posts/{postId}/comments"})
    public List<GetCommentsRes> getAllComments(@PathVariable Long postId){
        List<GetCommentsRes> getCommentRes = commentService.getAllComments(postId);
        return getCommentRes;
    }
}
